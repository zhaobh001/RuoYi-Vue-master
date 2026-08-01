package com.ruoyi.web.controller.system.deliveryverify;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.ruoyi.common.config.RuoYiConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 配送核验单 PDF 生成工具类。
 *
 * <p>版式参考 <code>tmpF144.tmp.pdf</code>（北京天诚同创电气有限公司推式出库单）：
 * 横向 A4，每页重复表头（公司标题 + 右上条形码 + 六栏信息 + 14 列明细表列头），
 * 每页底部有 <b>制单人 / 系统操作员 / 第 X 页</b> 页脚；
 * 明细表跨页自动分页；末页追加 <b>小计</b> 行与 <b>库管员 / 配送人 / 领用人</b> 签字区，
 * 若前端上传签名图 base64 则将其嵌入领用人签字位。
 *
 * <p>生成的 PDF 落到 {@link RuoYiConfig#getProfile()}/delivery-verify/ 下，
 * 通过若依资源前缀 <code>/profile</code> 暴露访问。
 *
 * @author ruoyi
 */
public class DeliveryVerifyPdfUtil
{
    /** 输出根目录（相对 profile） */
    public static final String SUB_DIR = "/delivery-verify/";

    /** 签名图子目录 */
    public static final String SIGN_SUB_DIR = "/delivery-verify/signature/";

    /** PDF 相对访问前缀，与 {@code Constants.RESOURCE_PREFIX} 保持一致 */
    public static final String URL_PREFIX = "/profile" + SUB_DIR;

    /** 签名图访问前缀 */
    public static final String SIGN_URL_PREFIX = "/profile" + SIGN_SUB_DIR;

    /** 单据抬头（可按需替换为配置化） */
    private static final String COMPANY_TITLE = "北京天诚同创电气有限公司推式出库单";

    private static final SimpleDateFormat FILE_TIME_FMT = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static final SimpleDateFormat DISPLAY_FMT = new SimpleDateFormat("yyyyMMdd");

    /** 明细表头（14 列，与参考 PDF 对齐） */
    private static final String[] TABLE_HEADERS = new String[] {
            "序号", "行号", "物料编码", "物料描述", "单位", "应发数量", "实发数量",
            "存储类别", "发料仓库", "货位", "批次号", "ABC分类", "托盘号", "备注"
    };

    /** 明细表 14 列相对宽度 */
    private static final float[] TABLE_WIDTHS = new float[] {
            0.6f, 0.6f, 1.4f, 3.0f, 0.6f, 0.9f, 0.9f, 1.0f, 1.0f, 0.9f, 1.5f, 0.9f, 1.2f, 1.4f
    };

    /**
     * 生成核验单 PDF（兼容旧调用：单一签名，作为「领用人」签字）。
     *
     * @see #buildPdf(String, String, String, List, List, String, String, String)
     */
    public static String buildPdf(String inBillNo,
                                  String deptName,
                                  String groupName,
                                  List<Map<String, Object>> details,
                                  List<Map<String, Object>> exceptions,
                                  String operatorName,
                                  String signBase64)
    {
        // 旧调用只有一个签名，保留原语义：视作领用人签字，配送人留空
        return buildPdf(inBillNo, deptName, groupName, details, exceptions,
                operatorName, signBase64, null);
    }

    /**
     * 生成核验单 PDF。
     *
     * @param inBillNo             单据号（{@code Deliverybill.inbillno}，同时作为条形码值）
     * @param deptName             领料单位（{@code Deliverybill.data10}，若为空取工位/产线兜底）
     * @param groupName            班组（当前实现由 data10 取值）
     * @param details              明细集合（每一项来自前端 {@code DeliveryVerifyDetail}）
     * @param exceptions           异常明细集合（当前版式未在正表内展示，仍保留参数以便扩展）
     * @param operatorName         操作人姓名（用作制单人/系统操作员）
     * @param receiverSignBase64   领用人签字图片 base64（可为空，允许 data:image/png;base64,... 前缀）
     * @param delivererSignBase64  配送人签字图片 base64（可为空）
     * @return PDF 相对访问 URL，如 /profile/delivery-verify/xxx.pdf；生成失败时返回 null
     */
    public static String buildPdf(String inBillNo,
                                  String deptName,
                                  String groupName,
                                  List<Map<String, Object>> details,
                                  List<Map<String, Object>> exceptions,
                                  String operatorName,
                                  String receiverSignBase64,
                                  String delivererSignBase64)
    {
        // 确保目录存在
        String baseDir = RuoYiConfig.getProfile() + SUB_DIR;
        File dir = new File(baseDir);
        if (!dir.exists() && !dir.mkdirs())
        {
            return null;
        }

        String safeBillNo = (inBillNo == null ? "verify" : inBillNo).replaceAll("[^0-9A-Za-z_\\-]", "_");
        String fileName = safeBillNo + "_" + FILE_TIME_FMT.format(new Date()) + ".pdf";
        String absPath = baseDir + fileName;

        // 横向 A4，为顶部页眉预留约 130pt，底部页脚约 40pt
        Document document = new Document(PageSize.A4.rotate(), 24, 24, 140, 40);
        FileOutputStream fos = null;
        boolean success = false;
        try
        {
            fos = new FileOutputStream(absPath);
            PdfWriter writer = PdfWriter.getInstance(document, fos);

            // 中文字体
            BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font titleFont = new Font(baseFont, 16, Font.BOLD);
            Font labelFont = new Font(baseFont, 9, Font.NORMAL);
            Font headerFont = new Font(baseFont, 9, Font.BOLD);
            Font normalFont = new Font(baseFont, 9, Font.NORMAL);
            Font footerFont = new Font(baseFont, 9, Font.NORMAL);

            // 页眉/页脚事件（每页重复）
            HeaderFooterEvent event = new HeaderFooterEvent(
                    baseFont, titleFont, labelFont, footerFont,
                    inBillNo, deptName, groupName, operatorName);
            writer.setPageEvent(event);

            document.open();

            // 明细表格
            PdfPTable table = new PdfPTable(TABLE_HEADERS.length);
            table.setWidthPercentage(100);
            table.setWidths(TABLE_WIDTHS);
            table.setHeaderRows(1); // 表头随跨页自动重复
            for (String h : TABLE_HEADERS)
            {
                PdfPCell cell = new PdfPCell(new Phrase(h, headerFont));
                cell.setBackgroundColor(new BaseColor(240, 240, 240));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setPadding(4f);
                table.addCell(cell);
            }

            double totalPlan = 0d;
            double totalActual = 0d;
            if (details != null)
            {
                int idx = 0;
                for (Map<String, Object> d : details)
                {
                    idx++;
                    double plan = asDouble(d, "planQty");
                    double actual = asDouble(d, "actualQty");
                    totalPlan += plan;
                    totalActual += actual;

                    addBodyCell(table, String.valueOf(idx), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, String.valueOf(idx), normalFont, Element.ALIGN_CENTER);   // 行号
                    addBodyCell(table, str(d, "materialCode"), normalFont, Element.ALIGN_LEFT);
                    addBodyCell(table, str(d, "materialName"), normalFont, Element.ALIGN_LEFT);
                    addBodyCell(table, strOrDefault(d, "unit", "EA"), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, trimZero(plan), normalFont, Element.ALIGN_RIGHT);
                    addBodyCell(table, trimZero(actual), normalFont, Element.ALIGN_RIGHT);
                    addBodyCell(table, str(d, "storageType"), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, str(d, "subInventoryCode"), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, str(d, "storeSite"), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, str(d, "batchNo"), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, str(d, "abcClass"), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, str(d, "palletNo"), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, str(d, "remark"), normalFont, Element.ALIGN_LEFT);
                }
            }

            // 小计行（占前 5 列合并）
            PdfPCell subtotalLabel = new PdfPCell(new Phrase("小计", headerFont));
            subtotalLabel.setColspan(5);
            subtotalLabel.setHorizontalAlignment(Element.ALIGN_CENTER);
            subtotalLabel.setPadding(4f);
            subtotalLabel.setBackgroundColor(new BaseColor(248, 249, 250));
            table.addCell(subtotalLabel);
            addBodyCell(table, trimZero(totalPlan), headerFont, Element.ALIGN_RIGHT);
            addBodyCell(table, trimZero(totalActual), headerFont, Element.ALIGN_RIGHT);
            // 后 7 列留空
            for (int i = 0; i < 7; i++)
            {
                addBodyCell(table, "", normalFont, Element.ALIGN_CENTER);
            }
            table.setSpacingAfter(6f);
            document.add(table);

            // 签字区（作为最后添加的内容，iText 会顺流放到最后一页）
            document.add(buildSignatureBlock(baseFont, headerFont, normalFont,
                    receiverSignBase64, delivererSignBase64));

            // 关闭 Document（flush 到 fos），随后 finally 再关 fos
            document.close();
            success = true;
        }
        catch (IOException | DocumentException ex)
        {
            return cleanupOnFail(absPath, document, fos);
        }
        finally
        {
            if (document.isOpen())
            {
                try
                {
                    document.close();
                }
                catch (Exception ignore)
                {
                    // ignore
                }
            }
            if (fos != null)
            {
                try
                {
                    fos.close();
                }
                catch (IOException ignore)
                {
                    // ignore
                }
            }
        }

        if (!success)
        {
            File bad = new File(absPath);
            if (bad.exists())
            {
                bad.delete();
            }
            return null;
        }
        return URL_PREFIX + fileName;
    }

    // ---------------------------------------------------------------------
    // 页眉页脚事件
    // ---------------------------------------------------------------------

    /**
     * 每一页顶部渲染：标题 + 右上条形码 + 六栏信息区（领料单位 / 物料 / 发料类型 /
     * 搬运单号 / 任务号 / 配件数量 / 日期 / 装配件描述），
     * 底部渲染：制单人 / 系统操作员 / 第 X 页。
     */
    private static final class HeaderFooterEvent extends PdfPageEventHelper
    {
        private final BaseFont baseFont;
        private final Font titleFont;
        private final Font labelFont;
        private final Font footerFont;
        private final String billNo;
        private final String deptName;
        private final String groupName;
        private final String operatorName;
        private final String printDate;

        HeaderFooterEvent(BaseFont baseFont, Font titleFont, Font labelFont, Font footerFont,
                          String billNo, String deptName, String groupName, String operatorName)
        {
            this.baseFont = baseFont;
            this.titleFont = titleFont;
            this.labelFont = labelFont;
            this.footerFont = footerFont;
            this.billNo = nvl(billNo);
            this.deptName = nvl(deptName);
            this.groupName = nvl(groupName);
            this.operatorName = nvl(operatorName);
            this.printDate = DISPLAY_FMT.format(new Date());
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document)
        {
            try
            {
                Rectangle page = document.getPageSize();

                // ---- 顶部标题 + 条形码 ----
                float titleY = page.getTop() - 30f;
                PdfContentByte cb = writer.getDirectContent();

                cb.beginText();
                cb.setFontAndSize(baseFont, 16);
                float titleWidth = baseFont.getWidthPoint(COMPANY_TITLE, 16);
                cb.setTextMatrix(page.getWidth() / 2f - titleWidth / 2f, titleY);
                cb.showText(COMPANY_TITLE);
                cb.endText();

                // 条形码（右上角），使用单据号编码
                if (!billNo.isEmpty())
                {
                    Barcode128 barcode = new Barcode128();
                    barcode.setCode(billNo);
                    barcode.setBarHeight(22f);
                    barcode.setX(1.0f);
                    barcode.setSize(7f);
                    barcode.setBaseline(7f);
                    com.itextpdf.text.Image barcodeImg = barcode.createImageWithBarcode(cb, null, null);
                    barcodeImg.setAbsolutePosition(page.getWidth() - document.rightMargin() - barcodeImg.getScaledWidth(),
                            titleY - barcodeImg.getScaledHeight());
                    document.add(barcodeImg);
                }

                // ---- 六栏信息区 ----
                PdfPTable info = new PdfPTable(6);
                info.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
                info.setLockedWidth(true);
                info.setWidths(new float[] { 1.1f, 3.0f, 1.1f, 3.0f, 1.1f, 3.0f });

                addInfoCell(info, "领料单位：" + deptName);
                addInfoCell(info, "物料：");
                addInfoCell(info, "发料类型：");
                addInfoCell(info, "搬运单号：");
                addInfoCell(info, "任务号：" + billNo);
                addInfoCell(info, "配件数量：");
                addInfoCell(info, "日期：" + printDate);
                addInfoCell(info, "装配件描述：");
                // 让第 2 行的"装配件描述"合并占 5 列显得更接近参考版式
                // 上面已经写满 8 单元格 = 2 行，无需额外合并

                float infoY = titleY - 32f;
                info.writeSelectedRows(0, -1, document.leftMargin(), infoY, writer.getDirectContent());

                // ---- 底部页脚 ----
                PdfPTable footer = new PdfPTable(3);
                footer.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
                footer.setLockedWidth(true);
                footer.setWidths(new float[] { 1f, 1f, 1f });

                footer.addCell(footerCell("制单人：" + operatorName, Element.ALIGN_LEFT));
                footer.addCell(footerCell("系统操作员：" + operatorName, Element.ALIGN_CENTER));
                footer.addCell(footerCell("第 " + writer.getPageNumber() + " 页", Element.ALIGN_RIGHT));

                footer.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin() - 6,
                        writer.getDirectContent());
            }
            catch (DocumentException ignore)
            {
                // 页眉页脚失败不影响正文
            }
        }

        private void addInfoCell(PdfPTable table, String text)
        {
            PdfPCell cell = new PdfPCell(new Phrase(text, labelFont));
            cell.setPadding(4f);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setMinimumHeight(18f);
            table.addCell(cell);
        }

        private PdfPCell footerCell(String text, int align)
        {
            PdfPCell cell = new PdfPCell(new Phrase(text, footerFont));
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(align);
            return cell;
        }
    }

    // ---------------------------------------------------------------------
    // 签字区
    // ---------------------------------------------------------------------

    private static PdfPTable buildSignatureBlock(BaseFont baseFont, Font headerFont, Font normalFont,
                                                 String receiverSignBase64,
                                                 String delivererSignBase64) throws DocumentException
    {
        PdfPTable sig = new PdfPTable(3);
        sig.setWidthPercentage(100);
        sig.setWidths(new float[] { 1f, 1f, 1f });
        sig.setSpacingBefore(10f);
        sig.setKeepTogether(true); // 尽量避免签字块被拆到两页

        // 标签行
        sig.addCell(sigLabelCell("库管员：", headerFont));
        sig.addCell(sigLabelCell("配送人：", headerFont));
        sig.addCell(sigLabelCell("领用人：", headerFont));

        // 签字区：库管员留空 / 配送人嵌入配送人签字 / 领用人嵌入领用人签字。
        // 领用人下方不再叠加 operatorName —— 签字人身份已在图片里，避免误导。
        sig.addCell(sigContentCell(null, normalFont));
        sig.addCell(buildSignatureCell(delivererSignBase64, null, normalFont));
        sig.addCell(buildSignatureCell(receiverSignBase64, null, normalFont));

        return sig;
    }

    /**
     * 构造一个签字单元格：若 base64 可解析则嵌入签名图，同时可附一行姓名文本。
     * 库管员/领用人/配送人签字栏均要求无边框。
     *
     * @param signBase64 签名图 base64（可为空）
     * @param nameLabel  附在签字下方的姓名/单位文本（可为空）
     * @param normalFont 正文字体
     */
    private static PdfPCell buildSignatureCell(String signBase64, String nameLabel, Font normalFont)
    {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setMinimumHeight(80f);
        cell.setPadding(4f);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        byte[] sign = decodeSignatureImage(signBase64);
        if (sign != null)
        {
            try
            {
                com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(sign);
                image.scaleToFit(180f, 70f);
                image.setAlignment(Element.ALIGN_CENTER);
                cell.addElement(image);
            }
            catch (Exception ignore)
            {
                // 签名图无法解析时留空
            }
        }
        if (nameLabel != null && !nameLabel.isEmpty())
        {
            Paragraph name = new Paragraph(nameLabel, normalFont);
            name.setAlignment(Element.ALIGN_CENTER);
            cell.addElement(name);
        }
        return cell;
    }

    private static PdfPCell sigLabelCell(String text, Font font)
    {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(4f);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setMinimumHeight(20f);
        return cell;
    }

    private static PdfPCell sigContentCell(String text, Font font)
    {
        PdfPCell cell = new PdfPCell(new Phrase(text == null ? "" : text, font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(4f);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setMinimumHeight(80f);
        return cell;
    }

    // ---------------------------------------------------------------------
    // 明细表格辅助
    // ---------------------------------------------------------------------

    private static void addBodyCell(PdfPTable table, String text, Font font, int align)
    {
        PdfPCell cell = new PdfPCell(new Phrase(text == null ? "" : text, font));
        cell.setHorizontalAlignment(align);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(3f);
        table.addCell(cell);
    }

    private static String str(Map<String, Object> m, String key)
    {
        if (m == null)
        {
            return "";
        }
        Object v = m.get(key);
        return v == null ? "" : v.toString();
    }

    private static String strOrDefault(Map<String, Object> m, String key, String defaultVal)
    {
        String v = str(m, key);
        return v.isEmpty() ? defaultVal : v;
    }

    private static double asDouble(Map<String, Object> m, String key)
    {
        String s = str(m, key);
        if (s.isEmpty())
        {
            return 0d;
        }
        try
        {
            return Double.parseDouble(s);
        }
        catch (NumberFormatException e)
        {
            return 0d;
        }
    }

    /** 去除小数末尾的 0，如 3.0 → 3；15.50 → 15.5 */
    private static String trimZero(double val)
    {
        if (val == (long) val)
        {
            return String.valueOf((long) val);
        }
        return String.valueOf(val);
    }

    private static String nvl(String s)
    {
        return s == null ? "" : s;
    }

    /** 生成失败时清理已经写了一半的坏 PDF 与流 */
    private static String cleanupOnFail(String absPath, Document document, FileOutputStream fos)
    {
        if (document != null && document.isOpen())
        {
            try
            {
                document.close();
            }
            catch (Exception ignore)
            {
                // ignore
            }
        }
        if (fos != null)
        {
            try
            {
                fos.close();
            }
            catch (IOException ignore)
            {
                // ignore
            }
        }
        File bad = new File(absPath);
        if (bad.exists())
        {
            bad.delete();
        }
        return null;
    }

    // ---------------------------------------------------------------------
    // 签名图存储
    // ---------------------------------------------------------------------

    /** 解析 base64 签名图，兼容 data URL 前缀 */
    private static byte[] decodeSignatureImage(String signBase64)
    {
        if (signBase64 == null || signBase64.isEmpty())
        {
            return null;
        }
        String pure = signBase64;
        int comma = pure.indexOf(',');
        if (pure.startsWith("data:") && comma > 0)
        {
            pure = pure.substring(comma + 1);
        }
        try
        {
            return Base64.getDecoder().decode(pure);
        }
        catch (IllegalArgumentException ignore)
        {
            return null;
        }
    }

    /**
     * 将签名图 base64 写入 profile/delivery-verify/signature/ 下，返回相对访问 URL。
     * 用于避免签名图 base64 直接写入 Oracle VARCHAR2 列时触发 ORA-01461。
     *
     * @param inBillNo   单据号，参与文件名以便回溯
     * @param signBase64 签名图 base64（可含 data URL 前缀）
     * @return 相对访问 URL，如 /profile/delivery-verify/signature/xxx.png；解析或落盘失败返回 null
     */
    public static String saveSignatureImage(String inBillNo, String signBase64)
    {
        byte[] bytes = decodeSignatureImage(signBase64);
        if (bytes == null || bytes.length == 0)
        {
            return null;
        }

        String dirPath = RuoYiConfig.getProfile() + SIGN_SUB_DIR;
        File dir = new File(dirPath);
        if (!dir.exists() && !dir.mkdirs())
        {
            return null;
        }

        String safeBillNo = (inBillNo == null ? "sign" : inBillNo).replaceAll("[^0-9A-Za-z_\\-]", "_");
        String ext = sniffImageExt(bytes);
        String fileName = safeBillNo + "_" + FILE_TIME_FMT.format(new Date()) + "." + ext;
        File out = new File(dirPath + fileName);
        try (FileOutputStream fos = new FileOutputStream(out))
        {
            fos.write(bytes);
            fos.flush();
        }
        catch (IOException ex)
        {
            if (out.exists())
            {
                out.delete();
            }
            return null;
        }
        return SIGN_URL_PREFIX + fileName;
    }

    /** 通过字节头简单识别 png / jpg，其余一律 png */
    private static String sniffImageExt(byte[] bytes)
    {
        if (bytes.length >= 4
                && (bytes[0] & 0xFF) == 0x89
                && (bytes[1] & 0xFF) == 0x50
                && (bytes[2] & 0xFF) == 0x4E
                && (bytes[3] & 0xFF) == 0x47)
        {
            return "png";
        }
        if (bytes.length >= 3
                && (bytes[0] & 0xFF) == 0xFF
                && (bytes[1] & 0xFF) == 0xD8
                && (bytes[2] & 0xFF) == 0xFF)
        {
            return "jpg";
        }
        return "png";
    }
}

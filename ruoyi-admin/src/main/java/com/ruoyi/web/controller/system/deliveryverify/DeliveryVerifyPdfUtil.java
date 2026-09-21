package com.ruoyi.web.controller.system.deliveryverify;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.ruoyi.common.config.RuoYiConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 配送核验单 PDF 生成工具类。
 *
 * <p>版式参考 {@code tmp5136.tmp.pdf} / {@code 20260915213454.tmp.xls}
 * （北京天诚同创电气有限公司推式出库单，单据号 OUT202609080042）：
 * 横向 Letter，每页重复表头（左侧加粗公司标题 + 右上角大号单据号 + 带框两行信息区 +
 * 12 列明细表列头），每页右下角有 <b>第 X 页，共 Y 页</b>；
 * 明细表跨页自动分页；末页追加 <b>小计</b> 行，表体下方一行
 * <b>制单员 / 库管员 / 配送人 / 领用人</b>，配送人、领用人处可内嵌签名图。
 *
 * <p>头信息取值：
 * <ul>
 *   <li>单据号（右上角大号字）：出库凭证号 DELIVERYPROOF.PROOFNO</li>
 *   <li>领料单位：DELIVERYBILL.WIP_ENTITY_NAME（取第一行）</li>
 *   <li>搬运单号：DELIVERYPROOF.ORDERNO</li>
 *   <li>任务号：DELIVERYPROOF.PO_NUMBER</li>
 *   <li>日期：当前日期 YYYYMMDD</li>
 * </ul>
 *
 * <p>明细取值（12 列）：
 * <ul>
 *   <li>物料编码：PM_MATERIAL.MATCODE；物料描述：PM_MATERIAL.MATNAME；单位：物料单位</li>
 *   <li>应发数量：DELIVERYBILL.TASKQTY；实发数量：DELIVERYBILL.FINISHQTY</li>
 *   <li>发料仓库：DELIVERYBILL.SUBINVENTORY_CODE；货位：DELIVERYBILL.HINTDESC</li>
 *   <li>批次号：DELIVERYBILL.BATCHNO；托盘号：DELIVERYBILL.PALLETNO；备注：DELIVERYPROOF.PRODESC</li>
 * </ul>
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

    /** 单据抬头 */
    private static final String COMPANY_TITLE = "北京天诚同创电气有限公司推式出库单";

    private static final SimpleDateFormat FILE_TIME_FMT = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static final SimpleDateFormat DISPLAY_FMT = new SimpleDateFormat("yyyyMMdd");

    /** 明细表头（12 列，与参考 Excel/PDF 对齐，含批次号列） */
    private static final String[] TABLE_HEADERS = new String[] {
            "序号", "行号", "物料编码", "物料描述", "单位", "应发数量", "实发数量",
            "发料仓库", "货位", "批次号", "托盘号", "备注"
    };

    /** 明细表 12 列相对宽度（按参考 PDF 网格列宽比例） */
    private static final float[] TABLE_WIDTHS = new float[] {
            0.6f, 1.05f, 1.45f, 3.75f, 0.72f, 1.28f, 1.18f, 1.55f, 1.58f, 2.2f, 1.06f, 1.28f
    };

    /**
     * 生成核验单 PDF。
     *
     * @param billNo               单据号（用作文件名前缀）
     * @param proofNo              出库凭证号（DELIVERYPROOF.PROOFNO，右上角大号单据号）
     * @param wipEntityName        领料单位（DELIVERYBILL.WIP_ENTITY_NAME，取第一行）
     * @param orderno              搬运单号（DELIVERYPROOF.ORDERNO）
     * @param poNumber             任务号（DELIVERYPROOF.PO_NUMBER）
     * @param remark               备注（DELIVERYPROOF.PRODESC，明细每行相同）
     * @param lines                明细行，每项需包含 materialCode/materialName/unit/taskQty/
     *                             finishQty/subInventoryCode/hintDesc/batchNo/palletNo
     * @param operatorName         操作人姓名（用作制单员）
     * @param storekeeperName      库管员姓名（DELIVERYPROOF.DEPOTNO→STOREROOM.ROOMCHARGER→EMPLOYEE.EMP_NAME）
     * @param receiverSignBase64   领用人签字图片 base64（可为空，允许 data:image/png;base64,... 前缀）
     * @param delivererSignBase64  配送人签字图片 base64（可为空）
     * @return PDF 相对访问 URL，如 /profile/delivery-verify/xxx.pdf；生成失败时返回 null
     */
    public static String buildPdf(String billNo,
                                  String proofNo,
                                  String wipEntityName,
                                  String orderno,
                                  String poNumber,
                                  String remark,
                                  List<Map<String, Object>> lines,
                                  String operatorName,
                                  String storekeeperName,
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

        String safeBillNo = (billNo == null ? "verify" : billNo).replaceAll("[^0-9A-Za-z_\\-]", "_");
        String fileName = safeBillNo + "_" + FILE_TIME_FMT.format(new Date()) + ".pdf";
        String absPath = baseDir + fileName;

        // 横向 Letter（与参考 PDF 792x612 一致）。左右边距与参考版心对齐（约 35/40）；
        // 顶部信息区两行固定 16pt、顶边距页顶 64pt，故正文上边距取 64+16*2=96，
        // 使明细表头紧贴信息区底边（表头与正文之间无空行）；底部页脚预留 40pt。
        Document document = new Document(new Rectangle(792f, 612f), 35, 40, 96, 40);
        FileOutputStream fos = null;
        boolean success = false;
        try
        {
            fos = new FileOutputStream(absPath);
            PdfWriter writer = PdfWriter.getInstance(document, fos);

            // 中文字体
            BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font titleFont = new Font(baseFont, 15, Font.BOLD);
            Font labelFont = new Font(baseFont, 10, Font.NORMAL);
            Font headerFont = new Font(baseFont, 9, Font.BOLD);
            Font normalFont = new Font(baseFont, 9, Font.NORMAL);
            Font footerFont = new Font(baseFont, 9, Font.NORMAL);

            // 页眉/页脚事件（每页重复）
            HeaderFooterEvent event = new HeaderFooterEvent(
                    baseFont, titleFont, labelFont, footerFont,
                    proofNo, wipEntityName, orderno, poNumber);
            writer.setPageEvent(event);

            document.open();

            // 明细表格
            PdfPTable table = new PdfPTable(TABLE_HEADERS.length);
            table.setWidthPercentage(100);
            table.setWidths(TABLE_WIDTHS);
            table.setHeaderRows(1); // 表头随跨页自动重复
            for (String h : TABLE_HEADERS)
            {
                table.addCell(headCell(h, headerFont));
            }

            double totalPlan = 0d;
            double totalActual = 0d;
            if (lines != null)
            {
                int idx = 0;
                for (Map<String, Object> d : lines)
                {
                    idx++;
                    double plan = asDouble(d, "taskQty");
                    double actual = asDouble(d, "finishQty");
                    totalPlan += plan;
                    totalActual += actual;

                    addBodyCell(table, String.valueOf(idx), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, String.valueOf(idx), normalFont, Element.ALIGN_CENTER);   // 行号
                    addBodyCell(table, str(d, "materialCode"), normalFont, Element.ALIGN_LEFT);
                    addBodyCell(table, str(d, "materialName"), normalFont, Element.ALIGN_LEFT);
                    addBodyCell(table, strOrDefault(d, "unit", "EA"), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, trimZero(plan), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, trimZero(actual), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, str(d, "subInventoryCode"), normalFont, Element.ALIGN_CENTER);
                    addBodyCell(table, str(d, "hintDesc"), normalFont, Element.ALIGN_LEFT);
                    addBodyCell(table, str(d, "batchNo"), normalFont, Element.ALIGN_LEFT);
                    addBodyCell(table, str(d, "palletNo"), normalFont, Element.ALIGN_LEFT);
                    addBodyCell(table, remark == null ? "" : remark, normalFont, Element.ALIGN_LEFT);
                }
            }

            // 小计行（12 格）：序号留空，"小计:"落在行号列；应发/实发列汇总；其余留空
            addBodyCell(table, "", normalFont, Element.ALIGN_CENTER);
            addBodyCell(table, "小计:", headerFont, Element.ALIGN_CENTER);
            addBodyCell(table, "", normalFont, Element.ALIGN_CENTER);
            addBodyCell(table, "", normalFont, Element.ALIGN_CENTER);
            addBodyCell(table, "", normalFont, Element.ALIGN_CENTER);
            addBodyCell(table, trimZero(totalPlan), headerFont, Element.ALIGN_CENTER);
            addBodyCell(table, trimZero(totalActual), headerFont, Element.ALIGN_CENTER);
            for (int i = 0; i < 5; i++)
            {
                addBodyCell(table, "", normalFont, Element.ALIGN_CENTER);
            }
            document.add(table);

            // 签字区：制单员 / 库管员 / 配送人（签名图） / 领用人（签名图），同一行
            document.add(buildSignatureBlock(baseFont, footerFont,
                    operatorName, storekeeperName, receiverSignBase64, delivererSignBase64));

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
     * 每一页顶部渲染：左侧加粗公司标题 + 右上角一维码（出库凭证号） + 带框两行信息区
     * （领料单位 / 搬运单号 / 任务号 / 日期）；右下角渲染：第 X 页，共 Y 页。
     */
    private static final class HeaderFooterEvent extends PdfPageEventHelper
    {
        private final BaseFont baseFont;
        private final Font titleFont;
        private final Font labelFont;
        private final Font footerFont;
        private final String proofNo;
        private final String wipEntityName;
        private final String orderno;
        private final String poNumber;
        private final String printDate;

        /** “第 X 页，共 Y 页”中可变部分的占位模板，文档关闭时统一回填总页数 */
        private final List<PdfTemplate> totalPlaceholders = new ArrayList<>();

        HeaderFooterEvent(BaseFont baseFont, Font titleFont, Font labelFont,
                          Font footerFont, String proofNo, String wipEntityName, String orderno,
                          String poNumber)
        {
            this.baseFont = baseFont;
            this.titleFont = titleFont;
            this.labelFont = labelFont;
            this.footerFont = footerFont;
            this.proofNo = nvl(proofNo);
            this.wipEntityName = nvl(wipEntityName);
            this.orderno = nvl(orderno);
            this.poNumber = nvl(poNumber);
            this.printDate = DISPLAY_FMT.format(new Date());
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document)
        {
            try
            {
                Rectangle page = document.getPageSize();
                float left = document.leftMargin();
                float right = page.getWidth() - document.rightMargin();
                float contentWidth = right - left;
                PdfContentByte cb = writer.getDirectContent();

                float titleSize = titleFont.getSize();
                float titleWidth = baseFont.getWidthPoint(COMPANY_TITLE, titleSize);

                // ---- 信息区列宽（按参考 PDF 网格列宽比例）：标签 | 左值 | 右侧标签 | 右值 ----
                float[] infoRel = new float[] { 1.0f, 5.78f, 1.01f, 4.2f };
                float infoRelSum = 0f;
                for (float w : infoRel)
                {
                    infoRelSum += w;
                }

                // 信息区顶边（贴近页顶，消除表头与正文之间的空行）
                float infoTop = page.getHeight() - 64f;

                // ---- 右上角一维码（数据源：出库凭证号 PROOFNO） ----
                if (!proofNo.isEmpty())
                {
                    Barcode128 barcode = new Barcode128();
                    barcode.setCode(proofNo);
                    barcode.setBarHeight(20f);
                    barcode.setX(1.0f);
                    barcode.setSize(7f);
                    barcode.setBaseline(7f);
                    Image barcodeImg = barcode.createImageWithBarcode(cb, null, null);
                    float bx = right - (float) barcodeImg.getScaledWidth();
                    // 一维码置于信息区上方、右上角；底边距信息区顶边留 2pt
                    float by = infoTop + 2f;
                    barcodeImg.setAbsolutePosition(bx, by);
                    document.add(barcodeImg);
                }

                // ---- 顶部标题：在信息区“标签+左值”范围上方居中加粗 ----
                float titleY = infoTop + 6f;
                float leftBlockFrac = (infoRel[0] + infoRel[1]) / infoRelSum;
                float titleCenter = left + leftBlockFrac * contentWidth / 2f;
                cb.beginText();
                cb.setFontAndSize(baseFont, titleSize);
                cb.setTextMatrix(titleCenter - titleWidth / 2f, titleY);
                cb.showText(COMPANY_TITLE);
                cb.endText();

                // ---- 两行带框信息区：4 列网格 ----
                // 第一行：领料单位 | 值 | 搬运单号(右对齐) | 值
                // 第二行：任务号   | 值 | 日期(右对齐)     | 值
                PdfPTable info = new PdfPTable(4);
                info.setTotalWidth(contentWidth);
                info.setLockedWidth(true);
                info.setWidths(infoRel);

                info.addCell(infoCell("领料单位:", Element.ALIGN_LEFT));
                info.addCell(infoCell(wipEntityName, Element.ALIGN_CENTER));
                info.addCell(infoCell("搬运单号:", Element.ALIGN_RIGHT, 8f));
                info.addCell(infoCell(orderno, Element.ALIGN_CENTER));

                info.addCell(infoCell("任务号:", Element.ALIGN_LEFT));
                info.addCell(infoCell(poNumber, Element.ALIGN_CENTER));
                info.addCell(infoCell("日期:", Element.ALIGN_RIGHT, 8f));
                info.addCell(infoCell(printDate, Element.ALIGN_CENTER));

                // 信息区顶边
                info.writeSelectedRows(0, -1, left, infoTop, cb);

                // ---- 右下角：第 X 页，共 Y 页（整串放进占位模板，关闭时右对齐回填） ----
                float footerY = document.bottomMargin() - 14f;
                float tplWidth = 110f;
                PdfTemplate totalTpl = cb.createTemplate(tplWidth, 16f);
                totalPlaceholders.add(totalTpl);
                cb.addTemplate(totalTpl, right - tplWidth, footerY);
            }
            catch (DocumentException ignore)
            {
                // 页眉页脚失败不影响正文
            }
        }

        @Override
        public void onCloseDocument(PdfWriter writer, Document document)
        {
            // onEndPage 中按页顺序创建占位模板，关闭文档时统一回填“第 X 页，共 Y 页”
            int total = writer.getPageNumber();
            float fontSize = footerFont.getSize();
            int pageIdx = 0;
            for (PdfTemplate tpl : totalPlaceholders)
            {
                pageIdx++;
                String text = "第 " + pageIdx + " 页，共 " + total + " 页";
                float w = baseFont.getWidthPoint(text, fontSize);
                PdfContentByte cb = tpl;
                cb.beginText();
                cb.setFontAndSize(baseFont, fontSize);
                cb.setTextMatrix(Math.max(0f, tpl.getWidth() - w), 2f);
                cb.showText(text);
                cb.endText();
            }
        }

        private PdfPCell infoCell(String text, int align)
        {
            return infoCell(text, align, 4f);
        }

        private PdfPCell infoCell(String text, int align, float rightPadding)
        {
            PdfPCell cell = new PdfPCell(new Phrase(text == null ? "" : text, labelFont));
            cell.setHorizontalAlignment(align);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setPaddingTop(1f);
            cell.setPaddingBottom(1f);
            cell.setPaddingLeft(6f);
            cell.setPaddingRight(rightPadding);
            // 固定行高 16pt：两行信息区恰为 32pt，与正文上边距对齐，表头与正文间无空行
            cell.setFixedHeight(16f);
            return cell;
        }

    }

    // ---------------------------------------------------------------------
    // 签字区
    // ---------------------------------------------------------------------

    private static PdfPTable buildSignatureBlock(BaseFont baseFont, Font font,
                                                 String operatorName,
                                                 String storekeeperName,
                                                 String receiverSignBase64,
                                                 String delivererSignBase64) throws DocumentException
    {
        PdfPTable sig = new PdfPTable(4);
        sig.setWidthPercentage(100);
        sig.setWidths(new float[] { 1f, 1f, 1f, 1f });
        sig.setSpacingBefore(16f);
        sig.setKeepTogether(true); // 尽量避免签字行被拆到两页

        sig.addCell(signLineCell("制单员: ", nvl(operatorName), null, font));
        sig.addCell(signLineCell("库管员: ", nvl(storekeeperName), null, font));
        sig.addCell(signLineCell("配送人: ", "", decodeSignatureImage(delivererSignBase64), font));
        sig.addCell(signLineCell("领用人: ", "", decodeSignatureImage(receiverSignBase64), font));
        return sig;
    }

    /**
     * 构造单行签字格（无边框）：“标签：”后接姓名文本或签名图。
     *
     * @param label    标签，如“配送人：”
     * @param nameText 姓名文本（与签名图二选一，可为空）
     * @param signImg  签名图字节（可为空）
     * @param font     字体
     */
    private static PdfPCell signLineCell(String label, String nameText, byte[] signImg, Font font)
    {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(4f);
        cell.setMinimumHeight(44f);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        com.itextpdf.text.Paragraph p = new com.itextpdf.text.Paragraph();
        p.add(new com.itextpdf.text.Chunk(label, font));
        if (signImg != null)
        {
            try
            {
                Image image = Image.getInstance(signImg);
                image.scaleToFit(96f, 30f);
                float offsetY = -(image.getScaledHeight() - font.getSize()) / 2f - 2f;
                p.add(new com.itextpdf.text.Chunk(image, 0f, offsetY));
            }
            catch (Exception ignore)
            {
                // 签名图无法解析时仅保留标签
            }
        }
        else if (nameText != null && !nameText.isEmpty())
        {
            p.add(new com.itextpdf.text.Chunk(" " + nameText, font));
        }
        cell.addElement(p);
        return cell;
    }

    // ---------------------------------------------------------------------
    // 明细表格辅助
    // ---------------------------------------------------------------------

    /** 带框、灰底的列表头单元格 */
    private static PdfPCell headCell(String text, Font font)
    {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(3f);
        return cell;
    }

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

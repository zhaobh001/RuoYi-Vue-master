package com.ruoyi.web.controller.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.config.EdocProperties;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.system.service.IEdocFileService;

/**
 * edoc2 电子文档上传/下载接口。
 *
 * <p>对接 {@code edoc常用接口文档.txt}：
 * <ul>
 *   <li>生产环境地址、BASIC 账号在 application.yml 的 edoc.* 配置；</li>
 *   <li>token 失效时底层客户端自动重新登录并重试；</li>
 *   <li>下载的临时文件存放在 edoc.temp-dir，超过 edoc.temp-retention-days（默认 2 天）自动清理。</li>
 * </ul>
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/edoc")
public class EdocController extends BaseController
{
    private static final Logger log = LoggerFactory.getLogger(EdocController.class);

    @Autowired
    private IEdocFileService edocFileService;

    @Autowired
    private EdocProperties edocProperties;

    /**
     * 上传文件（PDF 等）到 edoc2。
     *
     * @param file     multipart 文件
     * @param folderId 目标文件夹 ID（可空，空则用 edoc.default-folder-id）
     * @param remark   备注（可空）
     * @return data.fileId / data.fileName / data.size
     */
    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file,
                             @RequestParam(value = "folderId", required = false) Long folderId,
                             @RequestParam(value = "remark", required = false) String remark)
    {
        if (file == null || file.isEmpty())
        {
            return error("上传文件不能为空");
        }
        try
        {
            String fileName = file.getOriginalFilename();
            if (StringUtils.isEmpty(fileName))
            {
                fileName = "upload.pdf";
            }
            byte[] content = file.getBytes();
            long fid = edocFileService.upload(folderId == null ? 0L : folderId,
                    fileName, content, remark);

            AjaxResult ajax = AjaxResult.success("上传成功");
            ajax.put("fileId", fid);
            ajax.put("fileName", fileName);
            ajax.put("size", content.length);
            return ajax;
        }
        catch (Exception e)
        {
            log.error("edoc 上传失败", e);
            return error("edoc 上传失败: " + e.getMessage());
        }
    }

    /**
     * 上传本地已生成的 PDF（通过字节内容，由其他业务接口转调）。
     *
     * @param fileName 文件名
     * @param content  文件字节
     * @param folderId 文件夹 ID（可空）
     * @return edoc2 文件 ID
     */
    public long uploadBytes(String fileName, byte[] content, Long folderId)
    {
        return edocFileService.upload(folderId == null ? 0L : folderId,
                fileName, content, null);
    }

    /**
     * 下载文件：根据 edoc2 文件 ID 下载文件到临时目录并以流返回。
     *
     * @param fileId   edoc2 文件 ID
     * @param fileName 下载到浏览器时的文件名（可空，默认用 fileId.pdf）
     * @param delete   下载后是否立即删除临时文件（默认 false，由定时任务统一清理）
     */
    @GetMapping("/download")
    public void download(@RequestParam("fileId") Long fileId,
                         @RequestParam(value = "fileName", required = false) String fileName,
                         @RequestParam(value = "delete", required = false, defaultValue = "false") Boolean delete,
                         HttpServletResponse response)
    {
        if (fileId == null || fileId <= 0)
        {
            writeError(response, "fileId 不能为空");
            return;
        }
        File local = null;
        try
        {
            local = edocFileService.downloadToTemp(fileId, fileName);

            String downloadName = StringUtils.isNotEmpty(fileName) ? fileName : local.getName();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition",
                    "attachment; filename=\"" + encodeFileName(downloadName) + "\"");
            response.setContentLengthLong(local.length());

            try (OutputStream os = response.getOutputStream();
                 FileInputStream fis = new FileInputStream(local))
            {
                byte[] buf = new byte[8192];
                int n;
                while ((n = fis.read(buf)) != -1)
                {
                    os.write(buf, 0, n);
                }
                os.flush();
            }
        }
        catch (Exception e)
        {
            log.error("edoc 下载失败, fileId={}", fileId, e);
            writeError(response, "edoc 下载失败: " + e.getMessage());
        }
        finally
        {
            if (Boolean.TRUE.equals(delete) && local != null && local.exists())
            {
                try
                {
                    if (!local.delete())
                    {
                        log.warn("edoc 临时文件删除失败: {}", local.getAbsolutePath());
                    }
                }
                catch (Exception ignore)
                {
                }
            }
        }
    }

    /**
     * 在线预览：根据 fileId 获取临时文件，以 PDF inline 方式返回。
     */
    @GetMapping("/preview")
    public void preview(@RequestParam("fileId") Long fileId,
                        @RequestParam(value = "fileName", required = false) String fileName,
                        HttpServletResponse response)
    {
        if (fileId == null || fileId <= 0)
        {
            writeError(response, "fileId 不能为空");
            return;
        }
        File local = null;
        try
        {
            local = edocFileService.downloadToTemp(fileId, fileName);
            String name = StringUtils.isNotEmpty(fileName) ? fileName : local.getName();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition",
                    "inline; filename=\"" + encodeFileName(name) + "\"");
            response.setContentLengthLong(local.length());
            FileUtils.writeBytes(local.getAbsolutePath(), response.getOutputStream());
        }
        catch (Exception e)
        {
            log.error("edoc 预览失败, fileId={}", fileId, e);
            writeError(response, "edoc 预览失败: " + e.getMessage());
        }
    }

    /**
     * 手动触发临时文件清理。
     */
    @PostMapping("/cleanTemp")
    public AjaxResult cleanTemp()
    {
        int n = edocFileService.cleanExpiredTempFiles();
        AjaxResult ajax = AjaxResult.success("清理完成");
        ajax.put("deleted", n);
        ajax.put("tempDir", edocProperties.getTempDir());
        ajax.put("retentionDays", edocProperties.getTempRetentionDays());
        return ajax;
    }

    private static String encodeFileName(String name)
    {
        try
        {
            // 同时兼容大多数浏览器：RFC 5987 风格优先
            return URLEncoder.encode(name, StandardCharsets.UTF_8.name()).replace("+", "%20");
        }
        catch (Exception e)
        {
            return name;
        }
    }

    private void writeError(HttpServletResponse response, String msg)
    {
        try
        {
            response.reset();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":500,\"msg\":\"" + msg.replace("\"", "'") + "\"}");
        }
        catch (Exception ignore)
        {
        }
    }
}

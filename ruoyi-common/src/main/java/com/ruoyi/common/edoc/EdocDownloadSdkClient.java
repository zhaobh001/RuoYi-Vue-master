package com.ruoyi.common.edoc;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.common.config.EdocProperties;
import com.ruoyi.common.exception.ServiceException;
import edoc2.DownLoadService;
import edoc2.entity.downLoadEntity;

/**
 * 基于 edoc2 官方下载 SDK（edoc2-download-sdk / edocdownload.jar）的下载封装。
 *
 * <p>对应 {@code edoc常用接口文档.txt} 第 12 节「下载附件接口」：
 * <pre>
 *   DownLoadService svc = new DownLoadService();
 *   downLoadEntity entity = new downLoadEntity();
 *   entity.set_token(token);
 *   entity.setEcmUrl(ecmUrl);          // 取 edoc.ecm-url 配置，不在代码写死
 *   entity.set_fileIds("5224543,5224546");   // 多个逗号分隔，返回 zip
 *   entity.setSavePath("C:\\save\\dir");
 *   String path = svc.DownLiadFileAction(entity);
 * </pre>
 *
 * <p>SDK 为金风内部 fat jar（自带 httpclient/fastjson1 等依赖），通过项目内 Maven 仓库
 * {@code repo/}（groupId {@code com.edoc2}, artifactId {@code edoc2-download-sdk}）引入。
 *
 * <p><b>网络前提：</b>SDK 直连 ECM 站点 {@code edoc.ecm-url}（统一在 application.yml 配置），
 * 需部署服务器到该站点的网络白名单（开放平台网关未提供 /downLoad 下载路由）。
 *
 * @author ruoyi
 */
@Component
public class EdocDownloadSdkClient
{
    private static final Logger log = LoggerFactory.getLogger(EdocDownloadSdkClient.class);

    @Autowired
    private EdocProperties props;

    @Autowired
    private EdocClient edocClient;

    /**
     * 调用官方 SDK 下载一个或多个文件到指定目录。
     *
     * @param fileIds 文件 ID（多个时 SDK 返回 zip 压缩包）
     * @param saveDir 本地保存目录（不存在会创建）
     * @return SDK 下载生成的文件/压缩包
     */
    public File download(long[] fileIds, File saveDir)
    {
        if (fileIds == null || fileIds.length == 0)
        {
            throw new ServiceException("edoc 下载文件 ID 不能为空");
        }
        if (saveDir == null)
        {
            throw new ServiceException("edoc 下载保存目录不能为空");
        }
        if (!saveDir.exists() && !saveDir.mkdirs())
        {
            throw new ServiceException("edoc 下载保存目录创建失败: " + saveDir.getAbsolutePath());
        }

        String token = edocClient.getToken();
        StringBuilder ids = new StringBuilder();
        for (int i = 0; i < fileIds.length; i++)
        {
            if (i > 0)
            {
                ids.append(',');
            }
            ids.append(fileIds[i]);
        }

        try
        {
            downLoadEntity entity = new downLoadEntity();
            entity.set_token(token);
            entity.setEcmUrl(props.getEcmUrl());
            entity.set_fileIds(ids.toString());
            entity.setSavePath(saveDir.getAbsolutePath());

            DownLoadService service = new DownLoadService();
            String path = service.DownLiadFileAction(entity);
            log.info("edoc SDK 下载完成, fileIds={}, 返回 path={}", ids, path);

            File downloaded = resolveResultFile(path, saveDir);
            if (downloaded == null || !downloaded.exists())
            {
                throw new ServiceException("edoc SDK 下载返回路径不存在: " + path);
            }
            return downloaded;
        }
        catch (ServiceException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            throw new ServiceException("edoc SDK 下载失败: " + cause.getMessage());
        }
    }

    /**
     * SDK 返回的可能是文件绝对路径，也可能为空，兜底取保存目录下最新生成的文件。
     */
    private File resolveResultFile(String path, File saveDir)
    {
        if (path != null && !path.trim().isEmpty())
        {
            File f = new File(path.trim());
            if (f.exists())
            {
                return f.isDirectory() ? newestFile(f) : f;
            }
        }
        return newestFile(saveDir);
    }

    private File newestFile(File dir)
    {
        File[] files = dir.listFiles();
        if (files == null || files.length == 0)
        {
            return null;
        }
        File best = null;
        for (File f : files)
        {
            if (f.isFile() && (best == null || f.lastModified() > best.lastModified()))
            {
                best = f;
            }
        }
        return best;
    }
}

package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.ruoyi.common.config.EdocProperties;
import com.ruoyi.common.edoc.EdocClient;
import com.ruoyi.common.edoc.EdocDownloadSdkClient;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.IEdocFileService;

/**
 * edoc2 文件上传/下载业务实现。
 *
 * <p>下载的文件落地到 {@link EdocProperties#getTempDir()}，通过
 * {@link #cleanExpiredTempFiles()} 定时清理超过保留天数的临时文件。
 *
 * @author ruoyi
 */
@Service
public class EdocFileServiceImpl implements IEdocFileService
{
    private static final Logger log = LoggerFactory.getLogger(EdocFileServiceImpl.class);

    @Autowired
    private EdocClient edocClient;

    @Autowired
    private EdocDownloadSdkClient edocDownloadSdkClient;

    @Autowired
    private EdocProperties props;

    /** 自动解析到的默认文件夹 ID（0 表示尚未解析） */
    private volatile long resolvedFolderId = 0L;

    /**
     * 启动后若未显式配置 {@code edoc.default-folder-id}，则尝试在根目录下查找或创建
     * 名称为 {@link EdocProperties#getDefaultFolderName()} 的文件夹。
     *
     * <p>失败仅记录日志，不阻断启动；首次上传时会再懒加载重试一次。
     */
    @PostConstruct
    public void init()
    {
        if (!props.isEnabled() || props.getDefaultFolderId() > 0)
        {
            return;
        }
        try
        {
            long id = resolveDefaultFolder();
            log.info("edoc 默认上传文件夹自动解析成功, folderId={}, name={}",
                    id, props.getDefaultFolderName());
        }
        catch (Exception e)
        {
            log.warn("edoc 启动时自动解析上传文件夹失败（将在首次上传时重试）: {}", e.getMessage());
        }
    }

    @Override
    public long upload(String fileName, byte[] content, String remark)
    {
        return upload(0L, fileName, content, remark);
    }

    @Override
    public long upload(long folderId, String fileName, byte[] content, String remark)
    {
        if (StringUtils.isEmpty(fileName))
        {
            throw new ServiceException("edoc 上传文件名不能为空");
        }
        if (content == null || content.length == 0)
        {
            throw new ServiceException("edoc 上传文件内容为空");
        }
        long targetFolder = folderId > 0 ? folderId : requireDefaultFolderId();
        return edocClient.uploadFile(targetFolder, fileName, content, remark);
    }

    /**
     * 获取可用的默认文件夹 ID：未配置时在根目录按
     * {@link EdocProperties#getDefaultFolderName()} 查找，找不到则自动创建。
     *
     * <p>解析结果会写回 {@link EdocProperties}，避免重复调用。
     */
    private synchronized long resolveDefaultFolder()
    {
        if (resolvedFolderId > 0)
        {
            return resolvedFolderId;
        }
        String folderName = props.getDefaultFolderName();
        // parentFolderId=0 在 edoc2 中表示企业根目录
        long id = edocClient.getFolderIdByName(0L, folderName);
        if (id <= 0)
        {
            log.info("edoc 根目录下未找到文件夹[{}]，自动创建", folderName);
            id = edocClient.createFolder(0L, folderName, "WMS 配送核验 PDF 自动归档");
        }
        resolvedFolderId = id;
        props.setDefaultFolderId(id);
        return id;
    }

    private long requireDefaultFolderId()
    {
        long configured = props.getDefaultFolderId();
        if (configured > 0)
        {
            return configured;
        }
        if (resolvedFolderId > 0)
        {
            return resolvedFolderId;
        }
        return resolveDefaultFolder();
    }

    @Override
    public File downloadToTemp(long fileId)
    {
        return downloadToTemp(fileId, null);
    }

    @Override
    public File downloadToTemp(long fileId, String fileName)
    {
        if (fileId <= 0)
        {
            throw new ServiceException("edoc 下载文件 ID 非法: " + fileId);
        }
        File dir = new File(props.getTempDir());
        if (!dir.exists())
        {
            dir.mkdirs();
        }

        String safeName = sanitizeFileName(fileName);
        // 文件名带上 fileId，避免不同文件同名互相覆盖
        String localName = (safeName == null || safeName.isEmpty())
                ? (fileId + ".pdf") : fileId + "_" + safeName;
        File target = new File(dir, localName);

        // 已存在且未过期则直接复用（避免重复下载）
        if (target.exists() && target.length() > 0 && !isExpired(target))
        {
            log.info("edoc 复用未过期临时文件, fileId={}, path={}", fileId, target.getAbsolutePath());
            return target;
        }

        // 下载走官方 SDK（直连 ECM 站点）。用独立子目录作为 SDK 保存目录，避免多文件互相干扰
        File workDir = new File(dir, "sdk-" + fileId);
        try
        {
            File downloaded = edocDownloadSdkClient.download(new long[] { fileId }, workDir);
            // 统一归并到 target 文件名。先删旧目标再移动，保证创建时间为本次下载时间
            // （按创建时间清理，Windows 上 move 覆盖会保留被覆盖文件的旧创建时间）
            if (downloaded.exists()
                    && !downloaded.getCanonicalPath().equals(target.getCanonicalPath()))
            {
                if (target.exists())
                {
                    target.delete();
                }
                Files.move(downloaded.toPath(), target.toPath());
            }
            return target;
        }
        catch (IOException e)
        {
            throw new ServiceException("edoc 下载文件落地失败: " + e.getMessage());
        }
        finally
        {
            // 清理 SDK 工作子目录
            deleteQuietly(workDir);
        }
    }

    /** 递归删除目录/文件，忽略失败（临时目录有定时清理兜底） */
    private void deleteQuietly(File f)
    {
        if (f == null || !f.exists())
        {
            return;
        }
        File[] children = f.listFiles();
        if (children != null)
        {
            for (File c : children)
            {
                deleteQuietly(c);
            }
        }
        try
        {
            f.delete();
        }
        catch (Exception ignore)
        {
        }
    }

    /**
     * 定时清理过期临时文件。
     *
     * <p>每天凌晨 3:17 执行一次。{@code @Scheduled} 由
     * {@link com.ruoyi.system.config.EdocSchedulingConfig} 开启。
     */
    @Scheduled(cron = "0 17 3 * * ?")
    @Override
    public int cleanExpiredTempFiles()
    {
        File dir = new File(props.getTempDir());
        if (!dir.exists() || !dir.isDirectory())
        {
            return 0;
        }
        int deleted = 0;
        long now = System.currentTimeMillis();
        File[] files = dir.listFiles();
        if (files == null)
        {
            return 0;
        }
        for (File f : files)
        {
            if (!f.isFile())
            {
                continue;
            }
            try
            {
                if (isExpired(f, now))
                {
                    if (f.delete())
                    {
                        deleted++;
                        log.info("edoc 清理过期临时文件: {}", f.getName());
                    }
                }
            }
            catch (Exception e)
            {
                log.warn("edoc 清理临时文件失败: {}, {}", f.getName(), e.getMessage());
            }
        }
        if (deleted > 0)
        {
            log.info("edoc 临时文件清理完成，共删除 {} 个文件", deleted);
        }
        return deleted;
    }

    private boolean isExpired(File file)
    {
        return isExpired(file, System.currentTimeMillis());
    }

    private boolean isExpired(File file, long now)
    {
        // 以「创建时间」为准判断是否过期（覆盖/重命名会刷新 lastModified，不符合按入库时长清理的语义）；
        // 读取不到创建时间时退而用最后修改时间。
        long created = readCreateTime(file);
        long ageMillis = now - created;
        long maxAgeMillis = TimeUnit.DAYS.toMillis(Math.max(1, props.getTempRetentionDays()));
        return ageMillis >= maxAgeMillis;
    }

    private long readCreateTime(File file)
    {
        try
        {
            BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            long t = attrs.creationTime().toMillis();
            return t > 0 ? t : file.lastModified();
        }
        catch (IOException e)
        {
            return file.lastModified();
        }
    }

    private static String sanitizeFileName(String name)
    {
        if (StringUtils.isEmpty(name))
        {
            return null;
        }
        // 去掉路径分隔符等危险字符
        return name.replaceAll("[\\\\/:*?\"<>|]", "_");
    }
}

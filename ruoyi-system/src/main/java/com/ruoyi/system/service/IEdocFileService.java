package com.ruoyi.system.service;

import java.io.File;

/**
 * edoc2 电子文档上传/下载业务服务。
 *
 * <p>包装 {@link com.ruoyi.common.edoc.EdocClient}，提供：
 * <ul>
 *   <li>PDF（及其他文件）上传到 edoc2，返回文件 ID；</li>
 *   <li>根据文件 ID 下载，落地到临时目录并返回本地文件；</li>
 *   <li>临时文件超过保留天数（默认 2 天）自动删除。</li>
 * </ul>
 *
 * @author ruoyi
 */
public interface IEdocFileService
{
    /**
     * 上传文件到默认文件夹。
     *
     * @param fileName 文件名（含扩展名）
     * @param content  文件字节
     * @param remark   备注（可为空）
     * @return edoc2 文件 ID
     */
    long upload(String fileName, byte[] content, String remark);

    /**
     * 上传文件到指定文件夹。
     *
     * @param folderId 目标文件夹 ID（&le;0 时使用配置的默认文件夹）
     * @param fileName 文件名
     * @param content  文件字节
     * @param remark   备注
     * @return edoc2 文件 ID
     */
    long upload(long folderId, String fileName, byte[] content, String remark);

    /**
     * 下载文件到临时目录（同一 fileId 已存在且未过期则直接复用）。
     *
     * @param fileId edoc2 文件 ID
     * @return 本地临时文件
     */
    File downloadToTemp(long fileId);

    /**
     * 下载文件到临时目录，使用指定文件名。
     *
     * @param fileId   edoc2 文件 ID
     * @param fileName 落地文件名（含扩展名），为空时用 fileId 命名
     * @return 本地临时文件
     */
    File downloadToTemp(long fileId, String fileName);

    /**
     * 触发一次临时文件清理（删除超过保留天数的文件）。
     *
     * @return 删除的文件个数
     */
    int cleanExpiredTempFiles();
}

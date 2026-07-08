package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysMessage;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-03-17
 */
public interface ISysMessageService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param messageId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysMessage selectSysMessageByMessageId(Long messageId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysMessage 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysMessage> selectSysMessageList(SysMessage sysMessage);

    /**
     * 新增【请填写功能名称】
     *
     * @param sysMessage 【请填写功能名称】
     * @return 结果
     */
    public int insertSysMessage(SysMessage sysMessage);

    /**
     * 修改【请填写功能名称】
     *
     * @param sysMessage 【请填写功能名称】
     * @return 结果
     */
    public int updateSysMessage(SysMessage sysMessage);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param messageIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysMessageByMessageIds(Long[] messageIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param messageId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysMessageByMessageId(Long messageId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysMessage 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysMessage> selectSysMessageList2(SysMessage sysMessage);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysMessage 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public int selectSysMessageCount(SysMessage sysMessage);
}

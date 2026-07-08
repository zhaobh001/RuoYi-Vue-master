package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysMessageMapper;
import com.ruoyi.system.domain.SysMessage;
import com.ruoyi.system.service.ISysMessageService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-17
 */
@Service
public class SysMessageServiceImpl implements ISysMessageService
{
    @Autowired
    private SysMessageMapper sysMessageMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param messageId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysMessage selectSysMessageByMessageId(Long messageId)
    {
        return sysMessageMapper.selectSysMessageByMessageId(messageId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysMessage 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysMessage> selectSysMessageList(SysMessage sysMessage)
    {
        return sysMessageMapper.selectSysMessageList(sysMessage);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysMessage 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysMessage> selectSysMessageList2(SysMessage sysMessage)
    {
        return sysMessageMapper.selectSysMessageList2(sysMessage);
    }



    /**
     * 新增【请填写功能名称】
     *
     * @param sysMessage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysMessage(SysMessage sysMessage)
    {
        sysMessage.setCreateTime(DateUtils.getNowDate());
        return sysMessageMapper.insertSysMessage(sysMessage);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param sysMessage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysMessage(SysMessage sysMessage)
    {
        return sysMessageMapper.updateSysMessage(sysMessage);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param messageIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysMessageByMessageIds(Long[] messageIds)
    {
        return sysMessageMapper.deleteSysMessageByMessageIds(messageIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param messageId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysMessageByMessageId(Long messageId)
    {
        return sysMessageMapper.deleteSysMessageByMessageId(messageId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysMessage 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public int selectSysMessageCount(SysMessage sysMessage)
    {
        return sysMessageMapper.selectSysMessageCount(sysMessage);
    };
}

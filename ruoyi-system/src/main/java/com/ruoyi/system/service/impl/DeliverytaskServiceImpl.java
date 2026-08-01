package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeliverytaskMapper;
import com.ruoyi.system.domain.Deliverytask;
import com.ruoyi.system.service.IDeliverytaskService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
@Service
public class DeliverytaskServiceImpl implements IDeliverytaskService 
{
    @Autowired
    private DeliverytaskMapper deliverytaskMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param intaskid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Deliverytask selectDeliverytaskByIntaskid(Long intaskid)
    {
        return deliverytaskMapper.selectDeliverytaskByIntaskid(intaskid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deliverytask 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Deliverytask> selectDeliverytaskList(Deliverytask deliverytask)
    {
        return deliverytaskMapper.selectDeliverytaskList(deliverytask);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deliverytask 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeliverytask(Deliverytask deliverytask)
    {
        return deliverytaskMapper.insertDeliverytask(deliverytask);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deliverytask 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeliverytask(Deliverytask deliverytask)
    {
        return deliverytaskMapper.updateDeliverytask(deliverytask);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param intaskids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeliverytaskByIntaskids(Long[] intaskids)
    {
        return deliverytaskMapper.deleteDeliverytaskByIntaskids(intaskids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param intaskid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeliverytaskByIntaskid(Long intaskid)
    {
        return deliverytaskMapper.deleteDeliverytaskByIntaskid(intaskid);
    }
}

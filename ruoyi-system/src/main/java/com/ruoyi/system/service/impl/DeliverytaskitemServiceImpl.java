package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeliverytaskitemMapper;
import com.ruoyi.system.domain.Deliverytaskitem;
import com.ruoyi.system.service.IDeliverytaskitemService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
@Service
public class DeliverytaskitemServiceImpl implements IDeliverytaskitemService 
{
    @Autowired
    private DeliverytaskitemMapper deliverytaskitemMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param intaskitemid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Deliverytaskitem selectDeliverytaskitemByIntaskitemid(Long intaskitemid)
    {
        return deliverytaskitemMapper.selectDeliverytaskitemByIntaskitemid(intaskitemid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deliverytaskitem 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Deliverytaskitem> selectDeliverytaskitemList(Deliverytaskitem deliverytaskitem)
    {
        return deliverytaskitemMapper.selectDeliverytaskitemList(deliverytaskitem);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deliverytaskitem 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeliverytaskitem(Deliverytaskitem deliverytaskitem)
    {
        return deliverytaskitemMapper.insertDeliverytaskitem(deliverytaskitem);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deliverytaskitem 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeliverytaskitem(Deliverytaskitem deliverytaskitem)
    {
        return deliverytaskitemMapper.updateDeliverytaskitem(deliverytaskitem);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param intaskitemids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeliverytaskitemByIntaskitemids(Long[] intaskitemids)
    {
        return deliverytaskitemMapper.deleteDeliverytaskitemByIntaskitemids(intaskitemids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param intaskitemid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeliverytaskitemByIntaskitemid(Long intaskitemid)
    {
        return deliverytaskitemMapper.deleteDeliverytaskitemByIntaskitemid(intaskitemid);
    }
}

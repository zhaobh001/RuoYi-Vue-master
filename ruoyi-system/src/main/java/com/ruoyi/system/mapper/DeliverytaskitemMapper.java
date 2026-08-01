package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Deliverytaskitem;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
public interface DeliverytaskitemMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param intaskitemid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Deliverytaskitem selectDeliverytaskitemByIntaskitemid(Long intaskitemid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deliverytaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Deliverytaskitem> selectDeliverytaskitemList(Deliverytaskitem deliverytaskitem);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deliverytaskitem 【请填写功能名称】
     * @return 结果
     */
    public int insertDeliverytaskitem(Deliverytaskitem deliverytaskitem);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deliverytaskitem 【请填写功能名称】
     * @return 结果
     */
    public int updateDeliverytaskitem(Deliverytaskitem deliverytaskitem);

    /**
     * 删除【请填写功能名称】
     * 
     * @param intaskitemid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeliverytaskitemByIntaskitemid(Long intaskitemid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param intaskitemids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeliverytaskitemByIntaskitemids(Long[] intaskitemids);
}

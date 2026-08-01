package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Deliverytask;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
public interface IDeliverytaskService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param intaskid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Deliverytask selectDeliverytaskByIntaskid(Long intaskid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deliverytask 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Deliverytask> selectDeliverytaskList(Deliverytask deliverytask);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deliverytask 【请填写功能名称】
     * @return 结果
     */
    public int insertDeliverytask(Deliverytask deliverytask);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deliverytask 【请填写功能名称】
     * @return 结果
     */
    public int updateDeliverytask(Deliverytask deliverytask);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param intaskids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteDeliverytaskByIntaskids(Long[] intaskids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param intaskid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeliverytaskByIntaskid(Long intaskid);
}

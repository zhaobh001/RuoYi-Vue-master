package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Outorder;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface IOutorderService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param outorderid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Outorder selectOutorderByOutorderid(Long outorderid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outorder 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outorder> selectOutorderList(Outorder outorder);

    /**
     * 新增【请填写功能名称】
     * 
     * @param outorder 【请填写功能名称】
     * @return 结果
     */
    public int insertOutorder(Outorder outorder);

    /**
     * 修改【请填写功能名称】
     * 
     * @param outorder 【请填写功能名称】
     * @return 结果
     */
    public int updateOutorder(Outorder outorder);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outorderids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteOutorderByOutorderids(Long[] outorderids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param outorderid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOutorderByOutorderid(Long outorderid);
}

package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Outbill;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface IOutbillService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param outbillid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Outbill selectOutbillByOutbillid(Long outbillid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outbill 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outbill> selectOutbillList(Outbill outbill);

    /**
     * 新增【请填写功能名称】
     * 
     * @param outbill 【请填写功能名称】
     * @return 结果
     */
    public int insertOutbill(Outbill outbill);

    /**
     * 修改【请填写功能名称】
     * 
     * @param outbill 【请填写功能名称】
     * @return 结果
     */
    public int updateOutbill(Outbill outbill);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outbillids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteOutbillByOutbillids(Long[] outbillids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param outbillid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOutbillByOutbillid(Long outbillid);

    /**
     * 修改【请填写功能名称】
     *
     * @param outbill 【请填写功能名称】
     * @return 结果
     */
    public List<Outbill> selecttransQty(Outbill outbill);
}

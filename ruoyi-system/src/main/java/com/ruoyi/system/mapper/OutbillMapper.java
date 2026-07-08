package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Outbill;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface OutbillMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param outbillid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOutbillByOutbillid(Long outbillid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outbillids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOutbillByOutbillids(Long[] outbillids);

    /**
     * 修改【请填写功能名称】
     *
     * @param outbill 【请填写功能名称】
     * @return 结果
     */
    public List<Outbill> selecttransQty(Outbill outbill);
}

package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DrawmaterialRfBill;

/**
 * 拉式发料Service接口
 * 
 * @author ruoyi
 * @date 2023-08-23
 */
public interface IDrawmaterialRfBillService 
{
    /**
     * 查询拉式发料
     * 
     * @param drawmaterialRfBillid 拉式发料主键
     * @return 拉式发料
     */
    public DrawmaterialRfBill selectDrawmaterialRfBillByDrawmaterialRfBillid(Long drawmaterialRfBillid);

    /**
     * 查询拉式发料列表
     * 
     * @param drawmaterialRfBill 拉式发料
     * @return 拉式发料集合
     */
    public List<DrawmaterialRfBill> selectDrawmaterialRfBillList(DrawmaterialRfBill drawmaterialRfBill);

    /**
     * 新增拉式发料
     * 
     * @param drawmaterialRfBill 拉式发料
     * @return 结果
     */
    public Long insertDrawmaterialRfBill(DrawmaterialRfBill drawmaterialRfBill);

    /**
     * 修改拉式发料
     * 
     * @param drawmaterialRfBill 拉式发料
     * @return 结果
     */
    public int updateDrawmaterialRfBill(DrawmaterialRfBill drawmaterialRfBill);

    /**
     * 批量删除拉式发料
     * 
     * @param drawmaterialRfBillids 需要删除的拉式发料主键集合
     * @return 结果
     */
    public int deleteDrawmaterialRfBillByDrawmaterialRfBillids(Long[] drawmaterialRfBillids);

    /**
     * 删除拉式发料信息
     * 
     * @param drawmaterialRfBillid 拉式发料主键
     * @return 结果
     */
    public int deleteDrawmaterialRfBillByDrawmaterialRfBillid(Long drawmaterialRfBillid);
}

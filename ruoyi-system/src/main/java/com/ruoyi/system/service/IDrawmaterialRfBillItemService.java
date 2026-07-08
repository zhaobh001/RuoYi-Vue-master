package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DrawmaterialRfBillItem;

/**
 * 拉式发料商品明细Service接口
 * 
 * @author ruoyi
 * @date 2023-08-23
 */
public interface IDrawmaterialRfBillItemService 
{
    /**
     * 查询拉式发料商品明细
     * 
     * @param drawmaterialRfBillItemid 拉式发料商品明细主键
     * @return 拉式发料商品明细
     */
    public DrawmaterialRfBillItem selectDrawmaterialRfBillItemByDrawmaterialRfBillItemid(Long drawmaterialRfBillItemid);

    /**
     * 查询拉式发料商品明细列表
     * 
     * @param drawmaterialRfBillItem 拉式发料商品明细
     * @return 拉式发料商品明细集合
     */
    public List<DrawmaterialRfBillItem> selectDrawmaterialRfBillItemList(DrawmaterialRfBillItem drawmaterialRfBillItem);

    /**
     * 新增拉式发料商品明细
     * 
     * @param drawmaterialRfBillItem 拉式发料商品明细
     * @return 结果
     */
    public int insertDrawmaterialRfBillItem(DrawmaterialRfBillItem drawmaterialRfBillItem);

    /**
     * 修改拉式发料商品明细
     * 
     * @param drawmaterialRfBillItem 拉式发料商品明细
     * @return 结果
     */
    public int updateDrawmaterialRfBillItem(DrawmaterialRfBillItem drawmaterialRfBillItem);

    /**
     * 批量删除拉式发料商品明细
     * 
     * @param drawmaterialRfBillItemids 需要删除的拉式发料商品明细主键集合
     * @return 结果
     */
    public int deleteDrawmaterialRfBillItemByDrawmaterialRfBillItemids(Long[] drawmaterialRfBillItemids);

    /**
     * 删除拉式发料商品明细信息
     * 
     * @param drawmaterialRfBillItemid 拉式发料商品明细主键
     * @return 结果
     */
    public int deleteDrawmaterialRfBillItemByDrawmaterialRfBillItemid(Long drawmaterialRfBillItemid);
}

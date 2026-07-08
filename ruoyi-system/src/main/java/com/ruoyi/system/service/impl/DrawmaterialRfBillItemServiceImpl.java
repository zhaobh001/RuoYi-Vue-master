package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DrawmaterialRfBillItemMapper;
import com.ruoyi.system.domain.DrawmaterialRfBillItem;
import com.ruoyi.system.service.IDrawmaterialRfBillItemService;

/**
 * 拉式发料商品明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-23
 */
@Service
public class DrawmaterialRfBillItemServiceImpl implements IDrawmaterialRfBillItemService 
{
    @Autowired
    private DrawmaterialRfBillItemMapper drawmaterialRfBillItemMapper;

    /**
     * 查询拉式发料商品明细
     * 
     * @param drawmaterialRfBillItemid 拉式发料商品明细主键
     * @return 拉式发料商品明细
     */
    @Override
    public DrawmaterialRfBillItem selectDrawmaterialRfBillItemByDrawmaterialRfBillItemid(Long drawmaterialRfBillItemid)
    {
        return drawmaterialRfBillItemMapper.selectDrawmaterialRfBillItemByDrawmaterialRfBillItemid(drawmaterialRfBillItemid);
    }

    /**
     * 查询拉式发料商品明细列表
     * 
     * @param drawmaterialRfBillItem 拉式发料商品明细
     * @return 拉式发料商品明细
     */
    @Override
    public List<DrawmaterialRfBillItem> selectDrawmaterialRfBillItemList(DrawmaterialRfBillItem drawmaterialRfBillItem)
    {
        return drawmaterialRfBillItemMapper.selectDrawmaterialRfBillItemList(drawmaterialRfBillItem);
    }

    /**
     * 新增拉式发料商品明细
     * 
     * @param drawmaterialRfBillItem 拉式发料商品明细
     * @return 结果
     */
    @Override
    public int insertDrawmaterialRfBillItem(DrawmaterialRfBillItem drawmaterialRfBillItem)
    {
        return drawmaterialRfBillItemMapper.insertDrawmaterialRfBillItem(drawmaterialRfBillItem);
    }

    /**
     * 修改拉式发料商品明细
     * 
     * @param drawmaterialRfBillItem 拉式发料商品明细
     * @return 结果
     */
    @Override
    public int updateDrawmaterialRfBillItem(DrawmaterialRfBillItem drawmaterialRfBillItem)
    {
        return drawmaterialRfBillItemMapper.updateDrawmaterialRfBillItem(drawmaterialRfBillItem);
    }

    /**
     * 批量删除拉式发料商品明细
     * 
     * @param drawmaterialRfBillItemids 需要删除的拉式发料商品明细主键
     * @return 结果
     */
    @Override
    public int deleteDrawmaterialRfBillItemByDrawmaterialRfBillItemids(Long[] drawmaterialRfBillItemids)
    {
        return drawmaterialRfBillItemMapper.deleteDrawmaterialRfBillItemByDrawmaterialRfBillItemids(drawmaterialRfBillItemids);
    }

    /**
     * 删除拉式发料商品明细信息
     * 
     * @param drawmaterialRfBillItemid 拉式发料商品明细主键
     * @return 结果
     */
    @Override
    public int deleteDrawmaterialRfBillItemByDrawmaterialRfBillItemid(Long drawmaterialRfBillItemid)
    {
        return drawmaterialRfBillItemMapper.deleteDrawmaterialRfBillItemByDrawmaterialRfBillItemid(drawmaterialRfBillItemid);
    }
}

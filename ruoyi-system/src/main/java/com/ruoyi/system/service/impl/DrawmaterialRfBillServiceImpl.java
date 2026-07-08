package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DrawmaterialRfBillMapper;
import com.ruoyi.system.domain.DrawmaterialRfBill;
import com.ruoyi.system.service.IDrawmaterialRfBillService;

/**
 * 拉式发料Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-23
 */
@Service
public class DrawmaterialRfBillServiceImpl implements IDrawmaterialRfBillService 
{
    @Autowired
    private DrawmaterialRfBillMapper drawmaterialRfBillMapper;

    /**
     * 查询拉式发料
     * 
     * @param drawmaterialRfBillid 拉式发料主键
     * @return 拉式发料
     */
    @Override
    public DrawmaterialRfBill selectDrawmaterialRfBillByDrawmaterialRfBillid(Long drawmaterialRfBillid)
    {
        return drawmaterialRfBillMapper.selectDrawmaterialRfBillByDrawmaterialRfBillid(drawmaterialRfBillid);
    }

    /**
     * 查询拉式发料列表
     * 
     * @param drawmaterialRfBill 拉式发料
     * @return 拉式发料
     */
    @Override
    public List<DrawmaterialRfBill> selectDrawmaterialRfBillList(DrawmaterialRfBill drawmaterialRfBill)
    {
        return drawmaterialRfBillMapper.selectDrawmaterialRfBillList(drawmaterialRfBill);
    }

    /**
     * 新增拉式发料
     * 
     * @param drawmaterialRfBill 拉式发料
     * @return 结果
     */
    @Override
    public Long insertDrawmaterialRfBill(DrawmaterialRfBill drawmaterialRfBill)
    {
        return drawmaterialRfBillMapper.insertDrawmaterialRfBill(drawmaterialRfBill);
    }

    /**
     * 修改拉式发料
     * 
     * @param drawmaterialRfBill 拉式发料
     * @return 结果
     */
    @Override
    public int updateDrawmaterialRfBill(DrawmaterialRfBill drawmaterialRfBill)
    {
        return drawmaterialRfBillMapper.updateDrawmaterialRfBill(drawmaterialRfBill);
    }

    /**
     * 批量删除拉式发料
     * 
     * @param drawmaterialRfBillids 需要删除的拉式发料主键
     * @return 结果
     */
    @Override
    public int deleteDrawmaterialRfBillByDrawmaterialRfBillids(Long[] drawmaterialRfBillids)
    {
        return drawmaterialRfBillMapper.deleteDrawmaterialRfBillByDrawmaterialRfBillids(drawmaterialRfBillids);
    }

    /**
     * 删除拉式发料信息
     * 
     * @param drawmaterialRfBillid 拉式发料主键
     * @return 结果
     */
    @Override
    public int deleteDrawmaterialRfBillByDrawmaterialRfBillid(Long drawmaterialRfBillid)
    {
        return drawmaterialRfBillMapper.deleteDrawmaterialRfBillByDrawmaterialRfBillid(drawmaterialRfBillid);
    }
}

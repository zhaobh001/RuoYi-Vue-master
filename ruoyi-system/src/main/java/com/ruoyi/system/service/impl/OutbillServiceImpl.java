package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OutbillMapper;
import com.ruoyi.system.domain.Outbill;
import com.ruoyi.system.service.IOutbillService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class OutbillServiceImpl implements IOutbillService 
{
    @Autowired
    private OutbillMapper outbillMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param outbillid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Outbill selectOutbillByOutbillid(Long outbillid)
    {
        return outbillMapper.selectOutbillByOutbillid(outbillid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outbill 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Outbill> selectOutbillList(Outbill outbill)
    {
        return outbillMapper.selectOutbillList(outbill);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param outbill 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOutbill(Outbill outbill)
    {
        return outbillMapper.insertOutbill(outbill);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param outbill 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOutbill(Outbill outbill)
    {
        return outbillMapper.updateOutbill(outbill);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outbillids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutbillByOutbillids(Long[] outbillids)
    {
        return outbillMapper.deleteOutbillByOutbillids(outbillids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param outbillid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutbillByOutbillid(Long outbillid)
    {
        return outbillMapper.deleteOutbillByOutbillid(outbillid);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param outbill 【请填写功能名称】
     * @return 结果
     */
    public List<Outbill> selecttransQty(Outbill outbill)
    {
        return outbillMapper.selecttransQty(outbill);
    }
}

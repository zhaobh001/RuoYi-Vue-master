package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeliverybillMapper;
import com.ruoyi.system.domain.Deliverybill;
import com.ruoyi.system.service.IDeliverybillService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
@Service
public class DeliverybillServiceImpl implements IDeliverybillService 
{
    @Autowired
    private DeliverybillMapper deliverybillMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param inbillid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Deliverybill selectDeliverybillByInbillid(Long inbillid)
    {
        return deliverybillMapper.selectDeliverybillByInbillid(inbillid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deliverybill 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Deliverybill> selectDeliverybillList(Deliverybill deliverybill)
    {
        return deliverybillMapper.selectDeliverybillList(deliverybill);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deliverybill 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeliverybill(Deliverybill deliverybill)
    {
        return deliverybillMapper.insertDeliverybill(deliverybill);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deliverybill 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeliverybill(Deliverybill deliverybill)
    {
        return deliverybillMapper.updateDeliverybill(deliverybill);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param inbillids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeliverybillByInbillids(Long[] inbillids)
    {
        return deliverybillMapper.deleteDeliverybillByInbillids(inbillids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param inbillid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeliverybillByInbillid(Long inbillid)
    {
        return deliverybillMapper.deleteDeliverybillByInbillid(inbillid);
    }
}

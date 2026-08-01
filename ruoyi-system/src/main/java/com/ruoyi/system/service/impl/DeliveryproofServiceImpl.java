package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeliveryproofMapper;
import com.ruoyi.system.domain.Deliveryproof;
import com.ruoyi.system.service.IDeliveryproofService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
@Service
public class DeliveryproofServiceImpl implements IDeliveryproofService 
{
    @Autowired
    private DeliveryproofMapper deliveryproofMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param inproofid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Deliveryproof selectDeliveryproofByInproofid(Long inproofid)
    {
        return deliveryproofMapper.selectDeliveryproofByInproofid(inproofid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deliveryproof 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Deliveryproof> selectDeliveryproofList(Deliveryproof deliveryproof)
    {
        return deliveryproofMapper.selectDeliveryproofList(deliveryproof);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deliveryproof 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeliveryproof(Deliveryproof deliveryproof)
    {
        return deliveryproofMapper.insertDeliveryproof(deliveryproof);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deliveryproof 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeliveryproof(Deliveryproof deliveryproof)
    {
        return deliveryproofMapper.updateDeliveryproof(deliveryproof);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param inproofids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeliveryproofByInproofids(Long[] inproofids)
    {
        return deliveryproofMapper.deleteDeliveryproofByInproofids(inproofids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param inproofid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeliveryproofByInproofid(Long inproofid)
    {
        return deliveryproofMapper.deleteDeliveryproofByInproofid(inproofid);
    }
}

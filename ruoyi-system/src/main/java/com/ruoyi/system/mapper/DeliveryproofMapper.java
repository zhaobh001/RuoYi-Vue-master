package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Deliveryproof;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
public interface DeliveryproofMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param inproofid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Deliveryproof selectDeliveryproofByInproofid(Long inproofid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deliveryproof 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Deliveryproof> selectDeliveryproofList(Deliveryproof deliveryproof);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deliveryproof 【请填写功能名称】
     * @return 结果
     */
    public int insertDeliveryproof(Deliveryproof deliveryproof);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deliveryproof 【请填写功能名称】
     * @return 结果
     */
    public int updateDeliveryproof(Deliveryproof deliveryproof);

    /**
     * 删除【请填写功能名称】
     * 
     * @param inproofid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeliveryproofByInproofid(Long inproofid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param inproofids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeliveryproofByInproofids(Long[] inproofids);
}

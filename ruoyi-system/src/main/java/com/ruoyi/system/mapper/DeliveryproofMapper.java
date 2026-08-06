package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Deliveryproof;
import io.lettuce.core.dynamic.annotation.Param;

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

    /**
     * 查询待同步到 DELIVERYPROOF 的出库凭证 ID 列表。
     *
     * <p>筛选条件：{@code transaction_type='5' AND outstate='2' AND data7 IS NOT NULL}，
     * 按 {@code data7} 倒序取前 100 条；且排除 DELIVERYPROOF 中已存在的 OUTPROOFID
     * （以 INPROOFID 关联），避免重复同步。
     *
     * @return 待同步的 OUTPROOFID 列表（已排序、限量 100）
     */
    public List<Long> selectPendingOutProofIds();

    /**
     * 根据单个 OUTPROOFID，将该出库凭证写入 DELIVERYPROOF（单条插入）。
     *
     * @param inproofid 出库凭证主键，同时作为 DELIVERYPROOF.INPROOFID
     * @return 插入行数
     */
    public int insertDeliveryProofById(Long inproofid);
}
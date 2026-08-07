package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Deliverybill;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
public interface DeliverybillMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param inbillid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Deliverybill selectDeliverybillByInbillid(Long inbillid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deliverybill 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Deliverybill> selectDeliverybillList(Deliverybill deliverybill);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deliverybill 【请填写功能名称】
     * @return 结果
     */
    public int insertDeliverybill(Deliverybill deliverybill);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deliverybill 【请填写功能名称】
     * @return 结果
     */
    public int updateDeliverybill(Deliverybill deliverybill);

    /**
     * 删除【请填写功能名称】
     * 
     * @param inbillid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeliverybillByInbillid(Long inbillid);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param inbillids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeliverybillByInbillids(Long[] inbillids);

    /**
     * 根据单个 OUTPROOFID，将该出库凭证对应的 OUTBILL/OUTTASKITEM/OUTCOLLECTDATA
     * 汇总写入 DELIVERYBILL（精确到单个凭证）。
     *
     * <p>按 OUTBILLID 去重，DELIVERYBILL 中已存在的 OUTBILLID 不再重复插入。
     *
     * @param inproofid 出库凭证主键（对应 DELIVERYBILL.INPROOFID）
     * @return 插入行数
     */
    public int insertDeliveryBillByOutProofId(@Param("inproofid") Long inproofid);
}

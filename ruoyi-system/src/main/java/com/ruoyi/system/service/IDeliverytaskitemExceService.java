package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DeliverytaskitemExce;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
public interface IDeliverytaskitemExceService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param exexid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DeliverytaskitemExce selectDeliverytaskitemExceByExexid(Long exexid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deliverytaskitemExce 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DeliverytaskitemExce> selectDeliverytaskitemExceList(DeliverytaskitemExce deliverytaskitemExce);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deliverytaskitemExce 【请填写功能名称】
     * @return 结果
     */
    public int insertDeliverytaskitemExce(DeliverytaskitemExce deliverytaskitemExce);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deliverytaskitemExce 【请填写功能名称】
     * @return 结果
     */
    public int updateDeliverytaskitemExce(DeliverytaskitemExce deliverytaskitemExce);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param exexids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteDeliverytaskitemExceByExexids(Long[] exexids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param exexid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeliverytaskitemExceByExexid(Long exexid);
}

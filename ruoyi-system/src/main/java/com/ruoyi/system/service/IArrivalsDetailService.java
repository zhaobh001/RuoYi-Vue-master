package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.ArrivalsBill;
import com.ruoyi.system.domain.ArrivalsDetail;

/**
 * 到货单明细Service接口
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public interface IArrivalsDetailService 
{
    /**
     * 查询到货单明细
     * 
     * @param arrivalsDetailid 到货单明细主键
     * @return 到货单明细
     */
    public ArrivalsDetail selectArrivalsDetailByArrivalsDetailid(Long arrivalsDetailid);

    /**
     * 查询到货单明细列表
     * 
     * @param arrivalsDetail 到货单明细
     * @return 到货单明细集合
     */
    public List<ArrivalsDetail> selectArrivalsDetailList(ArrivalsDetail arrivalsDetail);

    /**
     * 新增到货单明细
     * 
     * @param arrivalsDetail 到货单明细
     * @return 结果
     */
    public int insertArrivalsDetail(ArrivalsDetail arrivalsDetail);

    /**
     * 修改到货单明细
     * 
     * @param arrivalsDetail 到货单明细
     * @return 结果
     */
    public int updateArrivalsDetail(ArrivalsDetail arrivalsDetail);

    /**
     * 批量删除到货单明细
     * 
     * @param arrivalsDetailids 需要删除的到货单明细主键集合
     * @return 结果
     */
    public int deleteArrivalsDetailByArrivalsDetailids(Long[] arrivalsDetailids);

    /**
     * 删除到货单明细信息
     * 
     * @param arrivalsDetailid 到货单明细主键
     * @return 结果
     */
    public int deleteArrivalsDetailByArrivalsDetailid(Long arrivalsDetailid);

    /**
     * 根据到货单ID查询到货任务明细
     *
     * @param arrivalsDetail 用户主键
     * @return 到货单
     */
    public List<ArrivalsDetail> selectArriveDetailList(ArrivalsDetail arrivalsDetail);
}

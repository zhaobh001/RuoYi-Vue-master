package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ArrivalsDetailColl;

/**
 * PDA采集Service接口
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public interface IArrivalsDetailCollService 
{
    /**
     * 查询PDA采集
     * 
     * @param arrivalsDetailid PDA采集主键
     * @return PDA采集
     */
    public ArrivalsDetailColl selectArrivalsDetailCollByArrivalsDetailid(Long arrivalsDetailid);

    /**
     * 查询PDA采集列表
     * 
     * @param arrivalsDetailColl PDA采集
     * @return PDA采集集合
     */
    public List<ArrivalsDetailColl> selectArrivalsDetailCollList(ArrivalsDetailColl arrivalsDetailColl);

    /**
     * 新增PDA采集
     * 
     * @param arrivalsDetailColl PDA采集
     * @return 结果
     */
    public int insertArrivalsDetailColl(ArrivalsDetailColl arrivalsDetailColl);

    /**
     * 修改PDA采集
     * 
     * @param arrivalsDetailColl PDA采集
     * @return 结果
     */
    public int updateArrivalsDetailColl(ArrivalsDetailColl arrivalsDetailColl);

    /**
     * 批量删除PDA采集
     * 
     * @param arrivalsDetailids 需要删除的PDA采集主键集合
     * @return 结果
     */
    public int deleteArrivalsDetailCollByArrivalsDetailids(Long[] arrivalsDetailids);

    /**
     * 删除PDA采集信息
     * 
     * @param arrivalsDetailColl PDA采集
     * @return 结果
     */
    public int deleteArrivalsDetailCollByArrivalsDetailid(ArrivalsDetailColl arrivalsDetailColl);
}

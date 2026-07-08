package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Checkcollectdata;

/**
 * 盘库采集数据Service接口
 * 
 * @author ruoyi
 * @date 2023-08-28
 */
public interface ICheckcollectdataService 
{
    /**
     * 查询盘库采集数据
     * 
     * @param checkcollectdataid 盘库采集数据主键
     * @return 盘库采集数据
     */
    public Checkcollectdata selectCheckcollectdataByCheckcollectdataid(Long checkcollectdataid);

    /**
     * 查询盘库采集数据列表
     * 
     * @param checkcollectdata 盘库采集数据
     * @return 盘库采集数据集合
     */
    public List<Checkcollectdata> selectCheckcollectdataList(Checkcollectdata checkcollectdata);

    /**
     * 新增盘库采集数据
     * 
     * @param checkcollectdata 盘库采集数据
     * @return 结果
     */
    public int insertCheckcollectdata(Checkcollectdata checkcollectdata);

    /**
     * 修改盘库采集数据
     * 
     * @param checkcollectdata 盘库采集数据
     * @return 结果
     */
    public int updateCheckcollectdata(Checkcollectdata checkcollectdata);

    /**
     * 批量删除盘库采集数据
     * 
     * @param checkcollectdataids 需要删除的盘库采集数据主键集合
     * @return 结果
     */
    public int deleteCheckcollectdataByCheckcollectdataids(Long[] checkcollectdataids);

    /**
     * 删除盘库采集数据信息
     * 
     * @param checkcollectdataid 盘库采集数据主键
     * @return 结果
     */
    public int deleteCheckcollectdataByCheckcollectdataid(Long checkcollectdataid);
}

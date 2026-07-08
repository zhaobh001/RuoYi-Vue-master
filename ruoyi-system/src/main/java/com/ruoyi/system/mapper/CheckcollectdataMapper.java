package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Checkcollectdata;

/**
 * 盘库采集数据Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-28
 */
public interface CheckcollectdataMapper 
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
     * 删除盘库采集数据
     * 
     * @param checkcollectdataid 盘库采集数据主键
     * @return 结果
     */
    public int deleteCheckcollectdataByCheckcollectdataid(Long checkcollectdataid);

    /**
     * 批量删除盘库采集数据
     * 
     * @param checkcollectdataids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCheckcollectdataByCheckcollectdataids(Long[] checkcollectdataids);
}

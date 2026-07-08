package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CheckcollectdataMapper;
import com.ruoyi.system.domain.Checkcollectdata;
import com.ruoyi.system.service.ICheckcollectdataService;

/**
 * 盘库采集数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-28
 */
@Service
public class CheckcollectdataServiceImpl implements ICheckcollectdataService 
{
    @Autowired
    private CheckcollectdataMapper checkcollectdataMapper;

    /**
     * 查询盘库采集数据
     * 
     * @param checkcollectdataid 盘库采集数据主键
     * @return 盘库采集数据
     */
    @Override
    public Checkcollectdata selectCheckcollectdataByCheckcollectdataid(Long checkcollectdataid)
    {
        return checkcollectdataMapper.selectCheckcollectdataByCheckcollectdataid(checkcollectdataid);
    }

    /**
     * 查询盘库采集数据列表
     * 
     * @param checkcollectdata 盘库采集数据
     * @return 盘库采集数据
     */
    @Override
    public List<Checkcollectdata> selectCheckcollectdataList(Checkcollectdata checkcollectdata)
    {
        return checkcollectdataMapper.selectCheckcollectdataList(checkcollectdata);
    }

    /**
     * 新增盘库采集数据
     * 
     * @param checkcollectdata 盘库采集数据
     * @return 结果
     */
    @Override
    public int insertCheckcollectdata(Checkcollectdata checkcollectdata)
    {
        return checkcollectdataMapper.insertCheckcollectdata(checkcollectdata);
    }

    /**
     * 修改盘库采集数据
     * 
     * @param checkcollectdata 盘库采集数据
     * @return 结果
     */
    @Override
    public int updateCheckcollectdata(Checkcollectdata checkcollectdata)
    {
        return checkcollectdataMapper.updateCheckcollectdata(checkcollectdata);
    }

    /**
     * 批量删除盘库采集数据
     * 
     * @param checkcollectdataids 需要删除的盘库采集数据主键
     * @return 结果
     */
    @Override
    public int deleteCheckcollectdataByCheckcollectdataids(Long[] checkcollectdataids)
    {
        return checkcollectdataMapper.deleteCheckcollectdataByCheckcollectdataids(checkcollectdataids);
    }

    /**
     * 删除盘库采集数据信息
     * 
     * @param checkcollectdataid 盘库采集数据主键
     * @return 结果
     */
    @Override
    public int deleteCheckcollectdataByCheckcollectdataid(Long checkcollectdataid)
    {
        return checkcollectdataMapper.deleteCheckcollectdataByCheckcollectdataid(checkcollectdataid);
    }
}

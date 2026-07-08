package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ExpcollectdataMapper;
import com.ruoyi.system.domain.Expcollectdata;
import com.ruoyi.system.service.IExpcollectdataService;

/**
 * 异常登记采集 父为errlogsaveService业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-12
 */
@Service
public class ExpcollectdataServiceImpl implements IExpcollectdataService 
{
    @Autowired
    private ExpcollectdataMapper expcollectdataMapper;

    /**
     * 查询异常登记采集 父为errlogsave
     * 
     * @param expcollectdataid 异常登记采集 父为errlogsave主键
     * @return 异常登记采集 父为errlogsave
     */
    @Override
    public Expcollectdata selectExpcollectdataByExpcollectdataid(Long expcollectdataid)
    {
        return expcollectdataMapper.selectExpcollectdataByExpcollectdataid(expcollectdataid);
    }

    /**
     * 查询异常登记采集 父为errlogsave列表
     * 
     * @param expcollectdata 异常登记采集 父为errlogsave
     * @return 异常登记采集 父为errlogsave
     */
    @Override
    public List<Expcollectdata> selectExpcollectdataList(Expcollectdata expcollectdata)
    {
        return expcollectdataMapper.selectExpcollectdataList(expcollectdata);
    }

    /**
     * 新增异常登记采集 父为errlogsave
     * 
     * @param expcollectdata 异常登记采集 父为errlogsave
     * @return 结果
     */
    @Override
    public int insertExpcollectdata(Expcollectdata expcollectdata)
    {
        return expcollectdataMapper.insertExpcollectdata(expcollectdata);
    }

    /**
     * 修改异常登记采集 父为errlogsave
     * 
     * @param expcollectdata 异常登记采集 父为errlogsave
     * @return 结果
     */
    @Override
    public int updateExpcollectdata(Expcollectdata expcollectdata)
    {
        return expcollectdataMapper.updateExpcollectdata(expcollectdata);
    }

    /**
     * 批量删除异常登记采集 父为errlogsave
     * 
     * @param expcollectdataids 需要删除的异常登记采集 父为errlogsave主键
     * @return 结果
     */
    @Override
    public int deleteExpcollectdataByExpcollectdataids(Long[] expcollectdataids)
    {
        return expcollectdataMapper.deleteExpcollectdataByExpcollectdataids(expcollectdataids);
    }

    /**
     * 删除异常登记采集 父为errlogsave信息
     * 
     * @param expcollectdataid 异常登记采集 父为errlogsave主键
     * @return 结果
     */
    @Override
    public int deleteExpcollectdataByExpcollectdataid(Long expcollectdataid)
    {
        return expcollectdataMapper.deleteExpcollectdataByExpcollectdataid(expcollectdataid);
    }
}

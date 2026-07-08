package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OutcollectdataMapper;
import com.ruoyi.system.domain.Outcollectdata;
import com.ruoyi.system.service.IOutcollectdataService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class OutcollectdataServiceImpl implements IOutcollectdataService
{
    @Autowired
    private OutcollectdataMapper outcollectdataMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param outcollectdataid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Outcollectdata selectOutcollectdataByOutcollectdataid(Long outcollectdataid)
    {
        return outcollectdataMapper.selectOutcollectdataByOutcollectdataid(outcollectdataid);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outcollectdata 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Outcollectdata> selectOutcollectdataList(Outcollectdata outcollectdata)
    {
        return outcollectdataMapper.selectOutcollectdataList(outcollectdata);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param outcollectdata 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOutcollectdata(Outcollectdata outcollectdata)
    {
        return outcollectdataMapper.insertOutcollectdata(outcollectdata);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param outcollectdata 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOutcollectdata(Outcollectdata outcollectdata)
    {
        return outcollectdataMapper.updateOutcollectdata(outcollectdata);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param outcollectdataids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutcollectdataByOutcollectdataids(Long[] outcollectdataids)
    {
        return outcollectdataMapper.deleteOutcollectdataByOutcollectdataids(outcollectdataids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param outcollectdataid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutcollectdataByOutcollectdataid(Long outcollectdataid)
    {
        return outcollectdataMapper.deleteOutcollectdataByOutcollectdataid(outcollectdataid);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param list 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOutcollectdataBatch(List<Outcollectdata> list)
    {
        return outcollectdataMapper.insertOutcollectdataBatch(list);
    }
}

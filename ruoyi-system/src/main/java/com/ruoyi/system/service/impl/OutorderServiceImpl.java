package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OutorderMapper;
import com.ruoyi.system.domain.Outorder;
import com.ruoyi.system.service.IOutorderService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class OutorderServiceImpl implements IOutorderService 
{
    @Autowired
    private OutorderMapper outorderMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param outorderid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Outorder selectOutorderByOutorderid(Long outorderid)
    {
        return outorderMapper.selectOutorderByOutorderid(outorderid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outorder 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Outorder> selectOutorderList(Outorder outorder)
    {
        return outorderMapper.selectOutorderList(outorder);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param outorder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOutorder(Outorder outorder)
    {
        return outorderMapper.insertOutorder(outorder);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param outorder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOutorder(Outorder outorder)
    {
        return outorderMapper.updateOutorder(outorder);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outorderids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutorderByOutorderids(Long[] outorderids)
    {
        return outorderMapper.deleteOutorderByOutorderids(outorderids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param outorderid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutorderByOutorderid(Long outorderid)
    {
        return outorderMapper.deleteOutorderByOutorderid(outorderid);
    }
}

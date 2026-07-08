package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OutproofMapper;
import com.ruoyi.system.domain.Outproof;
import com.ruoyi.system.service.IOutproofService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class OutproofServiceImpl implements IOutproofService 
{
    @Autowired
    private OutproofMapper outproofMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param outproofid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Outproof selectOutproofByOutproofid(Long outproofid)
    {
        return outproofMapper.selectOutproofByOutproofid(outproofid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outproof 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Outproof> selectOutproofList(Outproof outproof)
    {
        return outproofMapper.selectOutproofList(outproof);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param outproof 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOutproof(Outproof outproof)
    {
        return outproofMapper.insertOutproof(outproof);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param outproof 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOutproof(Outproof outproof)
    {
        return outproofMapper.updateOutproof(outproof);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outproofids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutproofByOutproofids(Long[] outproofids)
    {
        return outproofMapper.deleteOutproofByOutproofids(outproofids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param outproofid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutproofByOutproofid(Long outproofid)
    {
        return outproofMapper.deleteOutproofByOutproofid(outproofid);
    }
}

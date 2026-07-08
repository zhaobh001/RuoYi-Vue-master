package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OutsubinventoryMapper;
import com.ruoyi.system.domain.Outsubinventory;
import com.ruoyi.system.service.IOutsubinventoryService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class OutsubinventoryServiceImpl implements IOutsubinventoryService 
{
    @Autowired
    private OutsubinventoryMapper outsubinventoryMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param subinventoryid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Outsubinventory selectOutsubinventoryBySubinventoryid(Long subinventoryid)
    {
        return outsubinventoryMapper.selectOutsubinventoryBySubinventoryid(subinventoryid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outsubinventory 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Outsubinventory> selectOutsubinventoryList(Outsubinventory outsubinventory)
    {
        return outsubinventoryMapper.selectOutsubinventoryList(outsubinventory);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param outsubinventory 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOutsubinventory(Outsubinventory outsubinventory)
    {
        return outsubinventoryMapper.insertOutsubinventory(outsubinventory);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param outsubinventory 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOutsubinventory(Outsubinventory outsubinventory)
    {
        return outsubinventoryMapper.updateOutsubinventory(outsubinventory);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param subinventoryids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutsubinventoryBySubinventoryids(Long[] subinventoryids)
    {
        return outsubinventoryMapper.deleteOutsubinventoryBySubinventoryids(subinventoryids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param subinventoryid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutsubinventoryBySubinventoryid(Long subinventoryid)
    {
        return outsubinventoryMapper.deleteOutsubinventoryBySubinventoryid(subinventoryid);
    }
}

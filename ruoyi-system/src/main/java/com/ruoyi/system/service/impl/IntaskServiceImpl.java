package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.IntaskMapper;
import com.ruoyi.system.domain.Intask;
import com.ruoyi.system.service.IIntaskService;

/**
 * 入库任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
@Service
public class IntaskServiceImpl implements IIntaskService 
{
    @Autowired
    private IntaskMapper intaskMapper;

    /**
     * 查询入库任务
     * 
     * @param intaskid 入库任务主键
     * @return 入库任务
     */
    @Override
    public Intask selectIntaskByIntaskid(Long intaskid)
    {
        return intaskMapper.selectIntaskByIntaskid(intaskid);
    }

    /**
     * 查询入库任务列表
     * 
     * @param intask 入库任务
     * @return 入库任务
     */
    @Override
    public List<Intask> selectIntaskList(Intask intask)
    {
        return intaskMapper.selectIntaskList(intask);
    }

    /**
     * 新增入库任务
     * 
     * @param intask 入库任务
     * @return 结果
     */
    @Override
    public int insertIntask(Intask intask)
    {
        return intaskMapper.insertIntask(intask);
    }

    /**
     * 修改入库任务
     * 
     * @param intask 入库任务
     * @return 结果
     */
    @Override
    public int updateIntask(Intask intask)
    {
        return intaskMapper.updateIntask(intask);
    }

    /**
     * 批量删除入库任务
     * 
     * @param intaskids 需要删除的入库任务主键
     * @return 结果
     */
    @Override
    public int deleteIntaskByIntaskids(Long[] intaskids)
    {
        return intaskMapper.deleteIntaskByIntaskids(intaskids);
    }

    /**
     * 删除入库任务信息
     * 
     * @param intaskid 入库任务主键
     * @return 结果
     */
    @Override
    public int deleteIntaskByIntaskid(Long intaskid)
    {
        return intaskMapper.deleteIntaskByIntaskid(intaskid);
    }

    /**
     * 查询入库任务
     *
     * @param intaskno 入库任务主键
     * @return 入库任务
     */
    public Intask selectIntaskByIntaskNo(String intaskno)

    {
        return intaskMapper.selectIntaskByIntaskNo(intaskno);
    };

    /**
     * 查询入库任务列表
     *
     * @param intask 入库任务
     * @return 入库任务
     */
    @Override
    public List<Intask> selectIntaskListDelivery(Intask intask)
    {
        return intaskMapper.selectIntaskListDelivery(intask);
    }
}

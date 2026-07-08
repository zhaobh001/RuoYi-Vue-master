package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChecktaskMapper;
import com.ruoyi.system.domain.Checktask;
import com.ruoyi.system.service.IChecktaskService;

/**
 * 盘库任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-26
 */
@Service
public class ChecktaskServiceImpl implements IChecktaskService 
{
    @Autowired
    private ChecktaskMapper checktaskMapper;

    /**
     * 查询盘库任务
     * 
     * @param checktaskid 盘库任务主键
     * @return 盘库任务
     */
    @Override
    public Checktask selectChecktaskByChecktaskid(Long checktaskid)
    {
        return checktaskMapper.selectChecktaskByChecktaskid(checktaskid);
    }

    /**
     * 查询盘库任务列表
     * 
     * @param checktask 盘库任务
     * @return 盘库任务
     */
    @Override
    public List<Checktask> selectChecktaskList(Checktask checktask)
    {
        return checktaskMapper.selectChecktaskList(checktask);
    }

    /**
     * 新增盘库任务
     * 
     * @param checktask 盘库任务
     * @return 结果
     */
    @Override
    public int insertChecktask(Checktask checktask)
    {
        return checktaskMapper.insertChecktask(checktask);
    }

    /**
     * 修改盘库任务
     * 
     * @param checktask 盘库任务
     * @return 结果
     */
    @Override
    public int updateChecktask(Checktask checktask)
    {
        return checktaskMapper.updateChecktask(checktask);
    }

    /**
     * 批量删除盘库任务
     * 
     * @param checktaskids 需要删除的盘库任务主键
     * @return 结果
     */
    @Override
    public int deleteChecktaskByChecktaskids(Long[] checktaskids)
    {
        return checktaskMapper.deleteChecktaskByChecktaskids(checktaskids);
    }

    /**
     * 删除盘库任务信息
     * 
     * @param checktaskid 盘库任务主键
     * @return 结果
     */
    @Override
    public int deleteChecktaskByChecktaskid(Long checktaskid)
    {
        return checktaskMapper.deleteChecktaskByChecktaskid(checktaskid);
    }

    /**
     * 查询盘库任务列表
     *
     * @param checktask 盘库任务
     * @return 盘库任务集合
     */
    public List<Checktask> getInventoryTask(Checktask checktask){
        return checktaskMapper.getInventoryTask(checktask);
    };

    /**
     * 查询盘库任务列表
     *
     * @param taskcomment 盘库任务
     * @return 盘库任务集合
     */
    public List<Checktask> getInventoryTaskCol(String taskcomment){
        return checktaskMapper.getInventoryTaskCol(taskcomment);
    };

    /**
     * 查询盘库任务列表
     *
     * @param checktask 盘库任务
     * @return 盘库任务集合
     */
    public List<Checktask> getInventoryTaskItem(Checktask checktask){
        return checktaskMapper.getInventoryTaskItem(checktask);
    };
}

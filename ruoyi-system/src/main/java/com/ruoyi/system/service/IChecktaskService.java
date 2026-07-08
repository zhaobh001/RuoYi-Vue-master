package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Checktask;
import com.ruoyi.system.domain.Intask;

/**
 * 盘库任务Service接口
 * 
 * @author ruoyi
 * @date 2023-08-26
 */
public interface IChecktaskService 
{
    /**
     * 查询盘库任务
     * 
     * @param checktaskid 盘库任务主键
     * @return 盘库任务
     */
    public Checktask selectChecktaskByChecktaskid(Long checktaskid);

    /**
     * 查询盘库任务列表
     * 
     * @param checktask 盘库任务
     * @return 盘库任务集合
     */
    public List<Checktask> selectChecktaskList(Checktask checktask);

    /**
     * 新增盘库任务
     * 
     * @param checktask 盘库任务
     * @return 结果
     */
    public int insertChecktask(Checktask checktask);

    /**
     * 修改盘库任务
     * 
     * @param checktask 盘库任务
     * @return 结果
     */
    public int updateChecktask(Checktask checktask);

    /**
     * 批量删除盘库任务
     * 
     * @param checktaskids 需要删除的盘库任务主键集合
     * @return 结果
     */
    public int deleteChecktaskByChecktaskids(Long[] checktaskids);

    /**
     * 删除盘库任务信息
     * 
     * @param checktaskid 盘库任务主键
     * @return 结果
     */
    public int deleteChecktaskByChecktaskid(Long checktaskid);

    /**
     * 查询盘库任务列表
     *
     * @param checktask 盘库任务
     * @return 盘库任务集合
     */
    public List<Checktask> getInventoryTask(Checktask checktask);

    /**
     * 查询盘库任务列表
     *
     * @param taskcomment 盘库任务
     * @return 盘库任务集合
     */
    public List<Checktask> getInventoryTaskCol(String taskcomment);

    /**
     * 查询盘库任务列表
     *
     * @param checktask 盘库任务
     * @return 盘库任务集合
     */
    public List<Checktask> getInventoryTaskItem(Checktask checktask);
}

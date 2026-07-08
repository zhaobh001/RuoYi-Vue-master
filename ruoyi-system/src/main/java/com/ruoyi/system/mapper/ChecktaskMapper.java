package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Checktask;

/**
 * 盘库任务Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-26
 */
public interface ChecktaskMapper 
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
     * 删除盘库任务
     * 
     * @param checktaskid 盘库任务主键
     * @return 结果
     */
    public int deleteChecktaskByChecktaskid(Long checktaskid);

    /**
     * 批量删除盘库任务
     * 
     * @param checktaskids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChecktaskByChecktaskids(Long[] checktaskids);

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

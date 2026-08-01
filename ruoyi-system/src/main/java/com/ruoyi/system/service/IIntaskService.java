package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Intask;

/**
 * 入库任务Service接口
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public interface IIntaskService 
{
    /**
     * 查询入库任务
     * 
     * @param intaskid 入库任务主键
     * @return 入库任务
     */
    public Intask selectIntaskByIntaskid(Long intaskid);

    /**
     * 查询入库任务列表
     * 
     * @param intask 入库任务
     * @return 入库任务集合
     */
    public List<Intask> selectIntaskList(Intask intask);

    /**
     * 新增入库任务
     * 
     * @param intask 入库任务
     * @return 结果
     */
    public int insertIntask(Intask intask);

    /**
     * 修改入库任务
     * 
     * @param intask 入库任务
     * @return 结果
     */
    public int updateIntask(Intask intask);

    /**
     * 批量删除入库任务
     * 
     * @param intaskids 需要删除的入库任务主键集合
     * @return 结果
     */
    public int deleteIntaskByIntaskids(Long[] intaskids);

    /**
     * 删除入库任务信息
     * 
     * @param intaskid 入库任务主键
     * @return 结果
     */
    public int deleteIntaskByIntaskid(Long intaskid);

    /**
     * 查询入库任务
     *
     * @param intaskno 入库任务主键
     * @return 入库任务
     */
    public Intask selectIntaskByIntaskNo(String intaskno);

    /**
     * 查询入库任务列表
     *
     * @param intask 入库任务
     * @return 入库任务集合
     */
    public List<Intask> selectIntaskListDelivery(Intask intask);
}

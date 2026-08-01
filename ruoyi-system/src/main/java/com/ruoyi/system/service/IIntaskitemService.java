package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Intaskitem;

/**
 * 入库任务明细Service接口
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public interface IIntaskitemService 
{
    /**
     * 查询入库任务明细
     * 
     * @param intaskitemid 入库任务明细主键
     * @return 入库任务明细
     */
    public Intaskitem selectIntaskitemByIntaskitemid(Long intaskitemid);

    /**
     * 查询入库任务明细列表
     * 
     * @param intaskitem 入库任务明细
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectIntaskitemList(Intaskitem intaskitem);

    /**
     * 新增入库任务明细
     * 
     * @param intaskitem 入库任务明细
     * @return 结果
     */
    public int insertIntaskitem(Intaskitem intaskitem);

    /**
     * 修改入库任务明细
     * 
     * @param intaskitem 入库任务明细
     * @return 结果
     */
    public int updateIntaskitem(Intaskitem intaskitem);

    /**
     * 批量删除入库任务明细
     * 
     * @param intaskitemids 需要删除的入库任务明细主键集合
     * @return 结果
     */
    public int deleteIntaskitemByIntaskitemids(Long[] intaskitemids);

    /**
     * 删除入库任务明细信息
     * 
     * @param intaskitemid 入库任务明细主键
     * @return 结果
     */
    public int deleteIntaskitemByIntaskitemid(Long intaskitemid);

    /**
     * 查询入库任务明细列表
     *
     * @param intaskitem 入库任务明细
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectIntaskitemList2(Intaskitem intaskitem);

    /**
     * 查询入库任务明细列表
     *
     * @param intaskid 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectIntaskitemList3(Long intaskid);

    /**
     * 获取已接收状态的整盘上架任务信息
     *
     * @param intaskitem 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> getInTaskPalletNoByUserID(Intaskitem intaskitem);

    /**
     * 根据上架任务号获取上架托盘号
     *
     * @param intaskitem 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> getInTaskPalletNo(Intaskitem intaskitem);

    /**
     * 根据托盘号获取任务
     *
     * @param intaskitem 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectInTaskByPalletNoCol(Intaskitem intaskitem);

    /**
     * 根据托盘号获取任务
     *
     * @param intaskitem 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectInTaskByPalletNo(Intaskitem intaskitem);

    /**
     * 根据托盘号获取任务
     *
     * @param intaskitem 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectIntaskitemListDelivery(Intaskitem intaskitem);
}

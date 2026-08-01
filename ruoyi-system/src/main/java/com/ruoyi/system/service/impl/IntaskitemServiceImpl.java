package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.IntaskitemMapper;
import com.ruoyi.system.domain.Intaskitem;
import com.ruoyi.system.service.IIntaskitemService;

/**
 * 入库任务明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
@Service
public class IntaskitemServiceImpl implements IIntaskitemService 
{
    @Autowired
    private IntaskitemMapper intaskitemMapper;

    /**
     * 查询入库任务明细
     * 
     * @param intaskitemid 入库任务明细主键
     * @return 入库任务明细
     */
    @Override
    public Intaskitem selectIntaskitemByIntaskitemid(Long intaskitemid)
    {
        return intaskitemMapper.selectIntaskitemByIntaskitemid(intaskitemid);
    }

    /**
     * 查询入库任务明细列表
     * 
     * @param intaskitem 入库任务明细
     * @return 入库任务明细
     */
    @Override
    public List<Intaskitem> selectIntaskitemList(Intaskitem intaskitem)
    {
        return intaskitemMapper.selectIntaskitemList(intaskitem);
    }

    /**
     * 新增入库任务明细
     * 
     * @param intaskitem 入库任务明细
     * @return 结果
     */
    @Override
    public int insertIntaskitem(Intaskitem intaskitem)
    {
        return intaskitemMapper.insertIntaskitem(intaskitem);
    }

    /**
     * 修改入库任务明细
     * 
     * @param intaskitem 入库任务明细
     * @return 结果
     */
    @Override
    public int updateIntaskitem(Intaskitem intaskitem)
    {
        return intaskitemMapper.updateIntaskitem(intaskitem);
    }

    /**
     * 批量删除入库任务明细
     * 
     * @param intaskitemids 需要删除的入库任务明细主键
     * @return 结果
     */
    @Override
    public int deleteIntaskitemByIntaskitemids(Long[] intaskitemids)
    {
        return intaskitemMapper.deleteIntaskitemByIntaskitemids(intaskitemids);
    }

    /**
     * 删除入库任务明细信息
     * 
     * @param intaskitemid 入库任务明细主键
     * @return 结果
     */
    @Override
    public int deleteIntaskitemByIntaskitemid(Long intaskitemid)
    {
        return intaskitemMapper.deleteIntaskitemByIntaskitemid(intaskitemid);
    }

    /**
     * 查询入库任务明细列表
     *
     * @param intaskitem 入库任务明细
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectIntaskitemList2(Intaskitem intaskitem)   {
        return intaskitemMapper.selectIntaskitemList2(intaskitem);
    }

    /**
     * 查询入库任务明细列表
     *
     * @param intaskid 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectIntaskitemList3(Long intaskid){
        return intaskitemMapper.selectIntaskitemList3(intaskid);
    };

    /**
     * 获取已接收状态的整盘上架任务信息
     *
     * @param intaskitem 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> getInTaskPalletNoByUserID(Intaskitem intaskitem){
        return intaskitemMapper.getInTaskPalletNoByUserID(intaskitem);
    };

    /**
     * 根据上架任务号获取上架托盘号
     *
     * @param intaskitem 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> getInTaskPalletNo(Intaskitem intaskitem){
        return intaskitemMapper.getInTaskPalletNo(intaskitem);
    };

    /**
     * 根据托盘号获取任务
     *
     * @param intaskitem 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectInTaskByPalletNo(Intaskitem intaskitem){
        return intaskitemMapper.selectInTaskByPalletNo(intaskitem);
    };
    /**
     * 根据托盘号获取任务
     *
     * @param intaskitem 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectInTaskByPalletNoCol(Intaskitem intaskitem){
        return intaskitemMapper.selectInTaskByPalletNo(intaskitem);
    };

    /**
     * 根据托盘号获取任务
     *
     * @param intaskitem 入库任务ID
     * @return 入库任务明细集合
     */
    public List<Intaskitem> selectIntaskitemListDelivery(Intaskitem intaskitem){
        return intaskitemMapper.selectIntaskitemListDelivery(intaskitem);
    };
}

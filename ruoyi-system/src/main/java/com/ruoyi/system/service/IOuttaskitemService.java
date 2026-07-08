package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Outtaskitem;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface IOuttaskitemService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param outtaskitemid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Outtaskitem selectOuttaskitemByOuttaskitemid(Long outtaskitemid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selectOuttaskitemList(Outtaskitem outtaskitem);

    /**
     * 新增【请填写功能名称】
     * 
     * @param outtaskitem 【请填写功能名称】
     * @return 结果
     */
    public int insertOuttaskitem(Outtaskitem outtaskitem);

    /**
     * 修改【请填写功能名称】
     * 
     * @param outtaskitem 【请填写功能名称】
     * @return 结果
     */
    public int updateOuttaskitem(Outtaskitem outtaskitem);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outtaskitemids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteOuttaskitemByOuttaskitemids(Long[] outtaskitemids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param outtaskitemid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOuttaskitemByOuttaskitemid(Long outtaskitemid);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selectOuttaskitemList2(Outtaskitem outtaskitem);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> getOutTaskItem(Outtaskitem outtaskitem);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> getOutTaskPalletNoByUserID(Outtaskitem outtaskitem);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> getOutTaskPalletNo(Outtaskitem outtaskitem);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selectOutTaskByPalletNoCol(Outtaskitem outtaskitem);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selectOutTaskByPalletNo(Outtaskitem outtaskitem);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selectOuttaskitemList3(Outtaskitem outtaskitem);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> getOutTaskItemFinish(Outtaskitem outtaskitem);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selecttransQty(Outtaskitem outtaskitem);
}

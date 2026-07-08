package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OuttaskitemMapper;
import com.ruoyi.system.domain.Outtaskitem;
import com.ruoyi.system.service.IOuttaskitemService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class OuttaskitemServiceImpl implements IOuttaskitemService 
{
    @Autowired
    private OuttaskitemMapper outtaskitemMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param outtaskitemid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Outtaskitem selectOuttaskitemByOuttaskitemid(Long outtaskitemid)
    {
        return outtaskitemMapper.selectOuttaskitemByOuttaskitemid(outtaskitemid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Outtaskitem> selectOuttaskitemList(Outtaskitem outtaskitem)
    {
        return outtaskitemMapper.selectOuttaskitemList(outtaskitem);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param outtaskitem 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOuttaskitem(Outtaskitem outtaskitem)
    {
        return outtaskitemMapper.insertOuttaskitem(outtaskitem);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param outtaskitem 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOuttaskitem(Outtaskitem outtaskitem)
    {
        return outtaskitemMapper.updateOuttaskitem(outtaskitem);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outtaskitemids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOuttaskitemByOuttaskitemids(Long[] outtaskitemids)
    {
        return outtaskitemMapper.deleteOuttaskitemByOuttaskitemids(outtaskitemids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param outtaskitemid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOuttaskitemByOuttaskitemid(Long outtaskitemid)
    {
        return outtaskitemMapper.deleteOuttaskitemByOuttaskitemid(outtaskitemid);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selectOuttaskitemList2(Outtaskitem outtaskitem)
    {
        return outtaskitemMapper.selectOuttaskitemList2(outtaskitem);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> getOutTaskItem(Outtaskitem outtaskitem)    {
        return outtaskitemMapper.getOutTaskItem(outtaskitem);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> getOutTaskPalletNoByUserID(Outtaskitem outtaskitem)   {
        return outtaskitemMapper.getOutTaskPalletNoByUserID(outtaskitem);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> getOutTaskPalletNo(Outtaskitem outtaskitem)   {
        return outtaskitemMapper.getOutTaskPalletNo(outtaskitem);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selectOutTaskByPalletNoCol(Outtaskitem outtaskitem)  {
        return outtaskitemMapper.selectOutTaskByPalletNoCol(outtaskitem);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selectOutTaskByPalletNo(Outtaskitem outtaskitem)  {
        return outtaskitemMapper.selectOutTaskByPalletNo(outtaskitem);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selectOuttaskitemList3(Outtaskitem outtaskitem) {
        return outtaskitemMapper.selectOuttaskitemList3(outtaskitem);
    };

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> getOutTaskItemFinish(Outtaskitem outtaskitem){
        return outtaskitemMapper.getOutTaskItemFinish(outtaskitem);
    };

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtaskitem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtaskitem> selecttransQty(Outtaskitem outtaskitem){
        return outtaskitemMapper.selecttransQty(outtaskitem);
    };
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OuttaskMapper;
import com.ruoyi.system.domain.Outtask;
import com.ruoyi.system.service.IOuttaskService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class OuttaskServiceImpl implements IOuttaskService 
{
    @Autowired
    private OuttaskMapper outtaskMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param outtaskid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Outtask selectOuttaskByOuttaskid(Long outtaskid)
    {
        return outtaskMapper.selectOuttaskByOuttaskid(outtaskid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outtask 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Outtask> selectOuttaskList(Outtask outtask)
    {
        return outtaskMapper.selectOuttaskList(outtask);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param outtask 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOuttask(Outtask outtask)
    {
        return outtaskMapper.insertOuttask(outtask);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param outtask 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOuttask(Outtask outtask)
    {
        return outtaskMapper.updateOuttask(outtask);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outtaskids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOuttaskByOuttaskids(Long[] outtaskids)
    {
        return outtaskMapper.deleteOuttaskByOuttaskids(outtaskids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param outtaskid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOuttaskByOuttaskid(Long outtaskid)
    {
        return outtaskMapper.deleteOuttaskByOuttaskid(outtaskid);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtask 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtask> selectOuttaskList2(Outtask outtask)    {
        return outtaskMapper.selectOuttaskList2(outtask);
    }

    /**
     * 查询【请填写功能名称】
     *
     * @param outtaskno 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Outtask selectOuttaskByOuttaskno(String outtaskno)    {
        return outtaskMapper.selectOuttaskByOuttaskno(outtaskno);
    }
    /**
     * 查询【请填写功能名称】
     *
     * @param outtask 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public List<Outtask>  getOutTaskPalletNoByUserID(Outtask outtask){
        return outtaskMapper.getOutTaskPalletNoByUserID(outtask);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtask 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtask> selectOuttaskList3(Outtask outtask){
        return outtaskMapper.selectOuttaskList3(outtask);
    }
}

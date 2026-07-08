package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Outtask;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface OuttaskMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param outtaskid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Outtask selectOuttaskByOuttaskid(Long outtaskid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outtask 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtask> selectOuttaskList(Outtask outtask);

    /**
     * 新增【请填写功能名称】
     * 
     * @param outtask 【请填写功能名称】
     * @return 结果
     */
    public int insertOuttask(Outtask outtask);

    /**
     * 修改【请填写功能名称】
     * 
     * @param outtask 【请填写功能名称】
     * @return 结果
     */
    public int updateOuttask(Outtask outtask);

    /**
     * 删除【请填写功能名称】
     * 
     * @param outtaskid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOuttaskByOuttaskid(Long outtaskid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outtaskids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOuttaskByOuttaskids(Long[] outtaskids);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtask 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtask> selectOuttaskList2(Outtask outtask);

    /**
     * 查询【请填写功能名称】
     *
     * @param outtaskno 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Outtask selectOuttaskByOuttaskno(String outtaskno);

    /**
     * 查询【请填写功能名称】
     *
     * @param outtask 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public List<Outtask>  getOutTaskPalletNoByUserID(Outtask outtask);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outtask 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outtask> selectOuttaskList3(Outtask outtask);

}

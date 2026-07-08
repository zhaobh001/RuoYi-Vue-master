package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Outproof;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface OutproofMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param outproofid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Outproof selectOutproofByOutproofid(Long outproofid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outproof 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outproof> selectOutproofList(Outproof outproof);

    /**
     * 新增【请填写功能名称】
     * 
     * @param outproof 【请填写功能名称】
     * @return 结果
     */
    public int insertOutproof(Outproof outproof);

    /**
     * 修改【请填写功能名称】
     * 
     * @param outproof 【请填写功能名称】
     * @return 结果
     */
    public int updateOutproof(Outproof outproof);

    /**
     * 删除【请填写功能名称】
     * 
     * @param outproofid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOutproofByOutproofid(Long outproofid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outproofids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOutproofByOutproofids(Long[] outproofids);
}

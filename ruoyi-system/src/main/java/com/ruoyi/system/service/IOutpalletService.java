package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Outpallet;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface IOutpalletService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param pallettaskid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Outpallet selectOutpalletByPallettaskid(Long pallettaskid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outpallet 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outpallet> selectOutpalletList(Outpallet outpallet);

    /**
     * 新增【请填写功能名称】
     * 
     * @param outpallet 【请填写功能名称】
     * @return 结果
     */
    public int insertOutpallet(Outpallet outpallet);

    /**
     * 修改【请填写功能名称】
     * 
     * @param outpallet 【请填写功能名称】
     * @return 结果
     */
    public int updateOutpallet(Outpallet outpallet);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param pallettaskids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteOutpalletByPallettaskids(Long[] pallettaskids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param pallettaskid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOutpalletByPallettaskid(Long pallettaskid);
}

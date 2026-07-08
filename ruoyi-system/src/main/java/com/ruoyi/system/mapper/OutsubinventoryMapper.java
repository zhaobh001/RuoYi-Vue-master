package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Outsubinventory;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface OutsubinventoryMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param subinventoryid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Outsubinventory selectOutsubinventoryBySubinventoryid(Long subinventoryid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outsubinventory 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outsubinventory> selectOutsubinventoryList(Outsubinventory outsubinventory);

    /**
     * 新增【请填写功能名称】
     * 
     * @param outsubinventory 【请填写功能名称】
     * @return 结果
     */
    public int insertOutsubinventory(Outsubinventory outsubinventory);

    /**
     * 修改【请填写功能名称】
     * 
     * @param outsubinventory 【请填写功能名称】
     * @return 结果
     */
    public int updateOutsubinventory(Outsubinventory outsubinventory);

    /**
     * 删除【请填写功能名称】
     * 
     * @param subinventoryid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOutsubinventoryBySubinventoryid(Long subinventoryid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param subinventoryids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOutsubinventoryBySubinventoryids(Long[] subinventoryids);
}

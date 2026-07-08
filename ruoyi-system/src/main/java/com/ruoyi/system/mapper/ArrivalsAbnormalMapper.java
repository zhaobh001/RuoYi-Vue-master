package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ArrivalsAbnormal;

/**
 * 到货异常信息,已单据为单位,不和具体物料关联Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public interface ArrivalsAbnormalMapper 
{
    /**
     * 查询到货异常信息,已单据为单位,不和具体物料关联
     * 
     * @param abnomalid 到货异常信息,已单据为单位,不和具体物料关联主键
     * @return 到货异常信息,已单据为单位,不和具体物料关联
     */
    public ArrivalsAbnormal selectArrivalsAbnormalByAbnomalid(Long abnomalid);

    /**
     * 查询到货异常信息,已单据为单位,不和具体物料关联列表
     * 
     * @param arrivalsAbnormal 到货异常信息,已单据为单位,不和具体物料关联
     * @return 到货异常信息,已单据为单位,不和具体物料关联集合
     */
    public List<ArrivalsAbnormal> selectArrivalsAbnormalList(ArrivalsAbnormal arrivalsAbnormal);

    /**
     * 新增到货异常信息,已单据为单位,不和具体物料关联
     * 
     * @param arrivalsAbnormal 到货异常信息,已单据为单位,不和具体物料关联
     * @return 结果
     */
    public int insertArrivalsAbnormal(ArrivalsAbnormal arrivalsAbnormal);

    /**
     * 修改到货异常信息,已单据为单位,不和具体物料关联
     * 
     * @param arrivalsAbnormal 到货异常信息,已单据为单位,不和具体物料关联
     * @return 结果
     */
    public int updateArrivalsAbnormal(ArrivalsAbnormal arrivalsAbnormal);

    /**
     * 删除到货异常信息,已单据为单位,不和具体物料关联
     * 
     * @param abnomalid 到货异常信息,已单据为单位,不和具体物料关联主键
     * @return 结果
     */
    public int deleteArrivalsAbnormalByAbnomalid(Long abnomalid);

    /**
     * 批量删除到货异常信息,已单据为单位,不和具体物料关联
     * 
     * @param abnomalids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArrivalsAbnormalByAbnomalids(Long[] abnomalids);
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ArrivalsAbnormalMapper;
import com.ruoyi.system.domain.ArrivalsAbnormal;
import com.ruoyi.system.service.IArrivalsAbnormalService;

/**
 * 到货异常信息,已单据为单位,不和具体物料关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
@Service
public class ArrivalsAbnormalServiceImpl implements IArrivalsAbnormalService 
{
    @Autowired
    private ArrivalsAbnormalMapper arrivalsAbnormalMapper;

    /**
     * 查询到货异常信息,已单据为单位,不和具体物料关联
     * 
     * @param abnomalid 到货异常信息,已单据为单位,不和具体物料关联主键
     * @return 到货异常信息,已单据为单位,不和具体物料关联
     */
    @Override
    public ArrivalsAbnormal selectArrivalsAbnormalByAbnomalid(Long abnomalid)
    {
        return arrivalsAbnormalMapper.selectArrivalsAbnormalByAbnomalid(abnomalid);
    }

    /**
     * 查询到货异常信息,已单据为单位,不和具体物料关联列表
     * 
     * @param arrivalsAbnormal 到货异常信息,已单据为单位,不和具体物料关联
     * @return 到货异常信息,已单据为单位,不和具体物料关联
     */
    @Override
    public List<ArrivalsAbnormal> selectArrivalsAbnormalList(ArrivalsAbnormal arrivalsAbnormal)
    {
        return arrivalsAbnormalMapper.selectArrivalsAbnormalList(arrivalsAbnormal);
    }

    /**
     * 新增到货异常信息,已单据为单位,不和具体物料关联
     * 
     * @param arrivalsAbnormal 到货异常信息,已单据为单位,不和具体物料关联
     * @return 结果
     */
    @Override
    public int insertArrivalsAbnormal(ArrivalsAbnormal arrivalsAbnormal)
    {
        return arrivalsAbnormalMapper.insertArrivalsAbnormal(arrivalsAbnormal);
    }

    /**
     * 修改到货异常信息,已单据为单位,不和具体物料关联
     * 
     * @param arrivalsAbnormal 到货异常信息,已单据为单位,不和具体物料关联
     * @return 结果
     */
    @Override
    public int updateArrivalsAbnormal(ArrivalsAbnormal arrivalsAbnormal)
    {
        return arrivalsAbnormalMapper.updateArrivalsAbnormal(arrivalsAbnormal);
    }

    /**
     * 批量删除到货异常信息,已单据为单位,不和具体物料关联
     * 
     * @param abnomalids 需要删除的到货异常信息,已单据为单位,不和具体物料关联主键
     * @return 结果
     */
    @Override
    public int deleteArrivalsAbnormalByAbnomalids(Long[] abnomalids)
    {
        return arrivalsAbnormalMapper.deleteArrivalsAbnormalByAbnomalids(abnomalids);
    }

    /**
     * 删除到货异常信息,已单据为单位,不和具体物料关联信息
     * 
     * @param abnomalid 到货异常信息,已单据为单位,不和具体物料关联主键
     * @return 结果
     */
    @Override
    public int deleteArrivalsAbnormalByAbnomalid(Long abnomalid)
    {
        return arrivalsAbnormalMapper.deleteArrivalsAbnormalByAbnomalid(abnomalid);
    }
}

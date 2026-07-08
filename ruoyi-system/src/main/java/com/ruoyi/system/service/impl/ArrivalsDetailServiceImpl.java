package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ArrivalsDetailMapper;
import com.ruoyi.system.domain.ArrivalsDetail;
import com.ruoyi.system.service.IArrivalsDetailService;

/**
 * 到货单明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
@Service
public class ArrivalsDetailServiceImpl implements IArrivalsDetailService 
{
    @Autowired
    private ArrivalsDetailMapper arrivalsDetailMapper;

    /**
     * 查询到货单明细
     * 
     * @param arrivalsDetailid 到货单明细主键
     * @return 到货单明细
     */
    @Override
    public ArrivalsDetail selectArrivalsDetailByArrivalsDetailid(Long arrivalsDetailid)
    {
        return arrivalsDetailMapper.selectArrivalsDetailByArrivalsDetailid(arrivalsDetailid);
    }

    /**
     * 查询到货单明细列表
     * 
     * @param arrivalsDetail 到货单明细
     * @return 到货单明细
     */
    @Override
    public List<ArrivalsDetail> selectArrivalsDetailList(ArrivalsDetail arrivalsDetail)
    {
        return arrivalsDetailMapper.selectArrivalsDetailList(arrivalsDetail);
    }

    /**
     * 新增到货单明细
     * 
     * @param arrivalsDetail 到货单明细
     * @return 结果
     */
    @Override
    public int insertArrivalsDetail(ArrivalsDetail arrivalsDetail)
    {
        return arrivalsDetailMapper.insertArrivalsDetail(arrivalsDetail);
    }

    /**
     * 修改到货单明细
     * 
     * @param arrivalsDetail 到货单明细
     * @return 结果
     */
    @Override
    public int updateArrivalsDetail(ArrivalsDetail arrivalsDetail)
    {
        return arrivalsDetailMapper.updateArrivalsDetail(arrivalsDetail);
    }

    /**
     * 批量删除到货单明细
     * 
     * @param arrivalsDetailids 需要删除的到货单明细主键
     * @return 结果
     */
    @Override
    public int deleteArrivalsDetailByArrivalsDetailids(Long[] arrivalsDetailids)
    {
        return arrivalsDetailMapper.deleteArrivalsDetailByArrivalsDetailids(arrivalsDetailids);
    }

    /**
     * 删除到货单明细信息
     * 
     * @param arrivalsDetailid 到货单明细主键
     * @return 结果
     */
    @Override
    public int deleteArrivalsDetailByArrivalsDetailid(Long arrivalsDetailid)
    {
        return arrivalsDetailMapper.deleteArrivalsDetailByArrivalsDetailid(arrivalsDetailid);
    }

    /**
     * 根据到货单ID查询到货任务明细
     *
     * @param arrivalsDetail 用户主键
     * @return 到货单明细
     */
    @Override
    public List<ArrivalsDetail> selectArriveDetailList(ArrivalsDetail arrivalsDetail) {
        return arrivalsDetailMapper.selectArriveDetailList(arrivalsDetail);
    }
}

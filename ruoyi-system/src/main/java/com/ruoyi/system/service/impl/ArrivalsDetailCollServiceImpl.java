package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ArrivalsDetailCollMapper;
import com.ruoyi.system.domain.ArrivalsDetailColl;
import com.ruoyi.system.service.IArrivalsDetailCollService;

/**
 * PDA采集Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
@Service
public class ArrivalsDetailCollServiceImpl implements IArrivalsDetailCollService 
{
    @Autowired
    private ArrivalsDetailCollMapper arrivalsDetailCollMapper;

    /**
     * 查询PDA采集
     * 
     * @param arrivalsDetailid PDA采集主键
     * @return PDA采集
     */
    @Override
    public ArrivalsDetailColl selectArrivalsDetailCollByArrivalsDetailid(Long arrivalsDetailid)
    {
        return arrivalsDetailCollMapper.selectArrivalsDetailCollByArrivalsDetailid(arrivalsDetailid);
    }

    /**
     * 查询PDA采集列表
     * 
     * @param arrivalsDetailColl PDA采集
     * @return PDA采集
     */
    @Override
    public List<ArrivalsDetailColl> selectArrivalsDetailCollList(ArrivalsDetailColl arrivalsDetailColl)
    {
        return arrivalsDetailCollMapper.selectArrivalsDetailCollList(arrivalsDetailColl);
    }

    /**
     * 新增PDA采集
     * 
     * @param arrivalsDetailColl PDA采集
     * @return 结果
     */
    @Override
    public int insertArrivalsDetailColl(ArrivalsDetailColl arrivalsDetailColl)
    {
        return arrivalsDetailCollMapper.insertArrivalsDetailColl(arrivalsDetailColl);
    }

    /**
     * 修改PDA采集
     * 
     * @param arrivalsDetailColl PDA采集
     * @return 结果
     */
    @Override
    public int updateArrivalsDetailColl(ArrivalsDetailColl arrivalsDetailColl)
    {
        return arrivalsDetailCollMapper.updateArrivalsDetailColl(arrivalsDetailColl);
    }

    /**
     * 批量删除PDA采集
     * 
     * @param arrivalsDetailids 需要删除的PDA采集主键
     * @return 结果
     */
    @Override
    public int deleteArrivalsDetailCollByArrivalsDetailids(Long[] arrivalsDetailids)
    {
        return arrivalsDetailCollMapper.deleteArrivalsDetailCollByArrivalsDetailids(arrivalsDetailids);
    }

    /**
     * 删除PDA采集信息
     * 
     * @param arrivalsDetailColl PDA采集主键
     * @return 结果
     */
    @Override
    public int deleteArrivalsDetailCollByArrivalsDetailid(ArrivalsDetailColl arrivalsDetailColl)
    {
        return arrivalsDetailCollMapper.deleteArrivalsDetailCollByArrivalsDetailid(arrivalsDetailColl);
    }
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeliverytaskitemExceMapper;
import com.ruoyi.system.domain.DeliverytaskitemExce;
import com.ruoyi.system.service.IDeliverytaskitemExceService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
@Service
public class DeliverytaskitemExceServiceImpl implements IDeliverytaskitemExceService 
{
    @Autowired
    private DeliverytaskitemExceMapper deliverytaskitemExceMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param exexid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DeliverytaskitemExce selectDeliverytaskitemExceByExexid(Long exexid)
    {
        return deliverytaskitemExceMapper.selectDeliverytaskitemExceByExexid(exexid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deliverytaskitemExce 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DeliverytaskitemExce> selectDeliverytaskitemExceList(DeliverytaskitemExce deliverytaskitemExce)
    {
        return deliverytaskitemExceMapper.selectDeliverytaskitemExceList(deliverytaskitemExce);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deliverytaskitemExce 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeliverytaskitemExce(DeliverytaskitemExce deliverytaskitemExce)
    {
        return deliverytaskitemExceMapper.insertDeliverytaskitemExce(deliverytaskitemExce);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deliverytaskitemExce 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeliverytaskitemExce(DeliverytaskitemExce deliverytaskitemExce)
    {
        return deliverytaskitemExceMapper.updateDeliverytaskitemExce(deliverytaskitemExce);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param exexids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeliverytaskitemExceByExexids(Long[] exexids)
    {
        return deliverytaskitemExceMapper.deleteDeliverytaskitemExceByExexids(exexids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param exexid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeliverytaskitemExceByExexid(Long exexid)
    {
        return deliverytaskitemExceMapper.deleteDeliverytaskitemExceByExexid(exexid);
    }
}

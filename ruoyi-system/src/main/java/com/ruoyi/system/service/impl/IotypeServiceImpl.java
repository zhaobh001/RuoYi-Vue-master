package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.IotypeMapper;
import com.ruoyi.system.domain.Iotype;
import com.ruoyi.system.service.IIotypeService;

/**
 * 系统单据类型 - transaction_typeService业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-16
 */
@Service
public class IotypeServiceImpl implements IIotypeService 
{
    @Autowired
    private IotypeMapper iotypeMapper;

    /**
     * 查询系统单据类型 - transaction_type
     * 
     * @param iotypeid 系统单据类型 - transaction_type主键
     * @return 系统单据类型 - transaction_type
     */
    @Override
    public Iotype selectIotypeByIotypeid(Long iotypeid)
    {
        return iotypeMapper.selectIotypeByIotypeid(iotypeid);
    }

    /**
     * 查询系统单据类型 - transaction_type列表
     * 
     * @param iotype 系统单据类型 - transaction_type
     * @return 系统单据类型 - transaction_type
     */
    @Override
    public List<Iotype> selectIotypeList(Iotype iotype)
    {
        return iotypeMapper.selectIotypeList(iotype);
    }

    /**
     * 新增系统单据类型 - transaction_type
     * 
     * @param iotype 系统单据类型 - transaction_type
     * @return 结果
     */
    @Override
    public int insertIotype(Iotype iotype)
    {
        return iotypeMapper.insertIotype(iotype);
    }

    /**
     * 修改系统单据类型 - transaction_type
     * 
     * @param iotype 系统单据类型 - transaction_type
     * @return 结果
     */
    @Override
    public int updateIotype(Iotype iotype)
    {
        return iotypeMapper.updateIotype(iotype);
    }

    /**
     * 批量删除系统单据类型 - transaction_type
     * 
     * @param iotypeids 需要删除的系统单据类型 - transaction_type主键
     * @return 结果
     */
    @Override
    public int deleteIotypeByIotypeids(Long[] iotypeids)
    {
        return iotypeMapper.deleteIotypeByIotypeids(iotypeids);
    }

    /**
     * 删除系统单据类型 - transaction_type信息
     * 
     * @param iotypeid 系统单据类型 - transaction_type主键
     * @return 结果
     */
    @Override
    public int deleteIotypeByIotypeid(Long iotypeid)
    {
        return iotypeMapper.deleteIotypeByIotypeid(iotypeid);
    }
}

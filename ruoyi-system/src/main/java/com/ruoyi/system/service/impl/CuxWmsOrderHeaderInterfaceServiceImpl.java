package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CuxWmsOrderHeaderInterfaceMapper;
import com.ruoyi.system.domain.CuxWmsOrderHeaderInterface;
import com.ruoyi.system.service.ICuxWmsOrderHeaderInterfaceService;

/**
 * ERP单据头中间(ERP写,WMS读)Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-27
 */
@Service
public class CuxWmsOrderHeaderInterfaceServiceImpl implements ICuxWmsOrderHeaderInterfaceService
{
    @Autowired
    private CuxWmsOrderHeaderInterfaceMapper cuxWmsOrderHeaderInterfaceMapper;

    /**
     * 查询ERP单据头中间(ERP写,WMS读)
     *
     * @param orderTransactionId ERP单据头中间(ERP写,WMS读)主键
     * @return ERP单据头中间(ERP写,WMS读)
     */
    @Override
    public CuxWmsOrderHeaderInterface selectCuxWmsOrderHeaderInterfaceByOrderTransactionId(Long orderTransactionId)
    {
        return cuxWmsOrderHeaderInterfaceMapper.selectCuxWmsOrderHeaderInterfaceByOrderTransactionId(orderTransactionId);
    }

    /**
     * 查询ERP单据头中间(ERP写,WMS读)列表
     *
     * @param cuxWmsOrderHeaderInterface ERP单据头中间(ERP写,WMS读)
     * @return ERP单据头中间(ERP写,WMS读)
     */
    @Override
    public List<CuxWmsOrderHeaderInterface> selectCuxWmsOrderHeaderInterfaceList(CuxWmsOrderHeaderInterface cuxWmsOrderHeaderInterface)
    {
        return cuxWmsOrderHeaderInterfaceMapper.selectCuxWmsOrderHeaderInterfaceList(cuxWmsOrderHeaderInterface);
    }

    /**
     * 新增ERP单据头中间(ERP写,WMS读)
     *
     * @param cuxWmsOrderHeaderInterface ERP单据头中间(ERP写,WMS读)
     * @return 结果
     */
    @Override
    public int insertCuxWmsOrderHeaderInterface(CuxWmsOrderHeaderInterface cuxWmsOrderHeaderInterface)
    {
        return cuxWmsOrderHeaderInterfaceMapper.insertCuxWmsOrderHeaderInterface(cuxWmsOrderHeaderInterface);
    }

    /**
     * 修改ERP单据头中间(ERP写,WMS读)
     *
     * @param cuxWmsOrderHeaderInterface ERP单据头中间(ERP写,WMS读)
     * @return 结果
     */
    @Override
    public int updateCuxWmsOrderHeaderInterface(CuxWmsOrderHeaderInterface cuxWmsOrderHeaderInterface)
    {
        return cuxWmsOrderHeaderInterfaceMapper.updateCuxWmsOrderHeaderInterface(cuxWmsOrderHeaderInterface);
    }

    /**
     * 批量删除ERP单据头中间(ERP写,WMS读)
     *
     * @param orderTransactionIds 需要删除的ERP单据头中间(ERP写,WMS读)主键
     * @return 结果
     */
    @Override
    public int deleteCuxWmsOrderHeaderInterfaceByOrderTransactionIds(Long[] orderTransactionIds)
    {
        return cuxWmsOrderHeaderInterfaceMapper.deleteCuxWmsOrderHeaderInterfaceByOrderTransactionIds(orderTransactionIds);
    }

    /**
     * 删除ERP单据头中间(ERP写,WMS读)信息
     *
     * @param orderTransactionId ERP单据头中间(ERP写,WMS读)主键
     * @return 结果
     */
    @Override
    public int deleteCuxWmsOrderHeaderInterfaceByOrderTransactionId(Long orderTransactionId)
    {
        return cuxWmsOrderHeaderInterfaceMapper.deleteCuxWmsOrderHeaderInterfaceByOrderTransactionId(orderTransactionId);
    }

    public List<CuxWmsOrderHeaderInterface> selectCuxWmsOrderHeaderList(CuxWmsOrderHeaderInterface cuxWmsOrderHeaderInterface)  {
        return cuxWmsOrderHeaderInterfaceMapper.selectCuxWmsOrderHeaderList(cuxWmsOrderHeaderInterface);
    }

}

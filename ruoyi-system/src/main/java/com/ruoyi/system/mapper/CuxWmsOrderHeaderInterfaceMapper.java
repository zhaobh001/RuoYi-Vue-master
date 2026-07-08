package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CuxWmsOrderHeaderInterface;

/**
 * ERP单据头中间(ERP写,WMS读)Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-27
 */
public interface CuxWmsOrderHeaderInterfaceMapper
{
    /**
     * 查询ERP单据头中间(ERP写,WMS读)
     *
     * @param orderTransactionId ERP单据头中间(ERP写,WMS读)主键
     * @return ERP单据头中间(ERP写,WMS读)
     */
    public CuxWmsOrderHeaderInterface selectCuxWmsOrderHeaderInterfaceByOrderTransactionId(Long orderTransactionId);

    /**
     * 查询ERP单据头中间(ERP写,WMS读)列表
     *
     * @param cuxWmsOrderHeaderInterface ERP单据头中间(ERP写,WMS读)
     * @return ERP单据头中间(ERP写,WMS读)集合
     */
    public List<CuxWmsOrderHeaderInterface> selectCuxWmsOrderHeaderInterfaceList(CuxWmsOrderHeaderInterface cuxWmsOrderHeaderInterface);

    /**
     * 新增ERP单据头中间(ERP写,WMS读)
     *
     * @param cuxWmsOrderHeaderInterface ERP单据头中间(ERP写,WMS读)
     * @return 结果
     */
    public int insertCuxWmsOrderHeaderInterface(CuxWmsOrderHeaderInterface cuxWmsOrderHeaderInterface);

    /**
     * 修改ERP单据头中间(ERP写,WMS读)
     *
     * @param cuxWmsOrderHeaderInterface ERP单据头中间(ERP写,WMS读)
     * @return 结果
     */
    public int updateCuxWmsOrderHeaderInterface(CuxWmsOrderHeaderInterface cuxWmsOrderHeaderInterface);

    /**
     * 删除ERP单据头中间(ERP写,WMS读)
     *
     * @param orderTransactionId ERP单据头中间(ERP写,WMS读)主键
     * @return 结果
     */
    public int deleteCuxWmsOrderHeaderInterfaceByOrderTransactionId(Long orderTransactionId);

    /**
     * 批量删除ERP单据头中间(ERP写,WMS读)
     *
     * @param orderTransactionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCuxWmsOrderHeaderInterfaceByOrderTransactionIds(Long[] orderTransactionIds);


    public List<CuxWmsOrderHeaderInterface> selectCuxWmsOrderHeaderList(CuxWmsOrderHeaderInterface cuxWmsOrderHeaderInterface);

}

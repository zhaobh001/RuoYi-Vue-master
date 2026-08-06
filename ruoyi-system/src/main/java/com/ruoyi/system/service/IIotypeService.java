package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Iotype;

/**
 * 系统单据类型 - transaction_typeService接口
 * 
 * @author ruoyi
 * @date 2026-04-16
 */
public interface IIotypeService 
{
    /**
     * 查询系统单据类型 - transaction_type
     * 
     * @param iotypeid 系统单据类型 - transaction_type主键
     * @return 系统单据类型 - transaction_type
     */
    public Iotype selectIotypeByIotypeid(Long iotypeid);

    /**
     * 查询系统单据类型 - transaction_type列表
     * 
     * @param iotype 系统单据类型 - transaction_type
     * @return 系统单据类型 - transaction_type集合
     */
    public List<Iotype> selectIotypeList(Iotype iotype);

    /**
     * 新增系统单据类型 - transaction_type
     * 
     * @param iotype 系统单据类型 - transaction_type
     * @return 结果
     */
    public int insertIotype(Iotype iotype);

    /**
     * 修改系统单据类型 - transaction_type
     * 
     * @param iotype 系统单据类型 - transaction_type
     * @return 结果
     */
    public int updateIotype(Iotype iotype);

    /**
     * 批量删除系统单据类型 - transaction_type
     * 
     * @param iotypeids 需要删除的系统单据类型 - transaction_type主键集合
     * @return 结果
     */
    public int deleteIotypeByIotypeids(Long[] iotypeids);

    /**
     * 删除系统单据类型 - transaction_type信息
     * 
     * @param iotypeid 系统单据类型 - transaction_type主键
     * @return 结果
     */
    public int deleteIotypeByIotypeid(Long iotypeid);
}

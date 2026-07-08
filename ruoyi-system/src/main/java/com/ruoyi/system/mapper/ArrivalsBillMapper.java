package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ArrivalsBill;

/**
 * 到货单Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public interface ArrivalsBillMapper 
{
    /**
     * 查询到货单
     * 
     * @param arrivalsBillid 到货单主键
     * @return 到货单
     */
    public ArrivalsBill selectArrivalsBillByArrivalsBillid(Long arrivalsBillid);

    /**
     * 查询到货单列表
     * 
     * @param arrivalsBill 到货单
     * @return 到货单集合
     */
    public List<ArrivalsBill> selectArrivalsBillList(ArrivalsBill arrivalsBill);

    /**
     * 新增到货单
     * 
     * @param arrivalsBill 到货单
     * @return 结果
     */
    public int insertArrivalsBill(ArrivalsBill arrivalsBill);

    /**
     * 修改到货单
     * 
     * @param arrivalsBill 到货单
     * @return 结果
     */
    public int updateArrivalsBill(ArrivalsBill arrivalsBill);

    /**
     * 删除到货单
     * 
     * @param arrivalsBillid 到货单主键
     * @return 结果
     */
    public int deleteArrivalsBillByArrivalsBillid(Long arrivalsBillid);

    /**
     * 批量删除到货单
     * 
     * @param arrivalsBillids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArrivalsBillByArrivalsBillids(Long[] arrivalsBillids);

    /**
     * 根据用户ID查询已接收到货任务
     *
     * @param arrivalsBill 用户主键
     * @return 到货单
     */
    public List<ArrivalsBill> selectArriveSignList(ArrivalsBill arrivalsBill);

    /**
     * 根据用户ID查询已接收到货任务
     *
     * @param arrivalsBill 用户主键
     * @return 到货单
     */
    public List<ArrivalsBill> selectArriveSignUnReceList(ArrivalsBill arrivalsBill);
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ArrivalsBillMapper;
import com.ruoyi.system.domain.ArrivalsBill;
import com.ruoyi.system.service.IArrivalsBillService;

/**
 * 到货单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
@Service
public class ArrivalsBillServiceImpl implements IArrivalsBillService 
{
    @Autowired
    private ArrivalsBillMapper arrivalsBillMapper;

    /**
     * 查询到货单
     * 
     * @param arrivalsBillid 到货单主键
     * @return 到货单
     */
    @Override
    public ArrivalsBill selectArrivalsBillByArrivalsBillid(Long arrivalsBillid)
    {
        return arrivalsBillMapper.selectArrivalsBillByArrivalsBillid(arrivalsBillid);
    }

    /**
     * 查询到货单列表
     * 
     * @param arrivalsBill 到货单
     * @return 到货单
     */
    @Override
    public List<ArrivalsBill> selectArrivalsBillList(ArrivalsBill arrivalsBill)
    {
        return arrivalsBillMapper.selectArrivalsBillList(arrivalsBill);
    }

    /**
     * 新增到货单
     * 
     * @param arrivalsBill 到货单
     * @return 结果
     */
    @Override
    public int insertArrivalsBill(ArrivalsBill arrivalsBill)
    {
        return arrivalsBillMapper.insertArrivalsBill(arrivalsBill);
    }

    /**
     * 修改到货单
     * 
     * @param arrivalsBill 到货单
     * @return 结果
     */
    @Override
    public int updateArrivalsBill(ArrivalsBill arrivalsBill)
    {
        return arrivalsBillMapper.updateArrivalsBill(arrivalsBill);
    }

    /**
     * 批量删除到货单
     * 
     * @param arrivalsBillids 需要删除的到货单主键
     * @return 结果
     */
    @Override
    public int deleteArrivalsBillByArrivalsBillids(Long[] arrivalsBillids)
    {
        return arrivalsBillMapper.deleteArrivalsBillByArrivalsBillids(arrivalsBillids);
    }

    /**
     * 删除到货单信息
     * 
     * @param arrivalsBillid 到货单主键
     * @return 结果
     */
    @Override
    public int deleteArrivalsBillByArrivalsBillid(Long arrivalsBillid)
    {
        return arrivalsBillMapper.deleteArrivalsBillByArrivalsBillid(arrivalsBillid);
    }

    /**
     * 根据用户ID查询已接收到货任务
     *
     * @param arrivalsBill 用户主键
     * @return 结果
     */
    @Override
    public List<ArrivalsBill> selectArriveSignList(ArrivalsBill arrivalsBill)
    {
        return arrivalsBillMapper.selectArriveSignList(arrivalsBill);
    }

    /**
     * 根据用户ID查询已接收到货任务
     *
     * @param arrivalsBill 用户主键
     * @return 到货单
     */
    public List<ArrivalsBill> selectArriveSignUnReceList(ArrivalsBill arrivalsBill){
        return arrivalsBillMapper.selectArriveSignUnReceList(arrivalsBill);
    }
}

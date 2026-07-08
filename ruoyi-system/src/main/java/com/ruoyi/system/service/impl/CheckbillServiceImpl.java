package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CheckbillMapper;
import com.ruoyi.system.domain.Checkbill;
import com.ruoyi.system.service.ICheckbillService;

/**
 * 盘点单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-26
 */
@Service
public class CheckbillServiceImpl implements ICheckbillService 
{
    @Autowired
    private CheckbillMapper checkbillMapper;

    /**
     * 查询盘点单
     * 
     * @param checkbillid 盘点单主键
     * @return 盘点单
     */
    @Override
    public Checkbill selectCheckbillByCheckbillid(Long checkbillid)
    {
        return checkbillMapper.selectCheckbillByCheckbillid(checkbillid);
    }

    /**
     * 查询盘点单列表
     * 
     * @param checkbill 盘点单
     * @return 盘点单
     */
    @Override
    public List<Checkbill> selectCheckbillList(Checkbill checkbill)
    {
        return checkbillMapper.selectCheckbillList(checkbill);
    }

    /**
     * 新增盘点单
     * 
     * @param checkbill 盘点单
     * @return 结果
     */
    @Override
    public int insertCheckbill(Checkbill checkbill)
    {
        return checkbillMapper.insertCheckbill(checkbill);
    }

    /**
     * 修改盘点单
     * 
     * @param checkbill 盘点单
     * @return 结果
     */
    @Override
    public int updateCheckbill(Checkbill checkbill)
    {
        return checkbillMapper.updateCheckbill(checkbill);
    }

    /**
     * 批量删除盘点单
     * 
     * @param checkbillids 需要删除的盘点单主键
     * @return 结果
     */
    @Override
    public int deleteCheckbillByCheckbillids(Long[] checkbillids)
    {
        return checkbillMapper.deleteCheckbillByCheckbillids(checkbillids);
    }

    /**
     * 删除盘点单信息
     * 
     * @param checkbillid 盘点单主键
     * @return 结果
     */
    @Override
    public int deleteCheckbillByCheckbillid(Long checkbillid)
    {
        return checkbillMapper.deleteCheckbillByCheckbillid(checkbillid);
    }
}

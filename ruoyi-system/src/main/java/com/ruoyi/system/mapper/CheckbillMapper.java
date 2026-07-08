package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Checkbill;

/**
 * 盘点单Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-26
 */
public interface CheckbillMapper 
{
    /**
     * 查询盘点单
     * 
     * @param checkbillid 盘点单主键
     * @return 盘点单
     */
    public Checkbill selectCheckbillByCheckbillid(Long checkbillid);

    /**
     * 查询盘点单列表
     * 
     * @param checkbill 盘点单
     * @return 盘点单集合
     */
    public List<Checkbill> selectCheckbillList(Checkbill checkbill);

    /**
     * 新增盘点单
     * 
     * @param checkbill 盘点单
     * @return 结果
     */
    public int insertCheckbill(Checkbill checkbill);

    /**
     * 修改盘点单
     * 
     * @param checkbill 盘点单
     * @return 结果
     */
    public int updateCheckbill(Checkbill checkbill);

    /**
     * 删除盘点单
     * 
     * @param checkbillid 盘点单主键
     * @return 结果
     */
    public int deleteCheckbillByCheckbillid(Long checkbillid);

    /**
     * 批量删除盘点单
     * 
     * @param checkbillids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCheckbillByCheckbillids(Long[] checkbillids);
}

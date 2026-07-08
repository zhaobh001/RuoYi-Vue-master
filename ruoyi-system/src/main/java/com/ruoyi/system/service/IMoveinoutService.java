package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Moveinout;

/**
 * 移库移入移出Service接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface IMoveinoutService 
{
    /**
     * 查询移库移入移出
     * 
     * @param moveinoutid 移库移入移出主键
     * @return 移库移入移出
     */
    public Moveinout selectMoveinoutByMoveinoutid(Long moveinoutid);

    /**
     * 查询移库移入移出列表
     * 
     * @param moveinout 移库移入移出
     * @return 移库移入移出集合
     */
    public List<Moveinout> selectMoveinoutList(Moveinout moveinout);

    /**
     * 新增移库移入移出
     * 
     * @param moveinout 移库移入移出
     * @return 结果
     */
    public int insertMoveinout(Moveinout moveinout);

    /**
     * 修改移库移入移出
     * 
     * @param moveinout 移库移入移出
     * @return 结果
     */
    public int updateMoveinout(Moveinout moveinout);

    /**
     * 批量删除移库移入移出
     * 
     * @param moveinoutids 需要删除的移库移入移出主键集合
     * @return 结果
     */
    public int deleteMoveinoutByMoveinoutids(Long[] moveinoutids);

    /**
     * 删除移库移入移出信息
     * 
     * @param moveinoutid 移库移入移出主键
     * @return 结果
     */
    public int deleteMoveinoutByMoveinoutid(Long moveinoutid);
}

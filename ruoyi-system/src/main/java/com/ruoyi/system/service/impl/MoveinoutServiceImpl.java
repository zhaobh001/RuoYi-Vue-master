package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MoveinoutMapper;
import com.ruoyi.system.domain.Moveinout;
import com.ruoyi.system.service.IMoveinoutService;

/**
 * 移库移入移出Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class MoveinoutServiceImpl implements IMoveinoutService 
{
    @Autowired
    private MoveinoutMapper moveinoutMapper;

    /**
     * 查询移库移入移出
     * 
     * @param moveinoutid 移库移入移出主键
     * @return 移库移入移出
     */
    @Override
    public Moveinout selectMoveinoutByMoveinoutid(Long moveinoutid)
    {
        return moveinoutMapper.selectMoveinoutByMoveinoutid(moveinoutid);
    }

    /**
     * 查询移库移入移出列表
     * 
     * @param moveinout 移库移入移出
     * @return 移库移入移出
     */
    @Override
    public List<Moveinout> selectMoveinoutList(Moveinout moveinout)
    {
        return moveinoutMapper.selectMoveinoutList(moveinout);
    }

    /**
     * 新增移库移入移出
     * 
     * @param moveinout 移库移入移出
     * @return 结果
     */
    @Override
    public int insertMoveinout(Moveinout moveinout)
    {
        return moveinoutMapper.insertMoveinout(moveinout);
    }

    /**
     * 修改移库移入移出
     * 
     * @param moveinout 移库移入移出
     * @return 结果
     */
    @Override
    public int updateMoveinout(Moveinout moveinout)
    {
        return moveinoutMapper.updateMoveinout(moveinout);
    }

    /**
     * 批量删除移库移入移出
     * 
     * @param moveinoutids 需要删除的移库移入移出主键
     * @return 结果
     */
    @Override
    public int deleteMoveinoutByMoveinoutids(Long[] moveinoutids)
    {
        return moveinoutMapper.deleteMoveinoutByMoveinoutids(moveinoutids);
    }

    /**
     * 删除移库移入移出信息
     * 
     * @param moveinoutid 移库移入移出主键
     * @return 结果
     */
    @Override
    public int deleteMoveinoutByMoveinoutid(Long moveinoutid)
    {
        return moveinoutMapper.deleteMoveinoutByMoveinoutid(moveinoutid);
    }
}

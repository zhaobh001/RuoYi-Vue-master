package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MoveoutMapper;
import com.ruoyi.system.domain.Moveout;
import com.ruoyi.system.service.IMoveoutService;

/**
 * 移库移出Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class MoveoutServiceImpl implements IMoveoutService 
{
    @Autowired
    private MoveoutMapper moveoutMapper;

    /**
     * 查询移库移出
     * 
     * @param moveoutid 移库移出主键
     * @return 移库移出
     */
    @Override
    public Moveout selectMoveoutByMoveoutid(Long moveoutid)
    {
        return moveoutMapper.selectMoveoutByMoveoutid(moveoutid);
    }

    /**
     * 查询移库移出列表
     * 
     * @param moveout 移库移出
     * @return 移库移出
     */
    @Override
    public List<Moveout> selectMoveoutList(Moveout moveout)
    {
        return moveoutMapper.selectMoveoutList(moveout);
    }

    /**
     * 新增移库移出
     * 
     * @param moveout 移库移出
     * @return 结果
     */
    @Override
    public int insertMoveout(Moveout moveout)
    {
        return moveoutMapper.insertMoveout(moveout);
    }

    /**
     * 修改移库移出
     * 
     * @param moveout 移库移出
     * @return 结果
     */
    @Override
    public int updateMoveout(Moveout moveout)
    {
        return moveoutMapper.updateMoveout(moveout);
    }

    /**
     * 批量删除移库移出
     * 
     * @param moveoutids 需要删除的移库移出主键
     * @return 结果
     */
    @Override
    public int deleteMoveoutByMoveoutids(Long[] moveoutids)
    {
        return moveoutMapper.deleteMoveoutByMoveoutids(moveoutids);
    }

    /**
     * 删除移库移出信息
     * 
     * @param moveoutid 移库移出主键
     * @return 结果
     */
    @Override
    public int deleteMoveoutByMoveoutid(Long moveoutid)
    {
        return moveoutMapper.deleteMoveoutByMoveoutid(moveoutid);
    }
}

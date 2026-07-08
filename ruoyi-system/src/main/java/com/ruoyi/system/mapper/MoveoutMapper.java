package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Moveout;

/**
 * 移库移出Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface MoveoutMapper 
{
    /**
     * 查询移库移出
     * 
     * @param moveoutid 移库移出主键
     * @return 移库移出
     */
    public Moveout selectMoveoutByMoveoutid(Long moveoutid);

    /**
     * 查询移库移出列表
     * 
     * @param moveout 移库移出
     * @return 移库移出集合
     */
    public List<Moveout> selectMoveoutList(Moveout moveout);

    /**
     * 新增移库移出
     * 
     * @param moveout 移库移出
     * @return 结果
     */
    public int insertMoveout(Moveout moveout);

    /**
     * 修改移库移出
     * 
     * @param moveout 移库移出
     * @return 结果
     */
    public int updateMoveout(Moveout moveout);

    /**
     * 删除移库移出
     * 
     * @param moveoutid 移库移出主键
     * @return 结果
     */
    public int deleteMoveoutByMoveoutid(Long moveoutid);

    /**
     * 批量删除移库移出
     * 
     * @param moveoutids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMoveoutByMoveoutids(Long[] moveoutids);
}

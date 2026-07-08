package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BbQueue;

/**
 * 单号日期序列Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
public interface BbQueueMapper 
{
    /**
     * 查询单号日期序列
     * 
     * @param bbQueueid 单号日期序列主键
     * @return 单号日期序列
     */
    public BbQueue selectBbQueueByBbQueueid(Long bbQueueid);

    /**
     * 查询单号日期序列列表
     * 
     * @param bbQueue 单号日期序列
     * @return 单号日期序列集合
     */
    public List<BbQueue> selectBbQueueList(BbQueue bbQueue);

    /**
     * 新增单号日期序列
     * 
     * @param bbQueue 单号日期序列
     * @return 结果
     */
    public int insertBbQueue(BbQueue bbQueue);

    /**
     * 修改单号日期序列
     * 
     * @param bbQueue 单号日期序列
     * @return 结果
     */
    public int updateBbQueue(BbQueue bbQueue);

    /**
     * 删除单号日期序列
     * 
     * @param bbQueueid 单号日期序列主键
     * @return 结果
     */
    public int deleteBbQueueByBbQueueid(Long bbQueueid);

    /**
     * 批量删除单号日期序列
     * 
     * @param bbQueueids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBbQueueByBbQueueids(Long[] bbQueueids);
}

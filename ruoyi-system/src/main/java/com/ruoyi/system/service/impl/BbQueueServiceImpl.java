package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BbQueueMapper;
import com.ruoyi.system.domain.BbQueue;
import com.ruoyi.system.service.IBbQueueService;

/**
 * 单号日期序列Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
@Service
public class BbQueueServiceImpl implements IBbQueueService 
{
    @Autowired
    private BbQueueMapper bbQueueMapper;

    /**
     * 查询单号日期序列
     * 
     * @param bbQueueid 单号日期序列主键
     * @return 单号日期序列
     */
    @Override
    public BbQueue selectBbQueueByBbQueueid(Long bbQueueid)
    {
        return bbQueueMapper.selectBbQueueByBbQueueid(bbQueueid);
    }

    /**
     * 查询单号日期序列列表
     * 
     * @param bbQueue 单号日期序列
     * @return 单号日期序列
     */
    @Override
    public List<BbQueue> selectBbQueueList(BbQueue bbQueue)
    {
        return bbQueueMapper.selectBbQueueList(bbQueue);
    }

    /**
     * 新增单号日期序列
     * 
     * @param bbQueue 单号日期序列
     * @return 结果
     */
    @Override
    public int insertBbQueue(BbQueue bbQueue)
    {
        return bbQueueMapper.insertBbQueue(bbQueue);
    }

    /**
     * 修改单号日期序列
     * 
     * @param bbQueue 单号日期序列
     * @return 结果
     */
    @Override
    public int updateBbQueue(BbQueue bbQueue)
    {
        return bbQueueMapper.updateBbQueue(bbQueue);
    }

    /**
     * 批量删除单号日期序列
     * 
     * @param bbQueueids 需要删除的单号日期序列主键
     * @return 结果
     */
    @Override
    public int deleteBbQueueByBbQueueids(Long[] bbQueueids)
    {
        return bbQueueMapper.deleteBbQueueByBbQueueids(bbQueueids);
    }

    /**
     * 删除单号日期序列信息
     * 
     * @param bbQueueid 单号日期序列主键
     * @return 结果
     */
    @Override
    public int deleteBbQueueByBbQueueid(Long bbQueueid)
    {
        return bbQueueMapper.deleteBbQueueByBbQueueid(bbQueueid);
    }
}

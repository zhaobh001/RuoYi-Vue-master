package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InorderMapper;
import com.ruoyi.system.domain.Inorder;
import com.ruoyi.system.service.IInorderService;

/**
 * 入库指令(创建任务intask 和 记账时都有写这个)Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
@Service
public class InorderServiceImpl implements IInorderService 
{
    @Autowired
    private InorderMapper inorderMapper;

    /**
     * 查询入库指令(创建任务intask 和 记账时都有写这个)
     * 
     * @param inorderid 入库指令(创建任务intask 和 记账时都有写这个)主键
     * @return 入库指令(创建任务intask 和 记账时都有写这个)
     */
    @Override
    public Inorder selectInorderByInorderid(Long inorderid)
    {
        return inorderMapper.selectInorderByInorderid(inorderid);
    }

    /**
     * 查询入库指令(创建任务intask 和 记账时都有写这个)列表
     * 
     * @param inorder 入库指令(创建任务intask 和 记账时都有写这个)
     * @return 入库指令(创建任务intask 和 记账时都有写这个)
     */
    @Override
    public List<Inorder> selectInorderList(Inorder inorder)
    {
        return inorderMapper.selectInorderList(inorder);
    }

    /**
     * 新增入库指令(创建任务intask 和 记账时都有写这个)
     * 
     * @param inorder 入库指令(创建任务intask 和 记账时都有写这个)
     * @return 结果
     */
    @Override
    public int insertInorder(Inorder inorder)
    {
        return inorderMapper.insertInorder(inorder);
    }

    /**
     * 修改入库指令(创建任务intask 和 记账时都有写这个)
     * 
     * @param inorder 入库指令(创建任务intask 和 记账时都有写这个)
     * @return 结果
     */
    @Override
    public int updateInorder(Inorder inorder)
    {
        return inorderMapper.updateInorder(inorder);
    }

    /**
     * 批量删除入库指令(创建任务intask 和 记账时都有写这个)
     * 
     * @param inorderids 需要删除的入库指令(创建任务intask 和 记账时都有写这个)主键
     * @return 结果
     */
    @Override
    public int deleteInorderByInorderids(Long[] inorderids)
    {
        return inorderMapper.deleteInorderByInorderids(inorderids);
    }

    /**
     * 删除入库指令(创建任务intask 和 记账时都有写这个)信息
     * 
     * @param inorderid 入库指令(创建任务intask 和 记账时都有写这个)主键
     * @return 结果
     */
    @Override
    public int deleteInorderByInorderid(Long inorderid)
    {
        return inorderMapper.deleteInorderByInorderid(inorderid);
    }
}

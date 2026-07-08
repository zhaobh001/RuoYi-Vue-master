package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Inorder;

/**
 * 入库指令(创建任务intask 和 记账时都有写这个)Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public interface InorderMapper 
{
    /**
     * 查询入库指令(创建任务intask 和 记账时都有写这个)
     * 
     * @param inorderid 入库指令(创建任务intask 和 记账时都有写这个)主键
     * @return 入库指令(创建任务intask 和 记账时都有写这个)
     */
    public Inorder selectInorderByInorderid(Long inorderid);

    /**
     * 查询入库指令(创建任务intask 和 记账时都有写这个)列表
     * 
     * @param inorder 入库指令(创建任务intask 和 记账时都有写这个)
     * @return 入库指令(创建任务intask 和 记账时都有写这个)集合
     */
    public List<Inorder> selectInorderList(Inorder inorder);

    /**
     * 新增入库指令(创建任务intask 和 记账时都有写这个)
     * 
     * @param inorder 入库指令(创建任务intask 和 记账时都有写这个)
     * @return 结果
     */
    public int insertInorder(Inorder inorder);

    /**
     * 修改入库指令(创建任务intask 和 记账时都有写这个)
     * 
     * @param inorder 入库指令(创建任务intask 和 记账时都有写这个)
     * @return 结果
     */
    public int updateInorder(Inorder inorder);

    /**
     * 删除入库指令(创建任务intask 和 记账时都有写这个)
     * 
     * @param inorderid 入库指令(创建任务intask 和 记账时都有写这个)主键
     * @return 结果
     */
    public int deleteInorderByInorderid(Long inorderid);

    /**
     * 批量删除入库指令(创建任务intask 和 记账时都有写这个)
     * 
     * @param inorderids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInorderByInorderids(Long[] inorderids);
}

package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Inproof;

/**
 * 入库凭证主Service接口
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public interface IInproofService 
{
    /**
     * 查询入库凭证主
     * 
     * @param inproofid 入库凭证主主键
     * @return 入库凭证主
     */
    public Inproof selectInproofByInproofid(Long inproofid);

    /**
     * 查询入库凭证主列表
     * 
     * @param inproof 入库凭证主
     * @return 入库凭证主集合
     */
    public List<Inproof> selectInproofList(Inproof inproof);

    /**
     * 新增入库凭证主
     * 
     * @param inproof 入库凭证主
     * @return 结果
     */
    public int insertInproof(Inproof inproof);

    /**
     * 修改入库凭证主
     * 
     * @param inproof 入库凭证主
     * @return 结果
     */
    public int updateInproof(Inproof inproof);

    /**
     * 批量删除入库凭证主
     * 
     * @param inproofids 需要删除的入库凭证主主键集合
     * @return 结果
     */
    public int deleteInproofByInproofids(Long[] inproofids);

    /**
     * 删除入库凭证主信息
     * 
     * @param inproofid 入库凭证主主键
     * @return 结果
     */
    public int deleteInproofByInproofid(Long inproofid);
}

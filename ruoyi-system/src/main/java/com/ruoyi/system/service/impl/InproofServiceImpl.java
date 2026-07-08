package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InproofMapper;
import com.ruoyi.system.domain.Inproof;
import com.ruoyi.system.service.IInproofService;

/**
 * 入库凭证主Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
@Service
public class InproofServiceImpl implements IInproofService 
{
    @Autowired
    private InproofMapper inproofMapper;

    /**
     * 查询入库凭证主
     * 
     * @param inproofid 入库凭证主主键
     * @return 入库凭证主
     */
    @Override
    public Inproof selectInproofByInproofid(Long inproofid)
    {
        return inproofMapper.selectInproofByInproofid(inproofid);
    }

    /**
     * 查询入库凭证主列表
     * 
     * @param inproof 入库凭证主
     * @return 入库凭证主
     */
    @Override
    public List<Inproof> selectInproofList(Inproof inproof)
    {
        return inproofMapper.selectInproofList(inproof);
    }

    /**
     * 新增入库凭证主
     * 
     * @param inproof 入库凭证主
     * @return 结果
     */
    @Override
    public int insertInproof(Inproof inproof)
    {
        return inproofMapper.insertInproof(inproof);
    }

    /**
     * 修改入库凭证主
     * 
     * @param inproof 入库凭证主
     * @return 结果
     */
    @Override
    public int updateInproof(Inproof inproof)
    {
        return inproofMapper.updateInproof(inproof);
    }

    /**
     * 批量删除入库凭证主
     * 
     * @param inproofids 需要删除的入库凭证主主键
     * @return 结果
     */
    @Override
    public int deleteInproofByInproofids(Long[] inproofids)
    {
        return inproofMapper.deleteInproofByInproofids(inproofids);
    }

    /**
     * 删除入库凭证主信息
     * 
     * @param inproofid 入库凭证主主键
     * @return 结果
     */
    @Override
    public int deleteInproofByInproofid(Long inproofid)
    {
        return inproofMapper.deleteInproofByInproofid(inproofid);
    }
}

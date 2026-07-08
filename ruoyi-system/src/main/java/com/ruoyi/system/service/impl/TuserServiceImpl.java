package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.system.domain.Storeroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TuserMapper;
import com.ruoyi.system.domain.Tuser;
import com.ruoyi.system.service.ITuserService;

/**
 * 用户登录帐号Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-02
 */
@Service
public class TuserServiceImpl implements ITuserService 
{
    @Autowired
    private TuserMapper tuserMapper;

    /**
     * 查询用户登录帐号
     * 
     * @param tuserid 用户登录帐号主键
     * @return 用户登录帐号
     */
    @Override
    public Tuser selectTuserByTuserid(Long tuserid)
    {
        return tuserMapper.selectTuserByTuserid(tuserid);
    }

    /**
     * 查询用户登录帐号列表
     * 
     * @param tuser 用户登录帐号
     * @return 用户登录帐号
     */
    @Override
    public List<Tuser> selectTuserList(Tuser tuser)
    {
        return tuserMapper.selectTuserList(tuser);
    }

    /**
     * 新增用户登录帐号
     * 
     * @param tuser 用户登录帐号
     * @return 结果
     */
    @Override
    public int insertTuser(Tuser tuser)
    {
        return tuserMapper.insertTuser(tuser);
    }

    /**
     * 修改用户登录帐号
     * 
     * @param tuser 用户登录帐号
     * @return 结果
     */
    @Override
    public int updateTuser(Tuser tuser)
    {
        return tuserMapper.updateTuser(tuser);
    }

    /**
     * 批量删除用户登录帐号
     * 
     * @param tuserids 需要删除的用户登录帐号主键
     * @return 结果
     */
    @Override
    public int deleteTuserByTuserids(Long[] tuserids)
    {
        return tuserMapper.deleteTuserByTuserids(tuserids);
    }

    /**
     * 删除用户登录帐号信息
     * 
     * @param tuserid 用户登录帐号主键
     * @return 结果
     */
    @Override
    public int deleteTuserByTuserid(Long tuserid)
    {
        return tuserMapper.deleteTuserByTuserid(tuserid);
    }

    /**
     * 根据条件分页查询未分配库房角色列表
     *
     * @param tuser 用户
     * @return 用户列表
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<Tuser> selectUnallocatedList(Tuser tuser)
    {
        return tuserMapper.selectUnallocatedList(tuser);
    }
}

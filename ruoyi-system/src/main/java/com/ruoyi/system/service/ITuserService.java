package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.Storeroom;
import com.ruoyi.system.domain.Tuser;

/**
 * 用户登录帐号Service接口
 * 
 * @author ruoyi
 * @date 2023-07-02
 */
public interface ITuserService 
{
    /**
     * 查询用户登录帐号
     * 
     * @param tuserid 用户登录帐号主键
     * @return 用户登录帐号
     */
    public Tuser selectTuserByTuserid(Long tuserid);

    /**
     * 查询用户登录帐号列表
     * 
     * @param tuser 用户登录帐号
     * @return 用户登录帐号集合
     */
    public List<Tuser> selectTuserList(Tuser tuser);

    /**
     * 新增用户登录帐号
     * 
     * @param tuser 用户登录帐号
     * @return 结果
     */
    public int insertTuser(Tuser tuser);

    /**
     * 修改用户登录帐号
     * 
     * @param tuser 用户登录帐号
     * @return 结果
     */
    public int updateTuser(Tuser tuser);

    /**
     * 批量删除用户登录帐号
     * 
     * @param tuserids 需要删除的用户登录帐号主键集合
     * @return 结果
     */
    public int deleteTuserByTuserids(Long[] tuserids);

    /**
     * 删除用户登录帐号信息
     * 
     * @param tuserid 用户登录帐号主键
     * @return 结果
     */
    public int deleteTuserByTuserid(Long tuserid);

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param tuser 库房
     * @return 库房集合
     */
    public List<Tuser> selectUnallocatedList(Tuser tuser);
}

package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Tuser;

/**
 * 用户登录帐号Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-02
 */
public interface TuserMapper 
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
     * 删除用户登录帐号
     * 
     * @param tuserid 用户登录帐号主键
     * @return 结果
     */
    public int deleteTuserByTuserid(Long tuserid);

    /**
     * 批量删除用户登录帐号
     * 
     * @param tuserids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTuserByTuserids(Long[] tuserids);

    /**
     * 获取未同步用户记录
     *
     * @param tuser 需要删除的数据主键集合
     * @return 结果
     */
    public List<Tuser> selectUnallocatedList(Tuser tuser);
}

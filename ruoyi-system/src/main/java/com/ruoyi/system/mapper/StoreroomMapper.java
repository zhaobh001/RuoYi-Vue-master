package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Storeroom;

/**
 * 库房Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-01
 */
public interface StoreroomMapper 
{
    /**
     * 查询库房
     * 
     * @param storeroomid 库房主键
     * @return 库房
     */
    public Storeroom selectStoreroomByStoreroomid(Long storeroomid);

    /**
     * 查询库房列表
     * 
     * @param storeroom 库房
     * @return 库房集合
     */
    public List<Storeroom> selectStoreroomList(Storeroom storeroom);

    /**
     * 新增库房
     * 
     * @param storeroom 库房
     * @return 结果
     */
    public int insertStoreroom(Storeroom storeroom);

    /**
     * 修改库房
     * 
     * @param storeroom 库房
     * @return 结果
     */
    public int updateStoreroom(Storeroom storeroom);

    /**
     * 删除库房
     * 
     * @param storeroomid 库房主键
     * @return 结果
     */
    public int deleteStoreroomByStoreroomid(Long storeroomid);

    /**
     * 批量删除库房
     * 
     * @param storeroomids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStoreroomByStoreroomids(Long[] storeroomids);

    /**
     * 根据条件分页查询已配用户角色列表
     *
     * @param storeroom 库房
     * @return 库房集合
     */
    public List<Storeroom> selectAllocatedList(Storeroom storeroom);

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param storeroom 库房
     * @return 库房集合
     */
    public List<Storeroom> selectUnallocatedList(Storeroom storeroom);

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param storeroom 库房
     * @return 库房集合
     */
    public List<Storeroom> selectStoreSiteByRoom(Storeroom storeroom);

}

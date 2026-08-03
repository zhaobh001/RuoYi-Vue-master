package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StoreroomMapper;
import com.ruoyi.system.domain.Storeroom;
import com.ruoyi.system.service.IStoreroomService;

/**
 * 库房Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-01
 */
@Service
public class StoreroomServiceImpl implements IStoreroomService 
{
    @Autowired
    private StoreroomMapper storeroomMapper;

    /**
     * 查询库房
     * 
     * @param storeroomid 库房主键
     * @return 库房
     */
    @Override
    public Storeroom selectStoreroomByStoreroomid(Long storeroomid)
    {
        return storeroomMapper.selectStoreroomByStoreroomid(storeroomid);
    }

    /**
     * 查询库房列表
     * 
     * @param storeroom 库房
     * @return 库房
     */
    @Override
    public List<Storeroom> selectStoreroomList(Storeroom storeroom)
    {
        return storeroomMapper.selectStoreroomList(storeroom);
    }

    /**
     * 新增库房
     * 
     * @param storeroom 库房
     * @return 结果
     */
    @Override
    public int insertStoreroom(Storeroom storeroom)
    {
        return storeroomMapper.insertStoreroom(storeroom);
    }

    /**
     * 修改库房
     * 
     * @param storeroom 库房
     * @return 结果
     */
    @Override
    public int updateStoreroom(Storeroom storeroom)
    {
        return storeroomMapper.updateStoreroom(storeroom);
    }

    /**
     * 批量删除库房
     * 
     * @param storeroomids 需要删除的库房主键
     * @return 结果
     */
    @Override
    public int deleteStoreroomByStoreroomids(Long[] storeroomids)
    {
        return storeroomMapper.deleteStoreroomByStoreroomids(storeroomids);
    }

    /**
     * 删除库房信息
     * 
     * @param storeroomid 库房主键
     * @return 结果
     */
    @Override
    public int deleteStoreroomByStoreroomid(Long storeroomid)
    {
        return storeroomMapper.deleteStoreroomByStoreroomid(storeroomid);
    }

    /**
     * 根据条件分页查询已分配库房角色列表
     *
     * @param storeroom 库房
     * @return 库房
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<Storeroom> selectAllocatedList(Storeroom storeroom)
    {
        return storeroomMapper.selectAllocatedList(storeroom);
    }

    /**
     * 根据条件分页查询未分配库房角色列表
     *
     * @param storeroom 库房
     * @return 库房
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<Storeroom> selectUnallocatedList(Storeroom storeroom)
    {
        return storeroomMapper.selectUnallocatedList(storeroom);
    }

    /**
     * 根据枯矾改变吗获取所有库位
     *
     * @param storeroom 库房
     * @return 库房集合
     */
    public List<Storeroom> selectStoreSiteByRoom(Storeroom storeroom) {
        return storeroomMapper.selectStoreSiteByRoom(storeroom);
    };

    /**
     * 依据库房主键查询库管员姓名（STOREROOM.ROOMCHARGER → EMPLOYEE.EMP_NAME）。
     *
     * @param storeroomid 库房主键
     * @return 库管员姓名；查不到返回 null
     */
    @Override
    public String selectKeeperNameByStoreroomid(Long storeroomid)
    {
        if (storeroomid == null)
        {
            return null;
        }
        return storeroomMapper.selectKeeperNameByStoreroomid(storeroomid);
    }

}

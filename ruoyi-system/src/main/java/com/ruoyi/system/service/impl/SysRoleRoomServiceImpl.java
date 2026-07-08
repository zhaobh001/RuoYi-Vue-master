package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRoleRoomMapper;
import com.ruoyi.system.domain.SysRoleRoom;
import com.ruoyi.system.service.ISysRoleRoomService;

/**
 * 角色和库房关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-02
 */
@Service
public class SysRoleRoomServiceImpl implements ISysRoleRoomService 
{
    @Autowired
    private SysRoleRoomMapper sysRoleRoomMapper;

    /**
     * 查询角色和库房关联
     * 
     * @param roleId 角色和库房关联主键
     * @return 角色和库房关联
     */
    @Override
    public SysRoleRoom selectSysRoleRoomByRoleId(Long roleId)
    {
        return sysRoleRoomMapper.selectSysRoleRoomByRoleId(roleId);
    }

    /**
     * 查询角色和库房关联列表
     * 
     * @param sysRoleRoom 角色和库房关联
     * @return 角色和库房关联
     */
    @Override
    public List<SysRoleRoom> selectSysRoleRoomList(SysRoleRoom sysRoleRoom)
    {
        return sysRoleRoomMapper.selectSysRoleRoomList(sysRoleRoom);
    }

    /**
     * 新增角色和库房关联
     * 
     * @param sysRoleRoom 角色和库房关联
     * @return 结果
     */
    @Override
    public int insertSysRoleRoom(SysRoleRoom sysRoleRoom)
    {
        return sysRoleRoomMapper.insertSysRoleRoom(sysRoleRoom);
    }

    /**
     * 修改角色和库房关联
     * 
     * @param sysRoleRoom 角色和库房关联
     * @return 结果
     */
    @Override
    public int updateSysRoleRoom(SysRoleRoom sysRoleRoom)
    {
        return sysRoleRoomMapper.updateSysRoleRoom(sysRoleRoom);
    }

    /**
     * 批量删除角色和库房关联
     * 
     * @param roleIds 需要删除的角色和库房关联主键
     * @return 结果
     */
    @Override
    public int deleteSysRoleRoomByRoleIds(Long[] roleIds)
    {
        return sysRoleRoomMapper.deleteSysRoleRoomByRoleIds(roleIds);
    }

    /**
     * 删除角色和库房关联信息
     * 
     * @param roleId 角色和库房关联主键
     * @return 结果
     */
    @Override
    public int deleteSysRoleRoomByRoleId(Long roleId)
    {
        return sysRoleRoomMapper.deleteSysRoleRoomByRoleId(roleId);
    }
}

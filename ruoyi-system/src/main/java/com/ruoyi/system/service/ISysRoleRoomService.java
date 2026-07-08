package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysRoleRoom;

/**
 * 角色和库房关联Service接口
 * 
 * @author ruoyi
 * @date 2023-07-02
 */
public interface ISysRoleRoomService 
{
    /**
     * 查询角色和库房关联
     * 
     * @param roleId 角色和库房关联主键
     * @return 角色和库房关联
     */
    public SysRoleRoom selectSysRoleRoomByRoleId(Long roleId);

    /**
     * 查询角色和库房关联列表
     * 
     * @param sysRoleRoom 角色和库房关联
     * @return 角色和库房关联集合
     */
    public List<SysRoleRoom> selectSysRoleRoomList(SysRoleRoom sysRoleRoom);

    /**
     * 新增角色和库房关联
     * 
     * @param sysRoleRoom 角色和库房关联
     * @return 结果
     */
    public int insertSysRoleRoom(SysRoleRoom sysRoleRoom);

    /**
     * 修改角色和库房关联
     * 
     * @param sysRoleRoom 角色和库房关联
     * @return 结果
     */
    public int updateSysRoleRoom(SysRoleRoom sysRoleRoom);

    /**
     * 批量删除角色和库房关联
     * 
     * @param roleIds 需要删除的角色和库房关联主键集合
     * @return 结果
     */
    public int deleteSysRoleRoomByRoleIds(Long[] roleIds);

    /**
     * 删除角色和库房关联信息
     * 
     * @param roleId 角色和库房关联主键
     * @return 结果
     */
    public int deleteSysRoleRoomByRoleId(Long roleId);
}

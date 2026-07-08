package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRoleRoom;
import com.ruoyi.system.domain.SysUserRole;
import org.apache.ibatis.annotations.Param;

/**
 * 角色和库房关联Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-02
 */
public interface SysRoleRoomMapper 
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
     * 删除角色和库房关联
     * 
     * @param roleId 角色和库房关联主键
     * @return 结果
     */
    public int deleteSysRoleRoomByRoleId(Long roleId);

    /**
     * 批量删除角色和库房关联
     * 
     * @param roomIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRoleRoomByRoleIds(Long[] roomIds);

    /**
     * 删除库房和角色关联信息
     *
     * @param sysRoleRoom 用户和角色关联信息
     * @return 结果
     */
    public int deleteRoleRoomInfo(SysRoleRoom sysRoleRoom);

    /**
     * 批量取消授权用户角色
     *
     * @param roleId 角色ID
     * @param roomIds 需要删除的库房数据ID
     * @return 结果
     */
    public int deleteRoleRoomInfos(@Param("roleId") Long roleId, @Param("roomIds") Long[] roomIds);

    /**
     * 批量新增用户角色信息
     *
     * @param roleRoomList 库房角色列表
     * @return 结果
     */
    public int batchRoleRoom(List<SysRoleRoom> roleRoomList);

}

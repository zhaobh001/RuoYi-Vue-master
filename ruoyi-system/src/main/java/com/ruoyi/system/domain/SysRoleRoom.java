package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 角色和库房关联对象 sys_role_room
 * 
 * @author ruoyi
 * @date 2023-07-02
 */
public class SysRoleRoom
{
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long roleId;

    /** 库房ID */
    @Excel(name = "库房ID")
    private Long storeroomid;

    public void setRoleId(Long roleId) 
    {
        this.roleId = roleId;
    }

    public Long getRoleId() 
    {
        return roleId;
    }
    public void setStoreroomid(Long storeroomid) 
    {
        this.storeroomid = storeroomid;
    }

    public Long getStoreroomid() 
    {
        return storeroomid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("storeroomid", getStoreroomid())
            .toString();
    }
}

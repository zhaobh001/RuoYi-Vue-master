package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 用户登录帐号对象 tuser
 * 
 * @author ruoyi
 * @date 2023-07-02
 */
public class Tuser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long tuserid;

    /** 客户编码 */
    @Excel(name = "客户编码")
    private String usercode;

    /** 姓名 */
    @Excel(name = "姓名")
    private String cname;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 用户状态 */
    @Excel(name = "用户状态")
    private Long state;

    /** LOGSCRIPT */
    @Excel(name = "LOGSCRIPT")
    private String logscript;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String memo;

    /** 序号 */
    @Excel(name = "序号")
    private Long dataversion;

    /** IP地址 */
    @Excel(name = "IP地址")
    private String ipaddress;

    /** 是否在线 */
    @Excel(name = "是否在线")
    private Long isOnline;

    /** 实物清点人序号 */
    @Excel(name = "实物清点人序号")
    private Long ordernum;

    public void setTuserid(Long tuserid) 
    {
        this.tuserid = tuserid;
    }

    public Long getTuserid() 
    {
        return tuserid;
    }
    public void setUsercode(String usercode) 
    {
        this.usercode = usercode;
    }

    public String getUsercode() 
    {
        return usercode;
    }
    public void setCname(String cname) 
    {
        this.cname = cname;
    }

    public String getCname() 
    {
        return cname;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }
    public void setLogscript(String logscript) 
    {
        this.logscript = logscript;
    }

    public String getLogscript() 
    {
        return logscript;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
    }
    public void setDataversion(Long dataversion) 
    {
        this.dataversion = dataversion;
    }

    public Long getDataversion() 
    {
        return dataversion;
    }
    public void setIpaddress(String ipaddress) 
    {
        this.ipaddress = ipaddress;
    }

    public String getIpaddress() 
    {
        return ipaddress;
    }
    public void setIsOnline(Long isOnline) 
    {
        this.isOnline = isOnline;
    }

    public Long getIsOnline() 
    {
        return isOnline;
    }
    public void setOrdernum(Long ordernum) 
    {
        this.ordernum = ordernum;
    }

    public Long getOrdernum() 
    {
        return ordernum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tuserid", getTuserid())
            .append("usercode", getUsercode())
            .append("cname", getCname())
            .append("password", getPassword())
            .append("state", getState())
            .append("logscript", getLogscript())
            .append("memo", getMemo())
            .append("dataversion", getDataversion())
            .append("ipaddress", getIpaddress())
            .append("isOnline", getIsOnline())
            .append("ordernum", getOrdernum())
            .toString();
    }
}

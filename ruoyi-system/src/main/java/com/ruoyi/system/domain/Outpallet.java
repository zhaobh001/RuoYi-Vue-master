package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 outpallet
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public class Outpallet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long pallettaskid;

    /** 凭证ID */
    @Excel(name = "凭证ID")
    private Long outproofid;

    /** 托盘号ID */
    @Excel(name = "托盘号ID")
    private Long palletid;

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** 货位ID */
    @Excel(name = "货位ID")
    private Long storesiteid;

    /** 货位号 */
    @Excel(name = "货位号")
    private String storesitetno;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collecttime;

    /** 采集人 */
    @Excel(name = "采集人")
    private Long collector;

    public void setPallettaskid(Long pallettaskid) 
    {
        this.pallettaskid = pallettaskid;
    }

    public Long getPallettaskid() 
    {
        return pallettaskid;
    }
    public void setOutproofid(Long outproofid) 
    {
        this.outproofid = outproofid;
    }

    public Long getOutproofid() 
    {
        return outproofid;
    }
    public void setPalletid(Long palletid) 
    {
        this.palletid = palletid;
    }

    public Long getPalletid() 
    {
        return palletid;
    }
    public void setPalletno(String palletno) 
    {
        this.palletno = palletno;
    }

    public String getPalletno() 
    {
        return palletno;
    }
    public void setStoresiteid(Long storesiteid) 
    {
        this.storesiteid = storesiteid;
    }

    public Long getStoresiteid() 
    {
        return storesiteid;
    }
    public void setStoresitetno(String storesitetno) 
    {
        this.storesitetno = storesitetno;
    }

    public String getStoresitetno() 
    {
        return storesitetno;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }
    public void setCollecttime(Date collecttime) 
    {
        this.collecttime = collecttime;
    }

    public Date getCollecttime() 
    {
        return collecttime;
    }
    public void setCollector(Long collector) 
    {
        this.collector = collector;
    }

    public Long getCollector() 
    {
        return collector;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pallettaskid", getPallettaskid())
            .append("outproofid", getOutproofid())
            .append("palletid", getPalletid())
            .append("palletno", getPalletno())
            .append("storesiteid", getStoresiteid())
            .append("storesitetno", getStoresitetno())
            .append("state", getState())
            .append("collecttime", getCollecttime())
            .append("collector", getCollector())
            .toString();
    }
}

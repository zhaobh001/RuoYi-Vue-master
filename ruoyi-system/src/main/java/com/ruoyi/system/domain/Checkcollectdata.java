package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 盘库采集数据对象 checkcollectdata
 * 
 * @author ruoyi
 * @date 2023-08-28
 */
public class Checkcollectdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long checkcollectdataid;

    /** 通讯批次 */
    @Excel(name = "通讯批次")
    private Long dcConnectid;

    /** CHCEKTASKITEMID */
    @Excel(name = "CHCEKTASKITEMID")
    private Long chcektaskitemid;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collecttime;

    /** 库位 */
    @Excel(name = "库位")
    private Long checksite;

    /** 物料 */
    @Excel(name = "物料")
    private Long materialid;

    /** 批次 */
    @Excel(name = "批次")
    private String batchno;

    /** 序列号 */
    @Excel(name = "序列号")
    private String sn;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal qty;

    /** ?空的 */
    @Excel(name = "?空的")
    private String checkdesc;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    /** - */
    @Excel(name = "-")
    private String data1;

    /** - */
    @Excel(name = "-")
    private String data2;

    /** - */
    @Excel(name = "-")
    private String data3;

    /** - */
    @Excel(name = "-")
    private String data4;

    /** - */
    @Excel(name = "-")
    private String data5;

    /** - */
    @Excel(name = "-")
    private String data6;

    /** - */
    @Excel(name = "-")
    private String data7;

    /** - */
    @Excel(name = "-")
    private String data8;

    /** 采集数据处理状态   0：采集已上传   1：WMS处理完成  -1：WMS处理失败   2：ERP处理成功  -2：ERP处理失败 */
    @Excel(name = "采集数据处理状态   0：采集已上传   1：WMS处理完成  -1：WMS处理失败   2：ERP处理成功  -2：ERP处理失败")
    private Long cstate;

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    public void setCheckcollectdataid(Long checkcollectdataid) 
    {
        this.checkcollectdataid = checkcollectdataid;
    }

    public Long getCheckcollectdataid() 
    {
        return checkcollectdataid;
    }
    public void setDcConnectid(Long dcConnectid) 
    {
        this.dcConnectid = dcConnectid;
    }

    public Long getDcConnectid() 
    {
        return dcConnectid;
    }
    public void setChcektaskitemid(Long chcektaskitemid) 
    {
        this.chcektaskitemid = chcektaskitemid;
    }

    public Long getChcektaskitemid() 
    {
        return chcektaskitemid;
    }
    public void setCollecttime(Date collecttime) 
    {
        this.collecttime = collecttime;
    }

    public Date getCollecttime() 
    {
        return collecttime;
    }
    public void setChecksite(Long checksite) 
    {
        this.checksite = checksite;
    }

    public Long getChecksite() 
    {
        return checksite;
    }
    public void setMaterialid(Long materialid) 
    {
        this.materialid = materialid;
    }

    public Long getMaterialid() 
    {
        return materialid;
    }
    public void setBatchno(String batchno) 
    {
        this.batchno = batchno;
    }

    public String getBatchno() 
    {
        return batchno;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public void setCheckdesc(String checkdesc)
    {
        this.checkdesc = checkdesc;
    }

    public String getCheckdesc() 
    {
        return checkdesc;
    }
    public void setDataversion(Long dataversion) 
    {
        this.dataversion = dataversion;
    }

    public Long getDataversion() 
    {
        return dataversion;
    }
    public void setData1(String data1) 
    {
        this.data1 = data1;
    }

    public String getData1() 
    {
        return data1;
    }
    public void setData2(String data2) 
    {
        this.data2 = data2;
    }

    public String getData2() 
    {
        return data2;
    }
    public void setData3(String data3) 
    {
        this.data3 = data3;
    }

    public String getData3() 
    {
        return data3;
    }
    public void setData4(String data4) 
    {
        this.data4 = data4;
    }

    public String getData4() 
    {
        return data4;
    }
    public void setData5(String data5) 
    {
        this.data5 = data5;
    }

    public String getData5() 
    {
        return data5;
    }
    public void setData6(String data6) 
    {
        this.data6 = data6;
    }

    public String getData6() 
    {
        return data6;
    }
    public void setData7(String data7) 
    {
        this.data7 = data7;
    }

    public String getData7() 
    {
        return data7;
    }
    public void setData8(String data8) 
    {
        this.data8 = data8;
    }

    public String getData8() 
    {
        return data8;
    }
    public void setCstate(Long cstate) 
    {
        this.cstate = cstate;
    }

    public Long getCstate() 
    {
        return cstate;
    }
    public void setPalletno(String palletno) 
    {
        this.palletno = palletno;
    }

    public String getPalletno() 
    {
        return palletno;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("checkcollectdataid", getCheckcollectdataid())
            .append("dcConnectid", getDcConnectid())
            .append("chcektaskitemid", getChcektaskitemid())
            .append("collecttime", getCollecttime())
            .append("checksite", getChecksite())
            .append("materialid", getMaterialid())
            .append("batchno", getBatchno())
            .append("sn", getSn())
            .append("qty", getQty())
            .append("checkdesc", getCheckdesc())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("data5", getData5())
            .append("data6", getData6())
            .append("data7", getData7())
            .append("data8", getData8())
            .append("cstate", getCstate())
            .append("palletno", getPalletno())
            .toString();
    }
}

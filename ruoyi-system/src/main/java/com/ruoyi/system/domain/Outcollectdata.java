package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 outcollectdata
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public class Outcollectdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long outcollectdataid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dcConnectid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outtaskitemid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date collecttime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outsite;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long materialid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String batchno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal qty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sn;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outdesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** ERP子库 */
    @Excel(name = "ERP子库")
    private String data1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data4;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data5;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data6;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data7;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data8;

    /** 采集数据处理状态   0：采集已上传   1：WMS处理完成  -1：WMS处理失败   2：ERP处理成功  -2：ERP处理失败 */
    @Excel(name = "采集数据处理状态   0：采集已上传   1：WMS处理完成  -1：WMS处理失败   2：ERP处理成功  -2：ERP处理失败")
    private Long cstate;

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** cux_wms_trans_interface的ID */
    @Excel(name = "cux_wms_trans_interface的ID")
    private Long transactionId;

    /** 生成调拨单状态0:未生成;1已生成 */
    @Excel(name = "生成调拨单状态0:未生成;1已生成")
    private Long transferstate;

    public void setOutcollectdataid(Long outcollectdataid) 
    {
        this.outcollectdataid = outcollectdataid;
    }

    public Long getOutcollectdataid() 
    {
        return outcollectdataid;
    }
    public void setDcConnectid(Long dcConnectid) 
    {
        this.dcConnectid = dcConnectid;
    }

    public Long getDcConnectid() 
    {
        return dcConnectid;
    }
    public void setOuttaskitemid(Long outtaskitemid) 
    {
        this.outtaskitemid = outtaskitemid;
    }

    public Long getOuttaskitemid() 
    {
        return outtaskitemid;
    }
    public void setCollecttime(Date collecttime) 
    {
        this.collecttime = collecttime;
    }

    public Date getCollecttime() 
    {
        return collecttime;
    }
    public void setOutsite(Long outsite) 
    {
        this.outsite = outsite;
    }

    public Long getOutsite() 
    {
        return outsite;
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

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public void setSn(String sn)
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }
    public void setOutdesc(String outdesc) 
    {
        this.outdesc = outdesc;
    }

    public String getOutdesc() 
    {
        return outdesc;
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
    public void setTransactionId(Long transactionId) 
    {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() 
    {
        return transactionId;
    }
    public void setTransferstate(Long transferstate) 
    {
        this.transferstate = transferstate;
    }

    public Long getTransferstate() 
    {
        return transferstate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("outcollectdataid", getOutcollectdataid())
            .append("dcConnectid", getDcConnectid())
            .append("outtaskitemid", getOuttaskitemid())
            .append("collecttime", getCollecttime())
            .append("outsite", getOutsite())
            .append("materialid", getMaterialid())
            .append("batchno", getBatchno())
            .append("qty", getQty())
            .append("sn", getSn())
            .append("outdesc", getOutdesc())
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
            .append("transactionId", getTransactionId())
            .append("transferstate", getTransferstate())
            .toString();
    }
}

package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 outorder
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public class Outorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long outorderid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outbillid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outorderno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outsite;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outbacthno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sn;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long creator;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long taskqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long finishqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outorderdesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data1;

    /** 0：系统建议出库信息 */
    @Excel(name = "0：系统建议出库信息")
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

    /** 出库口 */
    @Excel(name = "出库口")
    private String outsiteexit;

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** 颜色 */
    @Excel(name = "颜色")
    private String repColor;

    /** 特殊属性 */
    @Excel(name = "特殊属性")
    private String repProperty;

    /** 拥有方编码 */
    @Excel(name = "拥有方编码")
    private String repOwnerCode;

    /** 拥有方名称 */
    @Excel(name = "拥有方名称")
    private String repOwnerName;

    /** 库存组织 */
    @Excel(name = "库存组织")
    private String repOrg;

    /** ERP子库 */
    @Excel(name = "ERP子库")
    private String erpStoreroom;

    public void setOutorderid(Long outorderid) 
    {
        this.outorderid = outorderid;
    }

    public Long getOutorderid() 
    {
        return outorderid;
    }
    public void setOutbillid(Long outbillid) 
    {
        this.outbillid = outbillid;
    }

    public Long getOutbillid() 
    {
        return outbillid;
    }
    public void setOutorderno(String outorderno) 
    {
        this.outorderno = outorderno;
    }

    public String getOutorderno() 
    {
        return outorderno;
    }
    public void setOutsite(Long outsite) 
    {
        this.outsite = outsite;
    }

    public Long getOutsite() 
    {
        return outsite;
    }
    public void setOutbacthno(String outbacthno) 
    {
        this.outbacthno = outbacthno;
    }

    public String getOutbacthno() 
    {
        return outbacthno;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }
    public void setCreatedate(Date createdate) 
    {
        this.createdate = createdate;
    }

    public Date getCreatedate() 
    {
        return createdate;
    }
    public void setCreator(Long creator) 
    {
        this.creator = creator;
    }

    public Long getCreator() 
    {
        return creator;
    }
    public void setTaskqty(Long taskqty) 
    {
        this.taskqty = taskqty;
    }

    public Long getTaskqty() 
    {
        return taskqty;
    }
    public void setFinishqty(Long finishqty) 
    {
        this.finishqty = finishqty;
    }

    public Long getFinishqty() 
    {
        return finishqty;
    }
    public void setOutorderdesc(String outorderdesc) 
    {
        this.outorderdesc = outorderdesc;
    }

    public String getOutorderdesc() 
    {
        return outorderdesc;
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
    public void setOutsiteexit(String outsiteexit) 
    {
        this.outsiteexit = outsiteexit;
    }

    public String getOutsiteexit() 
    {
        return outsiteexit;
    }
    public void setPalletno(String palletno) 
    {
        this.palletno = palletno;
    }

    public String getPalletno() 
    {
        return palletno;
    }
    public void setRepColor(String repColor) 
    {
        this.repColor = repColor;
    }

    public String getRepColor() 
    {
        return repColor;
    }
    public void setRepProperty(String repProperty) 
    {
        this.repProperty = repProperty;
    }

    public String getRepProperty() 
    {
        return repProperty;
    }
    public void setRepOwnerCode(String repOwnerCode) 
    {
        this.repOwnerCode = repOwnerCode;
    }

    public String getRepOwnerCode() 
    {
        return repOwnerCode;
    }
    public void setRepOwnerName(String repOwnerName) 
    {
        this.repOwnerName = repOwnerName;
    }

    public String getRepOwnerName() 
    {
        return repOwnerName;
    }
    public void setRepOrg(String repOrg) 
    {
        this.repOrg = repOrg;
    }

    public String getRepOrg() 
    {
        return repOrg;
    }
    public void setErpStoreroom(String erpStoreroom) 
    {
        this.erpStoreroom = erpStoreroom;
    }

    public String getErpStoreroom() 
    {
        return erpStoreroom;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("outorderid", getOutorderid())
            .append("outbillid", getOutbillid())
            .append("outorderno", getOutorderno())
            .append("outsite", getOutsite())
            .append("outbacthno", getOutbacthno())
            .append("sn", getSn())
            .append("createdate", getCreatedate())
            .append("creator", getCreator())
            .append("taskqty", getTaskqty())
            .append("finishqty", getFinishqty())
            .append("outorderdesc", getOutorderdesc())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("data5", getData5())
            .append("data6", getData6())
            .append("data7", getData7())
            .append("data8", getData8())
            .append("outsiteexit", getOutsiteexit())
            .append("palletno", getPalletno())
            .append("repColor", getRepColor())
            .append("repProperty", getRepProperty())
            .append("repOwnerCode", getRepOwnerCode())
            .append("repOwnerName", getRepOwnerName())
            .append("repOrg", getRepOrg())
            .append("erpStoreroom", getErpStoreroom())
            .toString();
    }
}

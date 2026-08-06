package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系统单据类型 - transaction_type对象 iotype
 * 
 * @author ruoyi
 * @date 2026-04-16
 */
public class Iotype extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long iotypeid;

    /** 出：O
入：I */
    @Excel(name = "出：O入：I")
    private String inout;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String iotypeno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String iotypename;

    /** 0：WMS
1：外系统 */
    @Excel(name = "0：WMS1：外系统")
    private Long issystem;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String iotypedesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
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

    /** 0：允许手工
1：不允许手工 */
    @Excel(name = "0：允许手工1：不允许手工")
    private Long ismanual;

    /** 0：ERP检验
1：手工检验 2： 不检验 */
    @Excel(name = "0：ERP检验1：手工检验 2： 不检验")
    private Long ischeck;

    public void setIotypeid(Long iotypeid) 
    {
        this.iotypeid = iotypeid;
    }

    public Long getIotypeid() 
    {
        return iotypeid;
    }
    public void setInout(String inout) 
    {
        this.inout = inout;
    }

    public String getInout() 
    {
        return inout;
    }
    public void setIotypeno(String iotypeno) 
    {
        this.iotypeno = iotypeno;
    }

    public String getIotypeno() 
    {
        return iotypeno;
    }
    public void setIotypename(String iotypename) 
    {
        this.iotypename = iotypename;
    }

    public String getIotypename() 
    {
        return iotypename;
    }
    public void setIssystem(Long issystem) 
    {
        this.issystem = issystem;
    }

    public Long getIssystem() 
    {
        return issystem;
    }
    public void setIotypedesc(String iotypedesc) 
    {
        this.iotypedesc = iotypedesc;
    }

    public String getIotypedesc() 
    {
        return iotypedesc;
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
    public void setIsmanual(Long ismanual) 
    {
        this.ismanual = ismanual;
    }

    public Long getIsmanual() 
    {
        return ismanual;
    }
    public void setIscheck(Long ischeck) 
    {
        this.ischeck = ischeck;
    }

    public Long getIscheck() 
    {
        return ischeck;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("iotypeid", getIotypeid())
            .append("inout", getInout())
            .append("iotypeno", getIotypeno())
            .append("iotypename", getIotypename())
            .append("issystem", getIssystem())
            .append("iotypedesc", getIotypedesc())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("ismanual", getIsmanual())
            .append("ischeck", getIscheck())
            .toString();
    }
}

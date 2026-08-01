package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 deliverytaskitem_exce
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
public class DeliverytaskitemExce extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long intaskitemid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long intaskid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long inbillid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long materialid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String indesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String exexType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date collectDate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long transactionId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String productline;

    /** $column.columnComment */
    private Long exexid;

    public void setIntaskitemid(Long intaskitemid) 
    {
        this.intaskitemid = intaskitemid;
    }

    public Long getIntaskitemid() 
    {
        return intaskitemid;
    }
    public void setIntaskid(Long intaskid) 
    {
        this.intaskid = intaskid;
    }

    public Long getIntaskid() 
    {
        return intaskid;
    }
    public void setInbillid(Long inbillid) 
    {
        this.inbillid = inbillid;
    }

    public Long getInbillid() 
    {
        return inbillid;
    }
    public void setMaterialid(Long materialid) 
    {
        this.materialid = materialid;
    }

    public Long getMaterialid() 
    {
        return materialid;
    }
    public void setIndesc(String indesc) 
    {
        this.indesc = indesc;
    }

    public String getIndesc() 
    {
        return indesc;
    }
    public void setDataversion(Long dataversion) 
    {
        this.dataversion = dataversion;
    }

    public Long getDataversion() 
    {
        return dataversion;
    }
    public void setExexType(String exexType) 
    {
        this.exexType = exexType;
    }

    public String getExexType() 
    {
        return exexType;
    }
    public void setCollectDate(Date collectDate) 
    {
        this.collectDate = collectDate;
    }

    public Date getCollectDate() 
    {
        return collectDate;
    }
    public void setTransactionId(Long transactionId) 
    {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() 
    {
        return transactionId;
    }
    public void setProductline(String productline) 
    {
        this.productline = productline;
    }

    public String getProductline() 
    {
        return productline;
    }
    public void setExexid(Long exexid) 
    {
        this.exexid = exexid;
    }

    public Long getExexid() 
    {
        return exexid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("intaskitemid", getIntaskitemid())
            .append("intaskid", getIntaskid())
            .append("inbillid", getInbillid())
            .append("materialid", getMaterialid())
            .append("indesc", getIndesc())
            .append("dataversion", getDataversion())
            .append("exexType", getExexType())
            .append("collectDate", getCollectDate())
            .append("transactionId", getTransactionId())
            .append("productline", getProductline())
            .append("exexid", getExexid())
            .toString();
    }
}

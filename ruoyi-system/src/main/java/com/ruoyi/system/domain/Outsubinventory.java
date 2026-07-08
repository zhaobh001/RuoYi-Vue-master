package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 outsubinventory
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public class Outsubinventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String subinventoryCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String transferSubinventory;

    /** $column.columnComment */
    private Long subinventoryid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    public void setSubinventoryCode(String subinventoryCode) 
    {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode() 
    {
        return subinventoryCode;
    }
    public void setTransferSubinventory(String transferSubinventory) 
    {
        this.transferSubinventory = transferSubinventory;
    }

    public String getTransferSubinventory() 
    {
        return transferSubinventory;
    }
    public void setSubinventoryid(Long subinventoryid) 
    {
        this.subinventoryid = subinventoryid;
    }

    public Long getSubinventoryid() 
    {
        return subinventoryid;
    }
    public void setDataversion(Long dataversion) 
    {
        this.dataversion = dataversion;
    }

    public Long getDataversion() 
    {
        return dataversion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("subinventoryCode", getSubinventoryCode())
            .append("transferSubinventory", getTransferSubinventory())
            .append("subinventoryid", getSubinventoryid())
            .append("dataversion", getDataversion())
            .toString();
    }
}

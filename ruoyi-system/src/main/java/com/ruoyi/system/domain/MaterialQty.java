package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 库位物料数量控制对象 material_qty
 * 
 * @author ruoyi
 * @date 2023-08-22
 */
public class MaterialQty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long materialQtyId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String siteno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String matcode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long minQty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long deliveryQty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    public void setMaterialQtyId(Long materialQtyId) 
    {
        this.materialQtyId = materialQtyId;
    }

    public Long getMaterialQtyId() 
    {
        return materialQtyId;
    }
    public void setSiteno(String siteno) 
    {
        this.siteno = siteno;
    }

    public String getSiteno() 
    {
        return siteno;
    }
    public void setMatcode(String matcode) 
    {
        this.matcode = matcode;
    }

    public String getMatcode() 
    {
        return matcode;
    }
    public void setMinQty(Long minQty) 
    {
        this.minQty = minQty;
    }

    public Long getMinQty() 
    {
        return minQty;
    }
    public void setDeliveryQty(Long deliveryQty) 
    {
        this.deliveryQty = deliveryQty;
    }

    public Long getDeliveryQty() 
    {
        return deliveryQty;
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
            .append("materialQtyId", getMaterialQtyId())
            .append("siteno", getSiteno())
            .append("matcode", getMatcode())
            .append("minQty", getMinQty())
            .append("deliveryQty", getDeliveryQty())
            .append("dataversion", getDataversion())
            .toString();
    }
}

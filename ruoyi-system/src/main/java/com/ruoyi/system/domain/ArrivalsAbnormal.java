package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 到货异常信息,已单据为单位,不和具体物料关联对象 arrivals_abnormal
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public class ArrivalsAbnormal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 到货异常ID */
    private Long abnomalid;

    /** 到货登记ID */
    @Excel(name = "到货登记ID")
    private Long arrivalsBillid;

    /** 异常类型ID */
    @Excel(name = "异常类型ID")
    private Long bbDictionaryid;

    /** 数量 */
    @Excel(name = "数量")
    private Long qty;

    public void setAbnomalid(Long abnomalid) 
    {
        this.abnomalid = abnomalid;
    }

    public Long getAbnomalid() 
    {
        return abnomalid;
    }
    public void setArrivalsBillid(Long arrivalsBillid) 
    {
        this.arrivalsBillid = arrivalsBillid;
    }

    public Long getArrivalsBillid() 
    {
        return arrivalsBillid;
    }
    public void setBbDictionaryid(Long bbDictionaryid) 
    {
        this.bbDictionaryid = bbDictionaryid;
    }

    public Long getBbDictionaryid() 
    {
        return bbDictionaryid;
    }
    public void setQty(Long qty) 
    {
        this.qty = qty;
    }

    public Long getQty() 
    {
        return qty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("abnomalid", getAbnomalid())
            .append("arrivalsBillid", getArrivalsBillid())
            .append("bbDictionaryid", getBbDictionaryid())
            .append("qty", getQty())
            .append("remark", getRemark())
            .toString();
    }
}

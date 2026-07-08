package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 到货单实物清点人对象 arrivals_bill_checker
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public class ArrivalsBillChecker extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实物清点人序列SEQ,ABCHECKER_SEQ */
    private Long abcheckerSeqid;

    /** 到货登记清单号 */
    @Excel(name = "到货登记清单号")
    private Long arrivalsBillid;

    /** 清点人ID */
    @Excel(name = "清点人ID")
    private Long userid;

    public void setAbcheckerSeqid(Long abcheckerSeqid) 
    {
        this.abcheckerSeqid = abcheckerSeqid;
    }

    public Long getAbcheckerSeqid() 
    {
        return abcheckerSeqid;
    }
    public void setArrivalsBillid(Long arrivalsBillid) 
    {
        this.arrivalsBillid = arrivalsBillid;
    }

    public Long getArrivalsBillid() 
    {
        return arrivalsBillid;
    }
    public void setUserid(Long userid) 
    {
        this.userid = userid;
    }

    public Long getUserid() 
    {
        return userid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("abcheckerSeqid", getAbcheckerSeqid())
            .append("arrivalsBillid", getArrivalsBillid())
            .append("userid", getUserid())
            .toString();
    }
}

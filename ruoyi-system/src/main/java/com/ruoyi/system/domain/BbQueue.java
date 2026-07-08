package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 单号日期序列对象 bb_queue
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
public class BbQueue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long bbQueueid;

    /** 日 */
    @Excel(name = "日")
    private String cata4;

    /** 月 */
    @Excel(name = "月")
    private String cata3;

    /** 年 */
    @Excel(name = "年")
    private String cata2;

    /** 单据名称 */
    @Excel(name = "单据名称")
    private String cata1;

    /** 某日序号 */
    @Excel(name = "某日序号")
    private Long sno;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    public void setBbQueueid(Long bbQueueid) 
    {
        this.bbQueueid = bbQueueid;
    }

    public Long getBbQueueid() 
    {
        return bbQueueid;
    }
    public void setCata4(String cata4) 
    {
        this.cata4 = cata4;
    }

    public String getCata4() 
    {
        return cata4;
    }
    public void setCata3(String cata3) 
    {
        this.cata3 = cata3;
    }

    public String getCata3() 
    {
        return cata3;
    }
    public void setCata2(String cata2) 
    {
        this.cata2 = cata2;
    }

    public String getCata2() 
    {
        return cata2;
    }
    public void setCata1(String cata1) 
    {
        this.cata1 = cata1;
    }

    public String getCata1() 
    {
        return cata1;
    }
    public void setSno(Long sno) 
    {
        this.sno = sno;
    }

    public Long getSno() 
    {
        return sno;
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
            .append("bbQueueid", getBbQueueid())
            .append("cata4", getCata4())
            .append("cata3", getCata3())
            .append("cata2", getCata2())
            .append("cata1", getCata1())
            .append("sno", getSno())
            .append("dataversion", getDataversion())
            .toString();
    }
}

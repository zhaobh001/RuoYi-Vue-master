package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 盘点单对象 checkbill
 * 
 * @author ruoyi
 * @date 2023-08-26
 */
public class Checkbill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long checkbillid;

    /** 单号 */
    @Excel(name = "单号")
    private String billno;

    /** 创建人ID */
    @Excel(name = "创建人ID")
    private Long creator;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdate;

    /** 0  初始化盘库
1  月盘库
2  局部盘库 */
    @Excel(name = "0  初始化盘库1  月盘库2  局部盘库")
    private Long checktype;

    /** 0  按库位
1  按货物
2  货物类 */
    @Excel(name = "0  按库位  按货物2  货物类")
    private Long checkmethod;

    /** 0  新建
1  开盘
2  结盘 */
    @Excel(name = "0  新建1  开盘2  结盘")
    private Long billstate;

    /** 库房 */
    @Excel(name = "库房")
    private Long depotno;

    /** ?空的 */
    @Excel(name = "?空的")
    private String checkbilldesc;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    /** 巡盘单号 */
    @Excel(name = "巡盘单号")
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

    /** 开盘日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开盘日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date executedate;

    /** 结盘日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结盘日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishdate;

    /** 0  按批次生成任务
1 不按批次生成任务 */
    @Excel(name = "0  按批次生成任务1 不按批次生成任务")
    private Long batchstate;

    public void setCheckbillid(Long checkbillid) 
    {
        this.checkbillid = checkbillid;
    }

    public Long getCheckbillid() 
    {
        return checkbillid;
    }
    public void setBillno(String billno) 
    {
        this.billno = billno;
    }

    public String getBillno() 
    {
        return billno;
    }
    public void setCreator(Long creator) 
    {
        this.creator = creator;
    }

    public Long getCreator() 
    {
        return creator;
    }
    public void setCreatedate(Date createdate) 
    {
        this.createdate = createdate;
    }

    public Date getCreatedate() 
    {
        return createdate;
    }
    public void setChecktype(Long checktype) 
    {
        this.checktype = checktype;
    }

    public Long getChecktype() 
    {
        return checktype;
    }
    public void setCheckmethod(Long checkmethod) 
    {
        this.checkmethod = checkmethod;
    }

    public Long getCheckmethod() 
    {
        return checkmethod;
    }
    public void setBillstate(Long billstate) 
    {
        this.billstate = billstate;
    }

    public Long getBillstate() 
    {
        return billstate;
    }
    public void setDepotno(Long depotno) 
    {
        this.depotno = depotno;
    }

    public Long getDepotno() 
    {
        return depotno;
    }
    public void setCheckbilldesc(String checkbilldesc) 
    {
        this.checkbilldesc = checkbilldesc;
    }

    public String getCheckbilldesc() 
    {
        return checkbilldesc;
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
    public void setExecutedate(Date executedate) 
    {
        this.executedate = executedate;
    }

    public Date getExecutedate() 
    {
        return executedate;
    }
    public void setFinishdate(Date finishdate) 
    {
        this.finishdate = finishdate;
    }

    public Date getFinishdate() 
    {
        return finishdate;
    }
    public void setBatchstate(Long batchstate) 
    {
        this.batchstate = batchstate;
    }

    public Long getBatchstate() 
    {
        return batchstate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("checkbillid", getCheckbillid())
            .append("billno", getBillno())
            .append("creator", getCreator())
            .append("createdate", getCreatedate())
            .append("checktype", getChecktype())
            .append("checkmethod", getCheckmethod())
            .append("billstate", getBillstate())
            .append("depotno", getDepotno())
            .append("checkbilldesc", getCheckbilldesc())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("data5", getData5())
            .append("data6", getData6())
            .append("data7", getData7())
            .append("data8", getData8())
            .append("executedate", getExecutedate())
            .append("finishdate", getFinishdate())
            .append("batchstate", getBatchstate())
            .toString();
    }
}

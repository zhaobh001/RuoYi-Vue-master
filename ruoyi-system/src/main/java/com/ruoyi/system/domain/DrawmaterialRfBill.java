package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

import java.util.Date;

/**
 * 拉式发料对象 drawmaterial_rf_bill
 * 
 * @author ruoyi
 * @date 2023-08-23
 */
public class DrawmaterialRfBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long drawmaterialRfBillid;

    /** 单号 */
    @Excel(name = "单号")
    private String drawmaterialRfBillno;

    /** 0：需求提交
1：备货
2：已发 */
    @Excel(name = "0：需求提交1：备货2：已发")
    private String drawmaterialRfBillstate;

    /** 人员 */
    @Excel(name = "人员")
    private Long drawmaterialRfBillSender;

    /** 描述 */
    @Excel(name = "描述")
    private String drawmaterialRfDesc;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    /** - */
    @Excel(name = "-")
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
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setDrawmaterialRfBillid(Long drawmaterialRfBillid)
    {
        this.drawmaterialRfBillid = drawmaterialRfBillid;
    }

    public Long getDrawmaterialRfBillid() 
    {
        return drawmaterialRfBillid;
    }
    public void setDrawmaterialRfBillno(String drawmaterialRfBillno) 
    {
        this.drawmaterialRfBillno = drawmaterialRfBillno;
    }

    public String getDrawmaterialRfBillno() 
    {
        return drawmaterialRfBillno;
    }
    public void setDrawmaterialRfBillstate(String drawmaterialRfBillstate) 
    {
        this.drawmaterialRfBillstate = drawmaterialRfBillstate;
    }

    public String getDrawmaterialRfBillstate() 
    {
        return drawmaterialRfBillstate;
    }
    public void setDrawmaterialRfBillSender(Long drawmaterialRfBillSender) 
    {
        this.drawmaterialRfBillSender = drawmaterialRfBillSender;
    }

    public Long getDrawmaterialRfBillSender() 
    {
        return drawmaterialRfBillSender;
    }
    public void setDrawmaterialRfDesc(String drawmaterialRfDesc) 
    {
        this.drawmaterialRfDesc = drawmaterialRfDesc;
    }

    public String getDrawmaterialRfDesc() 
    {
        return drawmaterialRfDesc;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("drawmaterialRfBillid", drawmaterialRfBillid)
                .append("drawmaterialRfBillno", drawmaterialRfBillno)
                .append("drawmaterialRfBillstate", drawmaterialRfBillstate)
                .append("drawmaterialRfBillSender", drawmaterialRfBillSender)
                .append("drawmaterialRfDesc", drawmaterialRfDesc)
                .append("dataversion", dataversion)
                .append("data1", data1)
                .append("data2", data2)
                .append("data3", data3)
                .append("data4", data4)
                .append("createtime", createtime)
                .toString();
    }
}

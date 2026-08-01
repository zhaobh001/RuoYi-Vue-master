package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 deliverytask
 * 
 * @author ruoyi
 * @date 2026-07-09
 */
public class Deliverytask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long intaskid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String intaskno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long tasksource;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String taskcomment;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long storeroomid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long collecter;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long instate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long collectkind;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date indate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String indesc;

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

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String forcesite;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String forcebatch;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long batchflag;

    public void setIntaskid(Long intaskid) 
    {
        this.intaskid = intaskid;
    }

    public Long getIntaskid() 
    {
        return intaskid;
    }
    public void setIntaskno(String intaskno) 
    {
        this.intaskno = intaskno;
    }

    public String getIntaskno() 
    {
        return intaskno;
    }
    public void setTasksource(Long tasksource) 
    {
        this.tasksource = tasksource;
    }

    public Long getTasksource() 
    {
        return tasksource;
    }
    public void setTaskcomment(String taskcomment) 
    {
        this.taskcomment = taskcomment;
    }

    public String getTaskcomment() 
    {
        return taskcomment;
    }
    public void setStoreroomid(Long storeroomid) 
    {
        this.storeroomid = storeroomid;
    }

    public Long getStoreroomid() 
    {
        return storeroomid;
    }
    public void setCollecter(Long collecter) 
    {
        this.collecter = collecter;
    }

    public Long getCollecter() 
    {
        return collecter;
    }
    public void setInstate(Long instate) 
    {
        this.instate = instate;
    }

    public Long getInstate() 
    {
        return instate;
    }
    public void setCollectkind(Long collectkind) 
    {
        this.collectkind = collectkind;
    }

    public Long getCollectkind() 
    {
        return collectkind;
    }
    public void setIndate(Date indate) 
    {
        this.indate = indate;
    }

    public Date getIndate() 
    {
        return indate;
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
    public void setForcesite(String forcesite) 
    {
        this.forcesite = forcesite;
    }

    public String getForcesite() 
    {
        return forcesite;
    }
    public void setForcebatch(String forcebatch) 
    {
        this.forcebatch = forcebatch;
    }

    public String getForcebatch() 
    {
        return forcebatch;
    }
    public void setBatchflag(Long batchflag) 
    {
        this.batchflag = batchflag;
    }

    public Long getBatchflag() 
    {
        return batchflag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("intaskid", getIntaskid())
            .append("intaskno", getIntaskno())
            .append("tasksource", getTasksource())
            .append("taskcomment", getTaskcomment())
            .append("storeroomid", getStoreroomid())
            .append("collecter", getCollecter())
            .append("instate", getInstate())
            .append("collectkind", getCollectkind())
            .append("indate", getIndate())
            .append("indesc", getIndesc())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("data5", getData5())
            .append("data6", getData6())
            .append("data7", getData7())
            .append("data8", getData8())
            .append("forcesite", getForcesite())
            .append("forcebatch", getForcebatch())
            .append("batchflag", getBatchflag())
            .toString();
    }
}

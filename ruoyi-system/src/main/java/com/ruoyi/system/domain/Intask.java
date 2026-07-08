package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 入库任务对象 intask
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public class Intask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long intaskid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String intaskno;

    /** 存放：入库凭证ID （字段不显示） */
    @Excel(name = "存放：入库凭证ID ", readConverterExp = "字=段不显示")
    private Long tasksource;

    /** 存放：入库凭证号 */
    @Excel(name = "存放：入库凭证号")
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

    /** 0:平库    1:立库 */
    @Excel(name = "0:平库    1:立库")
    private String data1;

    /** 入库单号 */
    @Excel(name = "入库单号")
    private String data2;

    /** 凭证来源 */
    @Excel(name = "凭证来源")
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

    /** 批处理(0入库1批处理入库) */
    @Excel(name = "批处理(0入库1批处理入库)")
    private Long batchflag;

    /** 库房编码 */
    @Excel(name = "库房编码")
    private String storeroomno;

    /** 工位号 */
    @Excel(name = "工位号")
    private String workstation;

    /** 库房名称 */
    @Excel(name = "库房名称")
    private String storeroomname;

    /** operation */
    @Excel(name = "operation")
    private String operation;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 明细表采集人 */
    @Excel(name = "明细表采集人")
    private Long i_collecter;

    /** 任务表采集人 */
    @Excel(name = "任务表采集人")
    private Long t_collecter;

    /** roomtag */
    @Excel(name = "roomTag")
    private String roomTag;

    /** transferType */
    @Excel(name = "transferType")
    private String transferType;

    /** 用户ID */
    @Excel(name = "角色iD")
    private String roleoRuserId;


    /** 排序方式 */
    @Excel(name = "排序方式")
    private String sortType;

    /** 排序列 */
    @Excel(name = "排序列")
    private String sortColumn;

    /** 搜索关键字 */
    @Excel(name = "搜索关键字")
    private String searchKey;

    private String parname;

    public String getParname() {
        return parname;
    }

    public void setParname(String parname) {
        this.parname = parname;
    }

    private int PageIndex;
    private int PageSize;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getRoleoRuserId() {
        return roleoRuserId;
    }

    public void setRoleoRuserId(String roleoRuserId) {
        this.roleoRuserId = roleoRuserId;
    }

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

    public String getStoreroomno() {
        return storeroomno;
    }

    public void setStoreroomno(String storeroomno) {
        this.storeroomno = storeroomno;
    }

    public String getWorkstation() {
        return workstation;
    }

    public void setWorkstation(String workstation) {
        this.workstation = workstation;
    }

    public String getStoreroomname() {
        return storeroomname;
    }

    public void setStoreroomname(String storeroomname) {
        this.storeroomname = storeroomname;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getI_collecter() {
        return i_collecter;
    }

    public void setI_collecter(Long i_collecter) {
        this.i_collecter = i_collecter;
    }

    public Long getT_collecter() {
        return t_collecter;
    }

    public void setT_collecter(Long t_collecter) {
        this.t_collecter = t_collecter;
    }

    public String getRoomTag() {
        return roomTag;
    }

    public void setRoomTag(String roomTag) {
        this.roomTag = roomTag;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("intaskid", intaskid)
                .append("intaskno", intaskno)
                .append("tasksource", tasksource)
                .append("taskcomment", taskcomment)
                .append("storeroomid", storeroomid)
                .append("collecter", collecter)
                .append("instate", instate)
                .append("collectkind", collectkind)
                .append("indate", indate)
                .append("indesc", indesc)
                .append("dataversion", dataversion)
                .append("data1", data1)
                .append("data2", data2)
                .append("data3", data3)
                .append("data4", data4)
                .append("data5", data5)
                .append("data6", data6)
                .append("data7", data7)
                .append("data8", data8)
                .append("forcesite", forcesite)
                .append("forcebatch", forcebatch)
                .append("batchflag", batchflag)
                .append("storeroomno", storeroomno)
                .append("workstation", workstation)
                .append("storeroomname", storeroomname)
                .append("operation", operation)
                .append("userId", userId)
                .append("i_collecter", i_collecter)
                .append("t_collecter", t_collecter)
                .append("roomTag", roomTag)
                .append("transferType", transferType)
                .append("sortType", sortType)
                .append("sortColumn", sortColumn)
                .append("searchKey", searchKey)
                .append("roleoRuserId", roleoRuserId)
                .toString();
    }
}

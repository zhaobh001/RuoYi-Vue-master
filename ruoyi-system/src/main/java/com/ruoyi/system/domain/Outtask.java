package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 outtask
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public class Outtask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long outtaskid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outtaskno;

    /** 存放:出库凭证ID */
    @Excel(name = "存放:出库凭证ID")
    private Long tasksource;

    /** 存放：出库凭证号 */
    @Excel(name = "存放：出库凭证号")
    private String taskcomment;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long storeroomid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long collecter;

    /**  ?? 0未接收, 1已接收, 2已上传, 3完工 */
    @Excel(name = " ?? 0未接收, 1已接收, 2已上传, 3完工")
    private Long outstate;

    /** ONLINE
WIRELESS */
    @Excel(name = "ONLINEWIRELESS")
    private String collectkind;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date outdate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outdesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String forcesite;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String forcebatch;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data1;

    /** 出库单号 */
    @Excel(name = "出库单号")
    private String data2;

    /** 来源单号 */
    @Excel(name = "来源单号")
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

    /** 批处理(0出库1整盘出库) */
    @Excel(name = "批处理(0出库1整盘出库)")
    private Long batchflag;

    /** 产线编号 */
    @Excel(name = "产线编号")
    private String productline;

    /** 工位 */
    @Excel(name = "工位")
    private String workstation;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String beatflag;


    private String storeroomno;
    private String orderno;
    private String po_number;
    private String storesiteno;
    private String matcode;
    private String matname;
    private String operation;
    private String userId;
    private Long i_collecter;
    private Long t_collecter;
    private Long id;
    private String wip_supplement_flag;
    private String schedule_group_name;
    private String delivery_data;
    private String delivery_time;

    private int PageIndex;
    private int PageSize;

    private String finshFlg;

    public String getFinshFlg() {
        return finshFlg;
    }

    public void setFinshFlg(String finshFlg) {
        this.finshFlg = finshFlg;
    }

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

    /** 用户ID */
    @Excel(name = "角色iD")
    private String roleoRuserId;
    /** roomtag */
    @Excel(name = "roomTag")
    private String roomTag;
    /** transferType */
    @Excel(name = "transferType")
    private String transferType;

    /** 排序方式 */
    @Excel(name = "排序方式")
    private String sortType;

    /** 排序列 */
    @Excel(name = "排序列")
    private String sortColumn;

    /** 搜索关键字 */
    @Excel(name = "搜索关键字")
    private String searchKey;

    public String getStoreroomno() {
        return storeroomno;
    }

    public void setStoreroomno(String storeroomno) {
        this.storeroomno = storeroomno;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getPo_number() {
        return po_number;
    }

    public void setPo_number(String po_number) {
        this.po_number = po_number;
    }

    public String getStoresiteno() {
        return storesiteno;
    }

    public void setStoresiteno(String storesiteno) {
        this.storesiteno = storesiteno;
    }

    public String getMatcode() {
        return matcode;
    }

    public void setMatcode(String matcode) {
        this.matcode = matcode;
    }

    public String getMatname() {
        return matname;
    }

    public void setMatname(String matname) {
        this.matname = matname;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWip_supplement_flag() {
        return wip_supplement_flag;
    }

    public void setWip_supplement_flag(String wip_supplement_flag) {
        this.wip_supplement_flag = wip_supplement_flag;
    }

    public String getSchedule_group_name() {
        return schedule_group_name;
    }

    public void setSchedule_group_name(String schedule_group_name) {
        this.schedule_group_name = schedule_group_name;
    }

    public String getRoleoRuserId() {
        return roleoRuserId;
    }

    public void setRoleoRuserId(String roleoRuserId) {
        this.roleoRuserId = roleoRuserId;
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

    public String getDelivery_data() {
        return delivery_data;
    }

    public void setDelivery_data(String delivery_data) {
        this.delivery_data = delivery_data;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public void setOuttaskid(Long outtaskid)
    {
        this.outtaskid = outtaskid;
    }

    public Long getOuttaskid() 
    {
        return outtaskid;
    }
    public void setOuttaskno(String outtaskno) 
    {
        this.outtaskno = outtaskno;
    }

    public String getOuttaskno() 
    {
        return outtaskno;
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
    public void setOutstate(Long outstate) 
    {
        this.outstate = outstate;
    }

    public Long getOutstate() 
    {
        return outstate;
    }
    public void setCollectkind(String collectkind) 
    {
        this.collectkind = collectkind;
    }

    public String getCollectkind() 
    {
        return collectkind;
    }
    public void setOutdate(Date outdate) 
    {
        this.outdate = outdate;
    }

    public Date getOutdate() 
    {
        return outdate;
    }
    public void setOutdesc(String outdesc) 
    {
        this.outdesc = outdesc;
    }

    public String getOutdesc() 
    {
        return outdesc;
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
    public void setBatchflag(Long batchflag) 
    {
        this.batchflag = batchflag;
    }

    public Long getBatchflag() 
    {
        return batchflag;
    }
    public void setProductline(String productline) 
    {
        this.productline = productline;
    }

    public String getProductline() 
    {
        return productline;
    }
    public void setWorkstation(String workstation) 
    {
        this.workstation = workstation;
    }

    public String getWorkstation() 
    {
        return workstation;
    }
    public void setBeatflag(String beatflag) 
    {
        this.beatflag = beatflag;
    }

    public String getBeatflag() 
    {
        return beatflag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("outtaskid", outtaskid)
                .append("outtaskno", outtaskno)
                .append("tasksource", tasksource)
                .append("taskcomment", taskcomment)
                .append("storeroomid", storeroomid)
                .append("collecter", collecter)
                .append("outstate", outstate)
                .append("collectkind", collectkind)
                .append("outdate", outdate)
                .append("outdesc", outdesc)
                .append("forcesite", forcesite)
                .append("forcebatch", forcebatch)
                .append("dataversion", dataversion)
                .append("data1", data1)
                .append("data2", data2)
                .append("data3", data3)
                .append("data4", data4)
                .append("data5", data5)
                .append("data6", data6)
                .append("data7", data7)
                .append("data8", data8)
                .append("batchflag", batchflag)
                .append("productline", productline)
                .append("workstation", workstation)
                .append("beatflag", beatflag)
                .append("storeroomno", storeroomno)
                .append("orderno", orderno)
                .append("po_number", po_number)
                .append("storesiteno", storesiteno)
                .append("matcode", matcode)
                .append("matname", matname)
                .append("operation", operation)
                .append("userId", userId)
                .append("i_collecter", i_collecter)
                .append("t_collecter", t_collecter)
                .append("id", id)
                .append("wip_supplement_flag", wip_supplement_flag)
                .append("schedule_group_name", schedule_group_name)
                .append("delivery_data", delivery_data)
                .append("delivery_time", delivery_time)
                .append("roleoRuserId", roleoRuserId)
                .append("roomTag", roomTag)
                .append("transferType", transferType)
                .append("sortType", sortType)
                .append("sortColumn", sortColumn)
                .append("searchKey", searchKey)
                .toString();
    }
}

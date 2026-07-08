package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 盘库任务对象 checktask
 * 
 * @author ruoyi
 * @date 2023-08-26
 */
public class Checktask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long checktaskid;

    /** 盘库任务号 */
    @Excel(name = "盘库任务号")
    private String checktaskno;

    /** 存放：盘库单ID */
    @Excel(name = "存放：盘库单ID")
    private Long tasksource;

    /** 存放：盘库单号 */
    @Excel(name = "存放：盘库单号")
    private String taskcomment;

    /** 库房 */
    @Excel(name = "库房")
    private Long storeroomid;

    /** 0  按库位
1  按货物
2  货物类 */
    @Excel(name = "0  按库位1  按货物2  货物类")
    private Long checkmethod;

    /** 采集人 */
    @Excel(name = "采集人")
    private Long collecter;

    /** 状态 */
    @Excel(name = "状态")
    private Long checkstate;

    /** - */
    @Excel(name = "-")
    private String collectkind;

    /** 盘库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "盘库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkdate;

    /** ?空 */
    @Excel(name = "?空")
    private String checkdesc;

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
    private String userId;
    private Long iUserId;
    private Long roleoRuserId;
    private String roomTag;

    private String storeroomno;
    private String storesite;
    private String matcode2;
    private String palletno;
    private String checkmethod_nm;
    private String collectdataqty;
    private String subinventory_code;
    private String status;
    private String co_checkitemid;
    private String storesiteno;
    private String matcode;
    private String billstate;

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


    public String getPalletno() {
        return palletno;
    }

    public void setPalletno(String palletno) {
        this.palletno = palletno;
    }

    private String storeroomname;

    public String getStoreroomname() {
        return storeroomname;
    }

    public void setStoreroomname(String storeroomname) {
        this.storeroomname = storeroomname;
    }

    public String getStoreroomno() {
        return storeroomno;
    }

    public void setStoreroomno(String storeroomno) {
        this.storeroomno = storeroomno;
    }

    public String getStoresite() {
        return storesite;
    }

    public void setStoresite(String storesite) {
        this.storesite = storesite;
    }

    public String getMatcode2() {
        return matcode2;
    }

    public void setMatcode2(String matcode2) {
        this.matcode2 = matcode2;
    }

    public String getCheckmethod_nm() {
        return checkmethod_nm;
    }

    public void setCheckmethod_nm(String checkmethod_nm) {
        this.checkmethod_nm = checkmethod_nm;
    }

    public String getCollectdataqty() {
        return collectdataqty;
    }

    public void setCollectdataqty(String collectdataqty) {
        this.collectdataqty = collectdataqty;
    }

    public String getSubinventory_code() {
        return subinventory_code;
    }

    public void setSubinventory_code(String subinventory_code) {
        this.subinventory_code = subinventory_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCo_checkitemid() {
        return co_checkitemid;
    }

    public void setCo_checkitemid(String co_checkitemid) {
        this.co_checkitemid = co_checkitemid;
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

    public String getBillstate() {
        return billstate;
    }

    public void setBillstate(String billstate) {
        this.billstate = billstate;
    }

    public Long getiUserId() {
        return iUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setiUserId(Long iUserId) {
        this.iUserId = iUserId;
    }

    public Long getRoleoRuserId() {
        return roleoRuserId;
    }

    public void setRoleoRuserId(Long roleoRuserId) {
        this.roleoRuserId = roleoRuserId;
    }

    public String getRoomTag() {
        return roomTag;
    }

    public void setRoomTag(String roomTag) {
        this.roomTag = roomTag;
    }

    public void setChecktaskid(Long checktaskid)
    {
        this.checktaskid = checktaskid;
    }

    public Long getChecktaskid() 
    {
        return checktaskid;
    }
    public void setChecktaskno(String checktaskno) 
    {
        this.checktaskno = checktaskno;
    }

    public String getChecktaskno() 
    {
        return checktaskno;
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
    public void setCheckmethod(Long checkmethod) 
    {
        this.checkmethod = checkmethod;
    }

    public Long getCheckmethod() 
    {
        return checkmethod;
    }
    public void setCollecter(Long collecter) 
    {
        this.collecter = collecter;
    }

    public Long getCollecter() 
    {
        return collecter;
    }
    public void setCheckstate(Long checkstate) 
    {
        this.checkstate = checkstate;
    }

    public Long getCheckstate() 
    {
        return checkstate;
    }
    public void setCollectkind(String collectkind) 
    {
        this.collectkind = collectkind;
    }

    public String getCollectkind() 
    {
        return collectkind;
    }
    public void setCheckdate(Date checkdate) 
    {
        this.checkdate = checkdate;
    }

    public Date getCheckdate() 
    {
        return checkdate;
    }
    public void setCheckdesc(String checkdesc) 
    {
        this.checkdesc = checkdesc;
    }

    public String getCheckdesc() 
    {
        return checkdesc;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("checktaskid", checktaskid)
                .append("checktaskno", checktaskno)
                .append("tasksource", tasksource)
                .append("taskcomment", taskcomment)
                .append("storeroomid", storeroomid)
                .append("checkmethod", checkmethod)
                .append("collecter", collecter)
                .append("checkstate", checkstate)
                .append("collectkind", collectkind)
                .append("checkdate", checkdate)
                .append("checkdesc", checkdesc)
                .append("dataversion", dataversion)
                .append("data1", data1)
                .append("data2", data2)
                .append("data3", data3)
                .append("data4", data4)
                .append("data5", data5)
                .append("data6", data6)
                .append("data7", data7)
                .append("data8", data8)
                .append("userId", userId)
                .append("iUserId", iUserId)
                .append("roleoRuserId", roleoRuserId)
                .append("roomTag", roomTag)
                .append("storeroomno", storeroomno)
                .append("storesite", storesite)
                .append("matcode2", matcode2)
                .append("palletno", palletno)
                .append("checkmethod_nm", checkmethod_nm)
                .append("collectdataqty", collectdataqty)
                .append("subinventory_code", subinventory_code)
                .append("status", status)
                .append("co_checkitemid", co_checkitemid)
                .append("storesiteno", storesiteno)
                .append("matcode", matcode)
                .append("billstate", billstate)
                .append("storeroomname", storeroomname)
                .toString();
    }
}

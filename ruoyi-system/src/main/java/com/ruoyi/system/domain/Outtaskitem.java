package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 outtaskitem
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public class Outtaskitem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long outtaskitemid;

    private String matinnercode;
    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outtaskid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outbillid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outorderid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long hintsite;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String hintbatchno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sn;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal hintqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outdesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data1;

    /** 子库 */
    @Excel(name = "子库")
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
    private Long materialid;

    /** 已采数量 */
    @Excel(name = "已采数量")
    private BigDecimal collectedqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long collecter;

    /** ???? 0未接收, 1已接收, 2已上传, 3完工 */
    @Excel(name = "???? 0未接收, 1已接收, 2已上传, 3完工")
    private Long outstate;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectDate;

    /** 占用库存ID */
    @Excel(name = "占用库存ID")
    private Long repertoryid;

    /** 占用数量 */
    @Excel(name = "占用数量")
    private Long occupyqty;

    /** 占用标志0:凭证占用;1:任务分配 */
    @Excel(name = "占用标志0:凭证占用;1:任务分配")
    private Long occupyflag;

    /** ERP子库 */
    @Excel(name = "ERP子库")
    private String subinventoryCode;

    /** 强制完工 1:表示强制; 0:表示正常;2:表示强制完工后台处理完成 */
    @Excel(name = "强制完工 1:表示强制; 0:表示正常;2:表示强制完工后台处理完成")
    private Long hintfinish;

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** 产线编号 */
    @Excel(name = "产线编号")
    private String productline;

    /** 工位 */
    @Excel(name = "工位")
    private String workstation;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String agvstate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String beatflag;

    private String taskcomment;
    private String storeroomno;
    private String orderno;
    private String po_number;
    private String forcesite;
    private String forcebatch;
    private String outtaskno;
    private String storesiteno;
    private String matcode;
    private String matname;
    private String operation;
    private String userId;
    private Long i_collecter;
    private Long t_collecter;
    private String outdate;

    private Long id;
    private String wip_supplement_flag;
    private String schedule_group_name;

    private String batchflag;
    private String delivery_data;
    private String delivery_time;

    private BigDecimal repqty;
    private String palletStatus;

    private String finshFlg;

    private int PageIndex;
    private int PageSize;

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
    private String roomTag;
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

    public Long getOuttaskitemid() {
        return outtaskitemid;
    }

    public void setOuttaskitemid(Long outtaskitemid) {
        this.outtaskitemid = outtaskitemid;
    }

    public Long getOuttaskid() {
        return outtaskid;
    }

    public void setOuttaskid(Long outtaskid) {
        this.outtaskid = outtaskid;
    }

    public Long getOutbillid() {
        return outbillid;
    }

    public void setOutbillid(Long outbillid) {
        this.outbillid = outbillid;
    }

    public Long getOutorderid() {
        return outorderid;
    }

    public void setOutorderid(Long outorderid) {
        this.outorderid = outorderid;
    }

    public Long getHintsite() {
        return hintsite;
    }

    public void setHintsite(Long hintsite) {
        this.hintsite = hintsite;
    }

    public String getHintbatchno() {
        return hintbatchno;
    }

    public void setHintbatchno(String hintbatchno) {
        this.hintbatchno = hintbatchno;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }



    public String getOutdesc() {
        return outdesc;
    }

    public void setOutdesc(String outdesc) {
        this.outdesc = outdesc;
    }

    public Long getDataversion() {
        return dataversion;
    }

    public void setDataversion(Long dataversion) {
        this.dataversion = dataversion;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getData6() {
        return data6;
    }

    public void setData6(String data6) {
        this.data6 = data6;
    }

    public String getData7() {
        return data7;
    }

    public void setData7(String data7) {
        this.data7 = data7;
    }

    public String getData8() {
        return data8;
    }

    public void setData8(String data8) {
        this.data8 = data8;
    }

    public Long getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Long materialid) {
        this.materialid = materialid;
    }

    public BigDecimal getHintqty() {
        return hintqty;
    }

    public void setHintqty(BigDecimal hintqty) {
        this.hintqty = hintqty;
    }

    public BigDecimal getCollectedqty() {
        return collectedqty;
    }

    public void setCollectedqty(BigDecimal collectedqty) {
        this.collectedqty = collectedqty;
    }

    public Long getCollecter() {
        return collecter;
    }

    public void setCollecter(Long collecter) {
        this.collecter = collecter;
    }

    public Long getOutstate() {
        return outstate;
    }

    public void setOutstate(Long outstate) {
        this.outstate = outstate;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    public Long getRepertoryid() {
        return repertoryid;
    }

    public void setRepertoryid(Long repertoryid) {
        this.repertoryid = repertoryid;
    }

    public Long getOccupyqty() {
        return occupyqty;
    }

    public void setOccupyqty(Long occupyqty) {
        this.occupyqty = occupyqty;
    }

    public Long getOccupyflag() {
        return occupyflag;
    }

    public void setOccupyflag(Long occupyflag) {
        this.occupyflag = occupyflag;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public Long getHintfinish() {
        return hintfinish;
    }

    public void setHintfinish(Long hintfinish) {
        this.hintfinish = hintfinish;
    }

    public String getPalletno() {
        return palletno;
    }

    public void setPalletno(String palletno) {
        this.palletno = palletno;
    }

    public String getProductline() {
        return productline;
    }

    public void setProductline(String productline) {
        this.productline = productline;
    }

    public String getWorkstation() {
        return workstation;
    }

    public void setWorkstation(String workstation) {
        this.workstation = workstation;
    }

    public String getAgvstate() {
        return agvstate;
    }

    public void setAgvstate(String agvstate) {
        this.agvstate = agvstate;
    }

    public String getBeatflag() {
        return beatflag;
    }

    public void setBeatflag(String beatflag) {
        this.beatflag = beatflag;
    }

    public String getTaskcomment() {
        return taskcomment;
    }

    public void setTaskcomment(String taskcomment) {
        this.taskcomment = taskcomment;
    }

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

    public String getForcesite() {
        return forcesite;
    }

    public void setForcesite(String forcesite) {
        this.forcesite = forcesite;
    }

    public String getForcebatch() {
        return forcebatch;
    }

    public void setForcebatch(String forcebatch) {
        this.forcebatch = forcebatch;
    }

    public String getOuttaskno() {
        return outtaskno;
    }

    public void setOuttaskno(String outtaskno) {
        this.outtaskno = outtaskno;
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

    public String getOutdate() {
        return outdate;
    }

    public void setOutdate(String outdate) {
        this.outdate = outdate;
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

    public String getBatchflag() {
        return batchflag;
    }

    public void setBatchflag(String batchflag) {
        this.batchflag = batchflag;
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

    public BigDecimal getRepqty() {
        return repqty;
    }

    public void setRepqty(BigDecimal repqty) {
        this.repqty = repqty;
    }

    public String getPalletStatus() {
        return palletStatus;
    }

    public void setPalletStatus(String palletStatus) {
        this.palletStatus = palletStatus;
    }

    public String getMatinnercode() {
        return matinnercode;
    }

    public void setMatinnercode(String matinnercode) {
        this.matinnercode = matinnercode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("outtaskitemid", outtaskitemid)
                .append("matinnercode", matinnercode)
                .append("outtaskid", outtaskid)
                .append("outbillid", outbillid)
                .append("outorderid", outorderid)
                .append("hintsite", hintsite)
                .append("hintbatchno", hintbatchno)
                .append("sn", sn)
                .append("hintqty", hintqty)
                .append("outdesc", outdesc)
                .append("dataversion", dataversion)
                .append("data1", data1)
                .append("data2", data2)
                .append("data3", data3)
                .append("data4", data4)
                .append("data5", data5)
                .append("data6", data6)
                .append("data7", data7)
                .append("data8", data8)
                .append("materialid", materialid)
                .append("collectedqty", collectedqty)
                .append("collecter", collecter)
                .append("outstate", outstate)
                .append("collectDate", collectDate)
                .append("repertoryid", repertoryid)
                .append("occupyqty", occupyqty)
                .append("occupyflag", occupyflag)
                .append("subinventoryCode", subinventoryCode)
                .append("hintfinish", hintfinish)
                .append("palletno", palletno)
                .append("productline", productline)
                .append("workstation", workstation)
                .append("agvstate", agvstate)
                .append("beatflag", beatflag)
                .append("taskcomment", taskcomment)
                .append("storeroomno", storeroomno)
                .append("orderno", orderno)
                .append("po_number", po_number)
                .append("forcesite", forcesite)
                .append("forcebatch", forcebatch)
                .append("outtaskno", outtaskno)
                .append("storesiteno", storesiteno)
                .append("matcode", matcode)
                .append("matname", matname)
                .append("operation", operation)
                .append("userId", userId)
                .append("i_collecter", i_collecter)
                .append("t_collecter", t_collecter)
                .append("outdate", outdate)
                .append("id", id)
                .append("wip_supplement_flag", wip_supplement_flag)
                .append("schedule_group_name", schedule_group_name)
                .append("batchflag", batchflag)
                .append("delivery_data", delivery_data)
                .append("delivery_time", delivery_time)
                .append("repqty", repqty)
                .append("palletStatus", palletStatus)
                .append("roleoRuserId", roleoRuserId)
                .append("roomTag", roomTag)
                .append("transferType", transferType)
                .toString();
    }
}

package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 入库任务明细对象 intaskitem
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public class Intaskitem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long intaskitemid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long intaskid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long inbillid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long materialid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long hintedsite;

    /** 明细表采集人 */
    @Excel(name = "明细表采集人")
    private Long i_collecter;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal qty;

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
    private Long inorderid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String batchno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sn;

    /** 已采数量 */
    @Excel(name = "已采数量")
    private BigDecimal collectedqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long collecter;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long instate;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectDate;

    /** cux_wms_trans_interface的ID */
    @Excel(name = "cux_wms_trans_interface的ID")
    private Long transactionId;

    /** 产线编号 */
    @Excel(name = "产线编号")
    private String productline;

    /** 工位 */
    @Excel(name = "工位")
    private String workstation;

    /** 工位 */
    @Excel(name = "工位")
    private String roomtag;
    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String intaskno;

    /** 库房编码 */
    @Excel(name = "库房编码")
    private String storeroomno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String forcesite;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String forcebatch;

    /** 存放：入库凭证号 */
    @Excel(name = "存放：入库凭证号")
    private String taskcomment;

    private String proofno;
    /** 存放：入库凭证号 */
    @Excel(name = "存放：入库凭证号")
    private String taskfinishflag;

    /** 排序方式 */
    @Excel(name = "排序方式")
    private String sortType;

    /** 排序列 */
    @Excel(name = "排序列")
    private String sortColumn;

    /** 搜索关键字 */
    @Excel(name = "搜索关键字")
    private String searchKey;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String matcode;
    private String  storesiteno;
    private String  subinventoryCode;
    private String  parno;
    private String  protype;
    private String  orderno;
    private String  matname;
    private String  palletstatus;
    private String  matinnercode;

    private Long id;
    private String storeroomname;
    private String operation;
    private Long t_collecter;
    private String indate;
    private String transfertype;

    private int PageIndex;
    private int PageSize;

    private String poNumber;

    private String taskame;

    public String getTaskame() {
        return taskame;
    }

    public void setTaskame(String taskame) {
        this.taskame = taskame;
    }

    public String getProofno() {
        return proofno;
    }

    public void setProofno(String proofno) {
        this.proofno = proofno;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreroomname() {
        return storeroomname;
    }

    public void setStoreroomname(String storeroomname) {
        this.storeroomname = storeroomname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Long getT_collecter() {
        return t_collecter;
    }

    public void setT_collecter(Long t_collecter) {
        this.t_collecter = t_collecter;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getTransfertype() {
        return transfertype;
    }

    public void setTransfertype(String transfertype) {
        this.transfertype = transfertype;
    }

    public String getStoresiteno() {
        return storesiteno;
    }

    public void setStoresiteno(String storesiteno) {
        this.storesiteno = storesiteno;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getParno() {
        return parno;
    }

    public void setParno(String parno) {
        this.parno = parno;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getMatname() {
        return matname;
    }

    public void setMatname(String matname) {
        this.matname = matname;
    }

    public String getPalletstatus() {
        return palletstatus;
    }

    public void setPalletstatus(String palletstatus) {
        this.palletstatus = palletstatus;
    }

    public String getMatinnercode() {
        return matinnercode;
    }

    public void setMatinnercode(String matinnercode) {
        this.matinnercode = matinnercode;
    }

    public Long getI_collecter() {
        return i_collecter;
    }

    public void setI_collecter(Long i_collecter) {
        this.i_collecter = i_collecter;
    }

    public String getMatcode() {
        return matcode;
    }

    public void setMatcode(String matcode) {
        this.matcode = matcode;
    }

    public String getRoomtag() {
        return roomtag;
    }

    public void setRoomtag(String roomtag) {
        this.roomtag = roomtag;
    }

    public String getIntaskno() {
        return intaskno;
    }

    public void setIntaskno(String intaskno) {
        this.intaskno = intaskno;
    }

    public String getStoreroomno() {
        return storeroomno;
    }

    public void setStoreroomno(String storeroomno) {
        this.storeroomno = storeroomno;
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

    public String getTaskcomment() {
        return taskcomment;
    }

    public void setTaskcomment(String taskcomment) {
        this.taskcomment = taskcomment;
    }

    public String getTaskfinishflag() {
        return taskfinishflag;
    }

    public void setTaskfinishflag(String taskfinishflag) {
        this.taskfinishflag = taskfinishflag;
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

    public void setIntaskitemid(Long intaskitemid)
    {
        this.intaskitemid = intaskitemid;
    }

    public Long getIntaskitemid() 
    {
        return intaskitemid;
    }
    public void setIntaskid(Long intaskid) 
    {
        this.intaskid = intaskid;
    }

    public Long getIntaskid() 
    {
        return intaskid;
    }
    public void setInbillid(Long inbillid) 
    {
        this.inbillid = inbillid;
    }

    public Long getInbillid() 
    {
        return inbillid;
    }
    public void setMaterialid(Long materialid) 
    {
        this.materialid = materialid;
    }

    public Long getMaterialid() 
    {
        return materialid;
    }
    public void setHintedsite(Long hintedsite) 
    {
        this.hintedsite = hintedsite;
    }

    public Long getHintedsite() 
    {
        return hintedsite;
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
    public void setInorderid(Long inorderid) 
    {
        this.inorderid = inorderid;
    }

    public Long getInorderid() 
    {
        return inorderid;
    }
    public void setBatchno(String batchno) 
    {
        this.batchno = batchno;
    }

    public String getBatchno() 
    {
        return batchno;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getCollectedqty() {
        return collectedqty;
    }

    public void setCollectedqty(BigDecimal collectedqty) {
        this.collectedqty = collectedqty;
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
    public void setCollectDate(Date collectDate) 
    {
        this.collectDate = collectDate;
    }

    public Date getCollectDate() 
    {
        return collectDate;
    }
    public void setTransactionId(Long transactionId) 
    {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() 
    {
        return transactionId;
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
    public void setPalletno(String palletno) 
    {
        this.palletno = palletno;
    }

    public String getPalletno() 
    {
        return palletno;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("intaskitemid", intaskitemid)
                .append("intaskid", intaskid)
                .append("inbillid", inbillid)
                .append("materialid", materialid)
                .append("hintedsite", hintedsite)
                .append("i_collecter", i_collecter)
                .append("qty", qty)
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
                .append("inorderid", inorderid)
                .append("batchno", batchno)
                .append("sn", sn)
                .append("collectedqty", collectedqty)
                .append("collecter", collecter)
                .append("instate", instate)
                .append("collectDate", collectDate)
                .append("transactionId", transactionId)
                .append("productline", productline)
                .append("workstation", workstation)
                .append("roomtag", roomtag)
                .append("palletno", palletno)
                .append("intaskno", intaskno)
                .append("storeroomno", storeroomno)
                .append("forcesite", forcesite)
                .append("forcebatch", forcebatch)
                .append("taskcomment", taskcomment)
                .append("taskfinishflag", taskfinishflag)
                .append("sortType", sortType)
                .append("sortColumn", sortColumn)
                .append("searchKey", searchKey)
                .append("userId", userId)
                .append("matcode", matcode)
                .append("storesiteno", storesiteno)
                .append("subinventoryCode", subinventoryCode)
                .append("parno", parno)
                .append("protype", protype)
                .append("orderno", orderno)
                .append("matname", matname)
                .append("palletstatus", palletstatus)
                .append("matinnercode", matinnercode)
                .append("id", id)
                .append("storeroomname", storeroomname)
                .append("operation", operation)
                .append("t_collecter", t_collecter)
                .append("indate", indate)
                .append("transfertype", transfertype)
                .toString();
    }
}

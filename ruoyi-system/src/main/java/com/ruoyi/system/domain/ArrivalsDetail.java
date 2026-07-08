package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 到货单明细对象 arrivals_detail
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public class ArrivalsDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long arrivalsDetailid;

    /** 主表外键 */
    @Excel(name = "主表外键")
    private Long arrivalsBillid;

    /** 物料ID */
    @Excel(name = "物料ID")
    private Long materialid;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long partnerid;

    /** 物料规格 */
    @Excel(name = "物料规格")
    private String matmodel;

    /** 物料批次号 */
    @Excel(name = "物料批次号")
    private String batchno;

    /** 物料序列号 */
    @Excel(name = "物料序列号")
    private String sn;

    /** 到货数量 */
    @Excel(name = "到货数量")
    private BigDecimal qty;

    /** 是否已经在入库计划中（即：是否已被包含在入库凭证中）
0：否
1：是 */
    @Excel(name = "是否已经在入库计划中", readConverterExp = "即=：是否已被包含在入库凭证中")
    private String isin;

    /** 描述 */
    @Excel(name = "描述")
    private String arrvialdesc;

    /** 是否检验     1：是
0：否 */
    @Excel(name = "是否检验     1：是0：否")
    private String ischeck;

    /** ERP的HEADERID */
    @Excel(name = "ERP的HEADERID")
    private String erpheaderid;

    /** ERP的TRANSACTION_ID */
    @Excel(name = "ERP的TRANSACTION_ID")
    private Long orderItemTransactionId;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    /** 生产日期 */
    @Excel(name = "生产日期")
    private String data1;

    /** 保质期天数 */
    @Excel(name = "保质期天数")
    private String data2;

    /** PDA采集人 */
    @Excel(name = "PDA采集人")
    private String data3;

    /** 采集时间戳 */
    @Excel(name = "采集时间戳")
    private String data4;

    /** 是否匹配 */
    @Excel(name = "是否匹配")
    private String data5;

    /** - */
    @Excel(name = "-")
    private String data6;

    /** - */
    @Excel(name = "-")
    private String data7;

    /** data(*)字段含义说明 */
    @Excel(name = "data(*)字段含义说明")
    private String data8;

    /** 正品数 */
    @Excel(name = "正品数")
    private String goodqty;

    /** 开始序列号 */
    @Excel(name = "开始序列号")
    private String startsn;

    /** 结束序列号 */
    @Excel(name = "结束序列号")
    private String endsn;

    /** ERP的SOURCE_HEADER_ID */
    @Excel(name = "ERP的SOURCE_HEADER_ID")
    private Long sourceHeaderId;

    /** ERP的ERP_ORDER_TYPE */
    @Excel(name = "ERP的ERP_ORDER_TYPE")
    private String erpOrderType;

    /** ERP的SOURCE_LINE_ID */
    @Excel(name = "ERP的SOURCE_LINE_ID")
    private Long sourceLineId;

    /** ERP的TRANSACTION_TYPE */
    @Excel(name = "ERP的TRANSACTION_TYPE")
    private String transactionType;

    /** ERP的拥有方ID */
    @Excel(name = "ERP的拥有方ID")
    private String owningOrganizationId;

    /** ERP的拥有方名称 */
    @Excel(name = "ERP的拥有方名称")
    private String owningOrganizationName;

    /** ERP子库信息 */
    @Excel(name = "ERP子库信息")
    private String subinventoryCode;

    /** 库房ID */
    @Excel(name = "库房ID")
    private Long storeroomid;

    /** 异常数量 */
    @Excel(name = "异常数量")
    private Long exceptQty;

    /** 工单ID */
    @Excel(name = "工单ID")
    private Long wipEntityId;

    /** 工单号 */
    @Excel(name = "工单号")
    private String wipEntityName;

    /** 产线编号 */
    @Excel(name = "产线编号")
    private String productline;

    /** 工位 */
    @Excel(name = "工位")
    private String workstation;

    /** 项目号 */
    @Excel(name = "项目号")
    private String projectNum;

    /** 采购订单类型 */
    @Excel(name = "采购订单类型")
    private String poType;

    /** --黄加,未使用 */
    @Excel(name = "--黄加,未使用")
    private Long djqty;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String matcode;

    /** 物料控制类型 */
    @Excel(name = "物料控制类型")
    private String matcodecontrol;

    /** -- */
    @Excel(name = "--")
    private String matinnercode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String matname;

    /** 库房编码 */
    @Excel(name = "库房编码")
    private String storeroomno;

    /** 库房名称 */
    @Excel(name = "库房名称")
    private String storeroomname;

    /** 收货类型 */
    @Excel(name = "收货类型")
    private String arrivaltype;

    /** 装箱单号 */
    @Excel(name = "装箱单号")
    private String orderno;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivaldate;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String vendorsitecode;

    /** 采购订单号 */
    @Excel(name = "采购订单号")
    private String poNumber;

    /** 装箱单号 */
    @Excel(name = "到货单号")
    private String arrivalsBillno;

    /** 用户ID */
    @Excel(name = "到货单号")
    private Long userId;


    /** 搜索内容 */
    @Excel(name = "搜索内容")
    private String searchKey;

    public String getSearchKey() {
        return searchKey;
    }
    /** 排序方式 */
    @Excel(name = "排序方式")
    private String sortType;

    /** 排序列 */
    @Excel(name = "排序列")
    private String sortColumn;

    /** 工厂 */
    @Excel(name = "工厂")
    private String werks;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String parno;

    /** 供应商民称 */
    @Excel(name = "供应商民称")
    private String parname;

    /** SAP行号 */
    @Excel(name = "SAP行号")
    private String posnr;

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

    public String getPosnr() {
        return posnr;
    }

    public void setPosnr(String posnr) {
        this.posnr = posnr;
    }

    public String getParno() {
        return parno;
    }

    public void setParno(String parno) {
        this.parno = parno;
    }

    public String getParname() {
        return parname;
    }

    public void setParname(String parname) {
        this.parname = parname;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
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

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public void setArrivalsDetailid(Long arrivalsDetailid) 
    {
        this.arrivalsDetailid = arrivalsDetailid;
    }

    public Long getArrivalsDetailid() 
    {
        return arrivalsDetailid;
    }
    public void setArrivalsBillid(Long arrivalsBillid) 
    {
        this.arrivalsBillid = arrivalsBillid;
    }

    public Long getArrivalsBillid() 
    {
        return arrivalsBillid;
    }
    public void setMaterialid(Long materialid) 
    {
        this.materialid = materialid;
    }

    public Long getMaterialid() 
    {
        return materialid;
    }
    public void setPartnerid(Long partnerid) 
    {
        this.partnerid = partnerid;
    }

    public Long getPartnerid() 
    {
        return partnerid;
    }
    public void setMatmodel(String matmodel) 
    {
        this.matmodel = matmodel;
    }

    public String getMatmodel() 
    {
        return matmodel;
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

    public void setIsin(String isin)
    {
        this.isin = isin;
    }

    public String getIsin() 
    {
        return isin;
    }
    public void setArrvialdesc(String arrvialdesc) 
    {
        this.arrvialdesc = arrvialdesc;
    }

    public String getArrvialdesc() 
    {
        return arrvialdesc;
    }
    public void setIscheck(String ischeck) 
    {
        this.ischeck = ischeck;
    }

    public String getIscheck() 
    {
        return ischeck;
    }
    public void setErpheaderid(String erpheaderid) 
    {
        this.erpheaderid = erpheaderid;
    }

    public String getErpheaderid() 
    {
        return erpheaderid;
    }
    public void setOrderItemTransactionId(Long orderItemTransactionId) 
    {
        this.orderItemTransactionId = orderItemTransactionId;
    }

    public Long getOrderItemTransactionId() 
    {
        return orderItemTransactionId;
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
    public void setGoodqty(String goodqty) 
    {
        this.goodqty = goodqty;
    }

    public String getGoodqty() 
    {
        return goodqty;
    }
    public void setStartsn(String startsn) 
    {
        this.startsn = startsn;
    }

    public String getStartsn() 
    {
        return startsn;
    }
    public void setEndsn(String endsn) 
    {
        this.endsn = endsn;
    }

    public String getEndsn() 
    {
        return endsn;
    }
    public void setSourceHeaderId(Long sourceHeaderId) 
    {
        this.sourceHeaderId = sourceHeaderId;
    }

    public Long getSourceHeaderId() 
    {
        return sourceHeaderId;
    }
    public void setErpOrderType(String erpOrderType) 
    {
        this.erpOrderType = erpOrderType;
    }

    public String getErpOrderType() 
    {
        return erpOrderType;
    }
    public void setSourceLineId(Long sourceLineId) 
    {
        this.sourceLineId = sourceLineId;
    }

    public Long getSourceLineId() 
    {
        return sourceLineId;
    }
    public void setTransactionType(String transactionType) 
    {
        this.transactionType = transactionType;
    }

    public String getTransactionType() 
    {
        return transactionType;
    }
    public void setOwningOrganizationId(String owningOrganizationId) 
    {
        this.owningOrganizationId = owningOrganizationId;
    }

    public String getOwningOrganizationId() 
    {
        return owningOrganizationId;
    }
    public void setOwningOrganizationName(String owningOrganizationName) 
    {
        this.owningOrganizationName = owningOrganizationName;
    }

    public String getOwningOrganizationName() 
    {
        return owningOrganizationName;
    }
    public void setSubinventoryCode(String subinventoryCode) 
    {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode() 
    {
        return subinventoryCode;
    }
    public void setStoreroomid(Long storeroomid) 
    {
        this.storeroomid = storeroomid;
    }

    public Long getStoreroomid() 
    {
        return storeroomid;
    }
    public void setExceptQty(Long exceptQty) 
    {
        this.exceptQty = exceptQty;
    }

    public Long getExceptQty() 
    {
        return exceptQty;
    }
    public void setWipEntityId(Long wipEntityId) 
    {
        this.wipEntityId = wipEntityId;
    }

    public Long getWipEntityId() 
    {
        return wipEntityId;
    }
    public void setWipEntityName(String wipEntityName) 
    {
        this.wipEntityName = wipEntityName;
    }

    public String getWipEntityName() 
    {
        return wipEntityName;
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
    public void setProjectNum(String projectNum) 
    {
        this.projectNum = projectNum;
    }

    public String getProjectNum() 
    {
        return projectNum;
    }
    public void setPoType(String poType) 
    {
        this.poType = poType;
    }

    public String getPoType() 
    {
        return poType;
    }
    public void setDjqty(Long djqty) 
    {
        this.djqty = djqty;
    }

    public Long getDjqty() 
    {
        return djqty;
    }

    public String getMatcode() {
        return matcode;
    }

    public void setMatcode(String matcode) {
        this.matcode = matcode;
    }

    public String getMatcodecontrol() {
        return matcodecontrol;
    }

    public void setMatcodecontrol(String matcodecontrol) {
        this.matcodecontrol = matcodecontrol;
    }

    public String getMatinnercode() {
        return matinnercode;
    }

    public void setMatinnercode(String matinnercode) {
        this.matinnercode = matinnercode;
    }

    public String getMatname() {
        return matname;
    }

    public void setMatname(String matname) {
        this.matname = matname;
    }

    public String getStoreroomno() {
        return storeroomno;
    }

    public void setStoreroomno(String storeroomno) {
        this.storeroomno = storeroomno;
    }

    public String getStoreroomname() {
        return storeroomname;
    }

    public void setStoreroomname(String storeroomname) {
        this.storeroomname = storeroomname;
    }

    public String getArrivaltype() {
        return arrivaltype;
    }

    public void setArrivaltype(String arrivaltype) {
        this.arrivaltype = arrivaltype;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Date getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(Date arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public String getVendorsitecode() {
        return vendorsitecode;
    }

    public void setVendorsitecode(String vendorsitecode) {
        this.vendorsitecode = vendorsitecode;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getArrivalsBillno() {
        return arrivalsBillno;
    }

    public void setArrivalsBillno(String arrivalsBillno) {
        this.arrivalsBillno = arrivalsBillno;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("arrivalsDetailid", arrivalsDetailid)
                .append("arrivalsBillid", arrivalsBillid)
                .append("materialid", materialid)
                .append("partnerid", partnerid)
                .append("matmodel", matmodel)
                .append("batchno", batchno)
                .append("sn", sn)
                .append("qty", qty)
                .append("isin", isin)
                .append("arrvialdesc", arrvialdesc)
                .append("ischeck", ischeck)
                .append("erpheaderid", erpheaderid)
                .append("orderItemTransactionId", orderItemTransactionId)
                .append("dataversion", dataversion)
                .append("data1", data1)
                .append("data2", data2)
                .append("data3", data3)
                .append("data4", data4)
                .append("data5", data5)
                .append("data6", data6)
                .append("data7", data7)
                .append("data8", data8)
                .append("goodqty", goodqty)
                .append("startsn", startsn)
                .append("endsn", endsn)
                .append("sourceHeaderId", sourceHeaderId)
                .append("erpOrderType", erpOrderType)
                .append("sourceLineId", sourceLineId)
                .append("transactionType", transactionType)
                .append("owningOrganizationId", owningOrganizationId)
                .append("owningOrganizationName", owningOrganizationName)
                .append("subinventoryCode", subinventoryCode)
                .append("storeroomid", storeroomid)
                .append("exceptQty", exceptQty)
                .append("wipEntityId", wipEntityId)
                .append("wipEntityName", wipEntityName)
                .append("productline", productline)
                .append("workstation", workstation)
                .append("projectNum", projectNum)
                .append("poType", poType)
                .append("djqty", djqty)
                .append("matcode", matcode)
                .append("matcodecontrol", matcodecontrol)
                .append("matinnercode", matinnercode)
                .append("matname", matname)
                .append("storeroomno", storeroomno)
                .append("storeroomname", storeroomname)
                .append("arrivaltype", arrivaltype)
                .append("orderno", orderno)
                .append("arrivaldate", arrivaldate)
                .append("vendorsitecode", vendorsitecode)
                .append("poNumber", poNumber)
                .append("arrivalsBillno", arrivalsBillno)
                .append("userId", userId)
                .append("werks", werks)
                .append("parno", parno)
                .append("parname", parname)
                .toString();
    }
}

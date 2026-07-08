package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 到货单对象 arrivals_bill
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public class ArrivalsBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 到货单主键 */
    private Long arrivalsBillid;

    /** 到货单号(时间+序号) */
    @Excel(name = "到货单号(时间+序号)")
    private String arrivalsBillno;

    /** 入库单号 */
    @Excel(name = "入库单号")
    private String orderno;

    /** 1  内部销售(天诚出货)
2  销售出库(成品)
3  销售出库(备件)
4  工单发料-拉式
5  工单发料-推式
6  杂项出库-搬运单
7  杂项出库-账户别名
8  采购退货
9  采购接收-订单
10  采购接收-装箱单
11  外协费用
12  销售退货
13  完工入库
14  杂项入库-账户别名
15  内部销售(金风出货)
16  工单退料入库
17  调拨(业务发起)
18  调拨(仓储发起)
 */
    private String arrivaltype;

    /** 0：新建
1：收货
2：审核 */
    @Excel(name = "0：新建1：收货2：审核")
    private Long arrivalstate;

    /** 收货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivaldate;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long partnerid;

    /** 发货地址 */
    @Excel(name = "发货地址")
    private String sendaddress;

    /** 收货人 */
    @Excel(name = "收货人")
    private Long acceptor;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String acceptaddress;

    /** 到货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdate;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long creator;

    /** 签收日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签收日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditdate;

    /** 签收人 */
    @Excel(name = "签收人")
    private Long auditor;

    /** 收货人电话 */
    @Excel(name = "收货人电话")
    private String acceptorTel;

    /** 发货人电话 */
    @Excel(name = "发货人电话")
    private String senderTel;

    /** 0：签字/盖章
1：其他 */
    @Excel(name = "0：签字/盖章1：其他")
    private Long confirmmethod;

    /** 供应商地址 */
    @Excel(name = "供应商地址")
    private String partnerAddr;

    /** 供应商传真 */
    @Excel(name = "供应商传真")
    private String partnerFax;

    /** 描述 */
    @Excel(name = "描述")
    private String arrivaldesc;

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

    /** PDA采集任务领取人,逗号分隔 */
    @Excel(name = "PDA采集任务领取人,逗号分隔")
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

    /** cux_wms_order_header/line_interface.ORDER_TRANSACTION_ID */
    @Excel(name = "cux_wms_order_header/line_interface.ORDER_TRANSACTION_ID")
    private String orderTransactionId;

    /** 以ERP定义为准 */
    @Excel(name = "以ERP定义为准")
    private String transactionType;

    /** 供应商地点 */
    @Excel(name = "供应商地点")
    private String vendorsitecode;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String vendornumber;

    /** 来源单号 */
    @Excel(name = "来源单号")
    private String poNumber;

    /** --黄加,未使用 */
    @Excel(name = "--黄加,未使用")
    private String djstatus;

    /** 排序方式 */
    @Excel(name = "排序方式")
    private String sortType;

    /** 排序列 */
    @Excel(name = "排序列")
    private String sortColumn;

    /** 搜索关键字 */
    @Excel(name = "搜索关键字")
    private String searchKey;

    /** 查询用户id */
    @Excel(name = "查询用户id")
    private Long userId;

    /** 工厂 */
    @Excel(name = "工厂")
    private String werks;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
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

    public void setArrivalsBillid(Long arrivalsBillid)
    {
        this.arrivalsBillid = arrivalsBillid;
    }

    public Long getArrivalsBillid() 
    {
        return arrivalsBillid;
    }
    public void setArrivalsBillno(String arrivalsBillno) 
    {
        this.arrivalsBillno = arrivalsBillno;
    }

    public String getArrivalsBillno() 
    {
        return arrivalsBillno;
    }
    public void setOrderno(String orderno) 
    {
        this.orderno = orderno;
    }

    public String getOrderno() 
    {
        return orderno;
    }
    public void setArrivaltype(String arrivaltype) 
    {
        this.arrivaltype = arrivaltype;
    }

    public String getArrivaltype() 
    {
        return arrivaltype;
    }
    public void setArrivalstate(Long arrivalstate) 
    {
        this.arrivalstate = arrivalstate;
    }

    public Long getArrivalstate() 
    {
        return arrivalstate;
    }
    public void setArrivaldate(Date arrivaldate) 
    {
        this.arrivaldate = arrivaldate;
    }

    public Date getArrivaldate() 
    {
        return arrivaldate;
    }
    public void setPartnerid(Long partnerid) 
    {
        this.partnerid = partnerid;
    }

    public Long getPartnerid() 
    {
        return partnerid;
    }
    public void setSendaddress(String sendaddress) 
    {
        this.sendaddress = sendaddress;
    }

    public String getSendaddress() 
    {
        return sendaddress;
    }
    public void setAcceptor(Long acceptor) 
    {
        this.acceptor = acceptor;
    }

    public Long getAcceptor() 
    {
        return acceptor;
    }
    public void setAcceptaddress(String acceptaddress) 
    {
        this.acceptaddress = acceptaddress;
    }

    public String getAcceptaddress() 
    {
        return acceptaddress;
    }
    public void setCreatedate(Date createdate) 
    {
        this.createdate = createdate;
    }

    public Date getCreatedate() 
    {
        return createdate;
    }
    public void setCreator(Long creator) 
    {
        this.creator = creator;
    }

    public Long getCreator() 
    {
        return creator;
    }
    public void setAuditdate(Date auditdate) 
    {
        this.auditdate = auditdate;
    }

    public Date getAuditdate() 
    {
        return auditdate;
    }
    public void setAuditor(Long auditor) 
    {
        this.auditor = auditor;
    }

    public Long getAuditor() 
    {
        return auditor;
    }
    public void setAcceptorTel(String acceptorTel) 
    {
        this.acceptorTel = acceptorTel;
    }

    public String getAcceptorTel() 
    {
        return acceptorTel;
    }
    public void setSenderTel(String senderTel) 
    {
        this.senderTel = senderTel;
    }

    public String getSenderTel() 
    {
        return senderTel;
    }
    public void setConfirmmethod(Long confirmmethod) 
    {
        this.confirmmethod = confirmmethod;
    }

    public Long getConfirmmethod() 
    {
        return confirmmethod;
    }
    public void setPartnerAddr(String partnerAddr) 
    {
        this.partnerAddr = partnerAddr;
    }

    public String getPartnerAddr() 
    {
        return partnerAddr;
    }
    public void setPartnerFax(String partnerFax) 
    {
        this.partnerFax = partnerFax;
    }

    public String getPartnerFax() 
    {
        return partnerFax;
    }
    public void setArrivaldesc(String arrivaldesc) 
    {
        this.arrivaldesc = arrivaldesc;
    }

    public String getArrivaldesc() 
    {
        return arrivaldesc;
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
    public void setOrderTransactionId(String orderTransactionId) 
    {
        this.orderTransactionId = orderTransactionId;
    }

    public String getOrderTransactionId() 
    {
        return orderTransactionId;
    }
    public void setTransactionType(String transactionType) 
    {
        this.transactionType = transactionType;
    }

    public String getTransactionType() 
    {
        return transactionType;
    }
    public void setVendorsitecode(String vendorsitecode) 
    {
        this.vendorsitecode = vendorsitecode;
    }

    public String getVendorsitecode() 
    {
        return vendorsitecode;
    }
    public void setVendornumber(String vendornumber) 
    {
        this.vendornumber = vendornumber;
    }

    public String getVendornumber() 
    {
        return vendornumber;
    }
    public void setPoNumber(String poNumber) 
    {
        this.poNumber = poNumber;
    }

    public String getPoNumber() 
    {
        return poNumber;
    }
    public void setDjstatus(String djstatus) 
    {
        this.djstatus = djstatus;
    }

    public String getDjstatus() 
    {
        return djstatus;
    }
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getSortType() {
        return sortType;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public String getSearchKey() {
        return searchKey;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("arrivalsBillid", getArrivalsBillid())
            .append("arrivalsBillno", getArrivalsBillno())
            .append("orderno", getOrderno())
            .append("arrivaltype", getArrivaltype())
            .append("arrivalstate", getArrivalstate())
            .append("arrivaldate", getArrivaldate())
            .append("partnerid", getPartnerid())
            .append("sendaddress", getSendaddress())
            .append("acceptor", getAcceptor())
            .append("acceptaddress", getAcceptaddress())
            .append("createdate", getCreatedate())
            .append("creator", getCreator())
            .append("auditdate", getAuditdate())
            .append("auditor", getAuditor())
            .append("acceptorTel", getAcceptorTel())
            .append("senderTel", getSenderTel())
            .append("confirmmethod", getConfirmmethod())
            .append("partnerAddr", getPartnerAddr())
            .append("partnerFax", getPartnerFax())
            .append("arrivaldesc", getArrivaldesc())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("data5", getData5())
            .append("data6", getData6())
            .append("data7", getData7())
            .append("data8", getData8())
            .append("orderTransactionId", getOrderTransactionId())
            .append("transactionType", getTransactionType())
            .append("vendorsitecode", getVendorsitecode())
            .append("vendornumber", getVendornumber())
            .append("poNumber", getPoNumber())
            .append("djstatus", getDjstatus())
            .append("sortType", getSortType())
            .append("sortColumn", getSortColumn())
            .append("searchKey", getSearchKey())
            .append("userId", getUserId())
            .append("werks", getWerks())
            .append("parname", getParname())
            .toString();
    }
}

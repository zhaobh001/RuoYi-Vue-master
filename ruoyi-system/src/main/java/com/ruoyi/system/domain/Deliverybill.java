package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 deliverybill
 * 
 * @author ruoyi
 * @date 2026-07-10
 */
public class Deliverybill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long inbillid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long inproofid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String inbillno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long arrivalbillid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long sourceid;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createtime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long createor;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long materialid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String batchno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sn;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long siteno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long taskqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long finishqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long supplierid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String transportinfo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long billstate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String billdesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long weight;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long volume;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String startsn;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String endsn;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String orderItemTransactionId;

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
    private String data9;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data10;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sourceHeaderId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String erpOrderType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sourceLineId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String transactionType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String subinventoryCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String owningOrganizationId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String owningOrganizationName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String repOrg;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data11;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data12;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long collectEmpid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date collectDate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long hintfinish;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String hintdesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long incheckdetailid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long incheckbillid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long arrivalsDetailid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String orderTransactionId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long palletnum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long wipEntityId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String wipEntityName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String primaryItemDesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String scheduleGroupName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String productline;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String workstation;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String palletno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String projectNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String poProjectNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outtaskitemid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outtaskid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outbillid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outproofid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String hintfinishtor;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String supplier;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String responsible;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String nonconforming;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String disposal;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ipqcno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String transno;

    public void setInbillid(Long inbillid) 
    {
        this.inbillid = inbillid;
    }

    public Long getInbillid() 
    {
        return inbillid;
    }
    public void setInproofid(Long inproofid) 
    {
        this.inproofid = inproofid;
    }

    public Long getInproofid() 
    {
        return inproofid;
    }
    public void setInbillno(String inbillno) 
    {
        this.inbillno = inbillno;
    }

    public String getInbillno() 
    {
        return inbillno;
    }
    public void setArrivalbillid(Long arrivalbillid) 
    {
        this.arrivalbillid = arrivalbillid;
    }

    public Long getArrivalbillid() 
    {
        return arrivalbillid;
    }
    public void setSourceid(Long sourceid) 
    {
        this.sourceid = sourceid;
    }

    public Long getSourceid() 
    {
        return sourceid;
    }
    public void setCreateor(Long createor)
    {
        this.createor = createor;
    }

    public Long getCreateor() 
    {
        return createor;
    }
    public void setMaterialid(Long materialid) 
    {
        this.materialid = materialid;
    }

    public Long getMaterialid() 
    {
        return materialid;
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
    public void setSiteno(Long siteno) 
    {
        this.siteno = siteno;
    }

    public Long getSiteno() 
    {
        return siteno;
    }
    public void setTaskqty(Long taskqty) 
    {
        this.taskqty = taskqty;
    }

    public Long getTaskqty() 
    {
        return taskqty;
    }
    public void setFinishqty(Long finishqty) 
    {
        this.finishqty = finishqty;
    }

    public Long getFinishqty() 
    {
        return finishqty;
    }
    public void setSupplierid(Long supplierid) 
    {
        this.supplierid = supplierid;
    }

    public Long getSupplierid() 
    {
        return supplierid;
    }
    public void setTransportinfo(String transportinfo) 
    {
        this.transportinfo = transportinfo;
    }

    public String getTransportinfo() 
    {
        return transportinfo;
    }
    public void setBillstate(Long billstate) 
    {
        this.billstate = billstate;
    }

    public Long getBillstate() 
    {
        return billstate;
    }
    public void setBilldesc(String billdesc) 
    {
        this.billdesc = billdesc;
    }

    public String getBilldesc() 
    {
        return billdesc;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }
    public void setVolume(Long volume) 
    {
        this.volume = volume;
    }

    public Long getVolume() 
    {
        return volume;
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
    public void setOrderItemTransactionId(String orderItemTransactionId) 
    {
        this.orderItemTransactionId = orderItemTransactionId;
    }

    public String getOrderItemTransactionId() 
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
    public void setData9(String data9) 
    {
        this.data9 = data9;
    }

    public String getData9() 
    {
        return data9;
    }
    public void setData10(String data10) 
    {
        this.data10 = data10;
    }

    public String getData10() 
    {
        return data10;
    }
    public void setSourceHeaderId(String sourceHeaderId) 
    {
        this.sourceHeaderId = sourceHeaderId;
    }

    public String getSourceHeaderId() 
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
    public void setSourceLineId(String sourceLineId) 
    {
        this.sourceLineId = sourceLineId;
    }

    public String getSourceLineId() 
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
    public void setSubinventoryCode(String subinventoryCode) 
    {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode() 
    {
        return subinventoryCode;
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
    public void setRepOrg(String repOrg) 
    {
        this.repOrg = repOrg;
    }

    public String getRepOrg() 
    {
        return repOrg;
    }
    public void setData11(String data11) 
    {
        this.data11 = data11;
    }

    public String getData11() 
    {
        return data11;
    }
    public void setData12(String data12) 
    {
        this.data12 = data12;
    }

    public String getData12() 
    {
        return data12;
    }
    public void setCollectEmpid(Long collectEmpid) 
    {
        this.collectEmpid = collectEmpid;
    }

    public Long getCollectEmpid() 
    {
        return collectEmpid;
    }
    public void setCollectDate(Date collectDate) 
    {
        this.collectDate = collectDate;
    }

    public Date getCollectDate() 
    {
        return collectDate;
    }
    public void setHintfinish(Long hintfinish) 
    {
        this.hintfinish = hintfinish;
    }

    public Long getHintfinish() 
    {
        return hintfinish;
    }
    public void setHintdesc(String hintdesc) 
    {
        this.hintdesc = hintdesc;
    }

    public String getHintdesc() 
    {
        return hintdesc;
    }
    public void setIncheckdetailid(Long incheckdetailid) 
    {
        this.incheckdetailid = incheckdetailid;
    }

    public Long getIncheckdetailid() 
    {
        return incheckdetailid;
    }
    public void setIncheckbillid(Long incheckbillid) 
    {
        this.incheckbillid = incheckbillid;
    }

    public Long getIncheckbillid() 
    {
        return incheckbillid;
    }
    public void setArrivalsDetailid(Long arrivalsDetailid) 
    {
        this.arrivalsDetailid = arrivalsDetailid;
    }

    public Long getArrivalsDetailid() 
    {
        return arrivalsDetailid;
    }
    public void setOrderTransactionId(String orderTransactionId) 
    {
        this.orderTransactionId = orderTransactionId;
    }

    public String getOrderTransactionId() 
    {
        return orderTransactionId;
    }
    public void setPalletnum(Long palletnum) 
    {
        this.palletnum = palletnum;
    }

    public Long getPalletnum() 
    {
        return palletnum;
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
    public void setPrimaryItemDesc(String primaryItemDesc) 
    {
        this.primaryItemDesc = primaryItemDesc;
    }

    public String getPrimaryItemDesc() 
    {
        return primaryItemDesc;
    }
    public void setScheduleGroupName(String scheduleGroupName) 
    {
        this.scheduleGroupName = scheduleGroupName;
    }

    public String getScheduleGroupName() 
    {
        return scheduleGroupName;
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
    public void setProjectNum(String projectNum) 
    {
        this.projectNum = projectNum;
    }

    public String getProjectNum() 
    {
        return projectNum;
    }
    public void setPoProjectNum(String poProjectNum) 
    {
        this.poProjectNum = poProjectNum;
    }

    public String getPoProjectNum() 
    {
        return poProjectNum;
    }
    public void setOuttaskitemid(Long outtaskitemid) 
    {
        this.outtaskitemid = outtaskitemid;
    }

    public Long getOuttaskitemid() 
    {
        return outtaskitemid;
    }
    public void setOuttaskid(Long outtaskid) 
    {
        this.outtaskid = outtaskid;
    }

    public Long getOuttaskid() 
    {
        return outtaskid;
    }
    public void setOutbillid(Long outbillid) 
    {
        this.outbillid = outbillid;
    }

    public Long getOutbillid() 
    {
        return outbillid;
    }
    public void setOutproofid(Long outproofid) 
    {
        this.outproofid = outproofid;
    }

    public Long getOutproofid() 
    {
        return outproofid;
    }
    public void setHintfinishtor(String hintfinishtor) 
    {
        this.hintfinishtor = hintfinishtor;
    }

    public String getHintfinishtor() 
    {
        return hintfinishtor;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }
    public void setResponsible(String responsible) 
    {
        this.responsible = responsible;
    }

    public String getResponsible() 
    {
        return responsible;
    }
    public void setNonconforming(String nonconforming) 
    {
        this.nonconforming = nonconforming;
    }

    public String getNonconforming() 
    {
        return nonconforming;
    }
    public void setDisposal(String disposal) 
    {
        this.disposal = disposal;
    }

    public String getDisposal() 
    {
        return disposal;
    }
    public void setIpqcno(String ipqcno) 
    {
        this.ipqcno = ipqcno;
    }

    public String getIpqcno() 
    {
        return ipqcno;
    }
    public void setTransno(String transno) 
    {
        this.transno = transno;
    }

    public String getTransno() 
    {
        return transno;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inbillid", getInbillid())
            .append("inproofid", getInproofid())
            .append("inbillno", getInbillno())
            .append("arrivalbillid", getArrivalbillid())
            .append("sourceid", getSourceid())
            .append("createtime", getCreatetime())
            .append("createor", getCreateor())
            .append("materialid", getMaterialid())
            .append("batchno", getBatchno())
            .append("sn", getSn())
            .append("siteno", getSiteno())
            .append("taskqty", getTaskqty())
            .append("finishqty", getFinishqty())
            .append("supplierid", getSupplierid())
            .append("transportinfo", getTransportinfo())
            .append("billstate", getBillstate())
            .append("billdesc", getBilldesc())
            .append("weight", getWeight())
            .append("volume", getVolume())
            .append("startsn", getStartsn())
            .append("endsn", getEndsn())
            .append("orderItemTransactionId", getOrderItemTransactionId())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("data5", getData5())
            .append("data6", getData6())
            .append("data7", getData7())
            .append("data8", getData8())
            .append("data9", getData9())
            .append("data10", getData10())
            .append("sourceHeaderId", getSourceHeaderId())
            .append("erpOrderType", getErpOrderType())
            .append("sourceLineId", getSourceLineId())
            .append("transactionType", getTransactionType())
            .append("subinventoryCode", getSubinventoryCode())
            .append("owningOrganizationId", getOwningOrganizationId())
            .append("owningOrganizationName", getOwningOrganizationName())
            .append("repOrg", getRepOrg())
            .append("data11", getData11())
            .append("data12", getData12())
            .append("collectEmpid", getCollectEmpid())
            .append("collectDate", getCollectDate())
            .append("hintfinish", getHintfinish())
            .append("hintdesc", getHintdesc())
            .append("incheckdetailid", getIncheckdetailid())
            .append("incheckbillid", getIncheckbillid())
            .append("arrivalsDetailid", getArrivalsDetailid())
            .append("orderTransactionId", getOrderTransactionId())
            .append("palletnum", getPalletnum())
            .append("wipEntityId", getWipEntityId())
            .append("wipEntityName", getWipEntityName())
            .append("primaryItemDesc", getPrimaryItemDesc())
            .append("scheduleGroupName", getScheduleGroupName())
            .append("productline", getProductline())
            .append("workstation", getWorkstation())
            .append("palletno", getPalletno())
            .append("projectNum", getProjectNum())
            .append("poProjectNum", getPoProjectNum())
            .append("outtaskitemid", getOuttaskitemid())
            .append("outtaskid", getOuttaskid())
            .append("outbillid", getOutbillid())
            .append("outproofid", getOutproofid())
            .append("hintfinishtor", getHintfinishtor())
            .append("supplier", getSupplier())
            .append("responsible", getResponsible())
            .append("nonconforming", getNonconforming())
            .append("disposal", getDisposal())
            .append("ipqcno", getIpqcno())
            .append("transno", getTransno())
            .toString();
    }
}

package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 outbill
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public class Outbill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long outbillid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long outproofid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String billno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long materialid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long partnerid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long taskqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long finishqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long creator;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long billstate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String billdesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** 入库子库 */
    @Excel(name = "入库子库")
    private String data1;

    /** 存放采购退货，所需的签收ID */
    @Excel(name = "存放采购退货，所需的签收ID")
    private String data2;

    /** 存放回传给ERP的主键ID */
    @Excel(name = "存放回传给ERP的主键ID")
    private String data3;

    /** 存放入库单ID，供采购退货使用 */
    @Excel(name = "存放入库单ID，供采购退货使用")
    private String data4;

    /** 拉式发料，存放drawmaterial_rf_bill_itemid，用于回报使用 */
    @Excel(name = "拉式发料，存放drawmaterial_rf_bill_itemid，用于回报使用")
    private String data5;

    /** 拉式发料，存放库位，用于界面显示 */
    @Excel(name = "拉式发料，存放库位，用于界面显示")
    private String data6;

    /** 拉式发料，存放子库类似P01 */
    @Excel(name = "拉式发料，存放子库类似P01")
    private String data7;

    /** 是否已占用库存,在出库凭证执行的时候判断库存的DATA1,Y不需要,N需要 */
    @Excel(name = "是否已占用库存,在出库凭证执行的时候判断库存的DATA1,Y不需要,N需要")
    private String data8;

    /** 工位 */
    @Excel(name = "工位")
    private String workstation;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sourceHeaderId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sourceLineId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String erpOrderType;

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
    private Long drawmaterialRfBillItemid;

    /** 存放入库单ID，供采购退货使用 */
    @Excel(name = "存放入库单ID，供采购退货使用")
    private Long inbillid;

    /** 采集人 */
    @Excel(name = "采集人")
    private Long collectEmpid;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectDate;

    /** 占用信息 */
    @Excel(name = "占用信息")
    private String occupyRepqty;

    /** 强制货位 */
    @Excel(name = "强制货位")
    private Long hintsite;

    /** 强制完工 1:表示强制; 0:表示正常;2:表示强制完工后台处理完成 */
    @Excel(name = "强制完工 1:表示强制; 0:表示正常;2:表示强制完工后台处理完成")
    private Long hintfinish;

    /** 强制完工处理失败原因 */
    @Excel(name = "强制完工处理失败原因")
    private String hintdesc;

    /** 中间行表ID */
    @Excel(name = "中间行表ID")
    private String orderItemTransactionId;

    /** 中间头表ID */
    @Excel(name = "中间头表ID")
    private String orderTransactionId;

    /** 工单ID */
    @Excel(name = "工单ID")
    private Long wipEntityId;

    /** 工单号 */
    @Excel(name = "工单号")
    private String wipEntityName;

    /** 工单产品名称 */
    @Excel(name = "工单产品名称")
    private String primaryItemDesc;

    /** 计划组 */
    @Excel(name = "计划组")
    private String scheduleGroupName;

    /** 占用数量 */
    @Excel(name = "占用数量")
    private Long occupyqty;

    /** 采集状态 */
    @Excel(name = "采集状态")
    private Long collectState;

    /** 开始序列号 */
    @Excel(name = "开始序列号")
    private String serialNumberStart;

    /** 结束序列号 */
    @Excel(name = "结束序列号")
    private String serialNumberEnd;

    /** 入库采集回填TRANSACTION_ID,供采购退货使用 */
    @Excel(name = "入库采集回填TRANSACTION_ID,供采购退货使用")
    private String incollectTransactionId;

    /** 产线编号 */
    @Excel(name = "产线编号")
    private String productline;

    /** 工序 */
    @Excel(name = "工序")
    private Long operationSeqNum;

    /** 成套集盒 */
    @Excel(name = "成套集盒")
    private String wholesetno;

    /** 成套集盒数量 */
    @Excel(name = "成套集盒数量")
    private Long wholesetnum;

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** 工单明细状态 0：正常；1：调拨  */
    @Excel(name = "工单明细状态 0：正常；1：调拨 ")
    private Long workorderstate;

    /** 项目号 */
    @Excel(name = "项目号")
    private String projectNum;

    /** 调入项目号 */
    @Excel(name = "调入项目号")
    private String transferProjectNum;

    /** 占用出库单号 */
    @Excel(name = "占用出库单号")
    private String occupyOrderno;

    /** 出库单号 */
    @Excel(name = "出库单号")
    private String orderno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String hintfinishtor;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String deliveryData;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String deliveryTime;

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
    public void setBillno(String billno) 
    {
        this.billno = billno;
    }

    public String getBillno() 
    {
        return billno;
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
    public void setWorkstation(String workstation) 
    {
        this.workstation = workstation;
    }

    public String getWorkstation() 
    {
        return workstation;
    }
    public void setSourceHeaderId(String sourceHeaderId) 
    {
        this.sourceHeaderId = sourceHeaderId;
    }

    public String getSourceHeaderId() 
    {
        return sourceHeaderId;
    }
    public void setSourceLineId(String sourceLineId) 
    {
        this.sourceLineId = sourceLineId;
    }

    public String getSourceLineId() 
    {
        return sourceLineId;
    }
    public void setErpOrderType(String erpOrderType) 
    {
        this.erpOrderType = erpOrderType;
    }

    public String getErpOrderType() 
    {
        return erpOrderType;
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
    public void setDrawmaterialRfBillItemid(Long drawmaterialRfBillItemid) 
    {
        this.drawmaterialRfBillItemid = drawmaterialRfBillItemid;
    }

    public Long getDrawmaterialRfBillItemid() 
    {
        return drawmaterialRfBillItemid;
    }
    public void setInbillid(Long inbillid) 
    {
        this.inbillid = inbillid;
    }

    public Long getInbillid() 
    {
        return inbillid;
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
    public void setOccupyRepqty(String occupyRepqty) 
    {
        this.occupyRepqty = occupyRepqty;
    }

    public String getOccupyRepqty() 
    {
        return occupyRepqty;
    }
    public void setHintsite(Long hintsite) 
    {
        this.hintsite = hintsite;
    }

    public Long getHintsite() 
    {
        return hintsite;
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
    public void setOrderItemTransactionId(String orderItemTransactionId) 
    {
        this.orderItemTransactionId = orderItemTransactionId;
    }

    public String getOrderItemTransactionId() 
    {
        return orderItemTransactionId;
    }
    public void setOrderTransactionId(String orderTransactionId) 
    {
        this.orderTransactionId = orderTransactionId;
    }

    public String getOrderTransactionId() 
    {
        return orderTransactionId;
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
    public void setOccupyqty(Long occupyqty) 
    {
        this.occupyqty = occupyqty;
    }

    public Long getOccupyqty() 
    {
        return occupyqty;
    }
    public void setCollectState(Long collectState) 
    {
        this.collectState = collectState;
    }

    public Long getCollectState() 
    {
        return collectState;
    }
    public void setSerialNumberStart(String serialNumberStart) 
    {
        this.serialNumberStart = serialNumberStart;
    }

    public String getSerialNumberStart() 
    {
        return serialNumberStart;
    }
    public void setSerialNumberEnd(String serialNumberEnd) 
    {
        this.serialNumberEnd = serialNumberEnd;
    }

    public String getSerialNumberEnd() 
    {
        return serialNumberEnd;
    }
    public void setIncollectTransactionId(String incollectTransactionId) 
    {
        this.incollectTransactionId = incollectTransactionId;
    }

    public String getIncollectTransactionId() 
    {
        return incollectTransactionId;
    }
    public void setProductline(String productline) 
    {
        this.productline = productline;
    }

    public String getProductline() 
    {
        return productline;
    }
    public void setOperationSeqNum(Long operationSeqNum) 
    {
        this.operationSeqNum = operationSeqNum;
    }

    public Long getOperationSeqNum() 
    {
        return operationSeqNum;
    }
    public void setWholesetno(String wholesetno) 
    {
        this.wholesetno = wholesetno;
    }

    public String getWholesetno() 
    {
        return wholesetno;
    }
    public void setWholesetnum(Long wholesetnum) 
    {
        this.wholesetnum = wholesetnum;
    }

    public Long getWholesetnum() 
    {
        return wholesetnum;
    }
    public void setPalletno(String palletno) 
    {
        this.palletno = palletno;
    }

    public String getPalletno() 
    {
        return palletno;
    }
    public void setWorkorderstate(Long workorderstate) 
    {
        this.workorderstate = workorderstate;
    }

    public Long getWorkorderstate() 
    {
        return workorderstate;
    }
    public void setProjectNum(String projectNum) 
    {
        this.projectNum = projectNum;
    }

    public String getProjectNum() 
    {
        return projectNum;
    }
    public void setTransferProjectNum(String transferProjectNum) 
    {
        this.transferProjectNum = transferProjectNum;
    }

    public String getTransferProjectNum() 
    {
        return transferProjectNum;
    }
    public void setOccupyOrderno(String occupyOrderno) 
    {
        this.occupyOrderno = occupyOrderno;
    }

    public String getOccupyOrderno() 
    {
        return occupyOrderno;
    }
    public void setOrderno(String orderno) 
    {
        this.orderno = orderno;
    }

    public String getOrderno() 
    {
        return orderno;
    }
    public void setHintfinishtor(String hintfinishtor) 
    {
        this.hintfinishtor = hintfinishtor;
    }

    public String getHintfinishtor() 
    {
        return hintfinishtor;
    }
    public void setDeliveryData(String deliveryData) 
    {
        this.deliveryData = deliveryData;
    }

    public String getDeliveryData() 
    {
        return deliveryData;
    }
    public void setDeliveryTime(String deliveryTime) 
    {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryTime() 
    {
        return deliveryTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("outbillid", getOutbillid())
            .append("outproofid", getOutproofid())
            .append("billno", getBillno())
            .append("materialid", getMaterialid())
            .append("partnerid", getPartnerid())
            .append("taskqty", getTaskqty())
            .append("finishqty", getFinishqty())
            .append("createdate", getCreatedate())
            .append("creator", getCreator())
            .append("billstate", getBillstate())
            .append("billdesc", getBilldesc())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("data5", getData5())
            .append("data6", getData6())
            .append("data7", getData7())
            .append("data8", getData8())
            .append("workstation", getWorkstation())
            .append("sourceHeaderId", getSourceHeaderId())
            .append("sourceLineId", getSourceLineId())
            .append("erpOrderType", getErpOrderType())
            .append("subinventoryCode", getSubinventoryCode())
            .append("owningOrganizationId", getOwningOrganizationId())
            .append("owningOrganizationName", getOwningOrganizationName())
            .append("drawmaterialRfBillItemid", getDrawmaterialRfBillItemid())
            .append("inbillid", getInbillid())
            .append("collectEmpid", getCollectEmpid())
            .append("collectDate", getCollectDate())
            .append("occupyRepqty", getOccupyRepqty())
            .append("hintsite", getHintsite())
            .append("hintfinish", getHintfinish())
            .append("hintdesc", getHintdesc())
            .append("orderItemTransactionId", getOrderItemTransactionId())
            .append("orderTransactionId", getOrderTransactionId())
            .append("wipEntityId", getWipEntityId())
            .append("wipEntityName", getWipEntityName())
            .append("primaryItemDesc", getPrimaryItemDesc())
            .append("scheduleGroupName", getScheduleGroupName())
            .append("occupyqty", getOccupyqty())
            .append("collectState", getCollectState())
            .append("serialNumberStart", getSerialNumberStart())
            .append("serialNumberEnd", getSerialNumberEnd())
            .append("incollectTransactionId", getIncollectTransactionId())
            .append("productline", getProductline())
            .append("operationSeqNum", getOperationSeqNum())
            .append("wholesetno", getWholesetno())
            .append("wholesetnum", getWholesetnum())
            .append("palletno", getPalletno())
            .append("workorderstate", getWorkorderstate())
            .append("projectNum", getProjectNum())
            .append("transferProjectNum", getTransferProjectNum())
            .append("occupyOrderno", getOccupyOrderno())
            .append("orderno", getOrderno())
            .append("hintfinishtor", getHintfinishtor())
            .append("deliveryData", getDeliveryData())
            .append("deliveryTime", getDeliveryTime())
            .toString();
    }
}

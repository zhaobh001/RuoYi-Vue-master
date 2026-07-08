package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * ERP单据头中间(ERP写,WMS读)对象 cux_wms_order_header_interface
 *
 * @author ruoyi
 * @date 2025-03-27
 */
public class CuxWmsOrderHeaderInterface extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表ID，主键，供其他表做外键 */
    private Long orderTransactionId;

    /** 组织ID */
    @Excel(name = "组织ID")
    private Long orgId;

    /** 业务类型
1  内部销售(天诚出货)
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
18  调拨(仓储发起) */
    @Excel(name = "")
    private String transactionType;

    /** 业务模式
RCV  接收事务处理
TXN  搬运单处理
INV  库存事务处理
TR_LOAD  装箱单处理 */
    @Excel(name = "")
    private String transactionMode;

    /** ERP单据类型
PO                  采购订单
SO                  销售订单
TR_LOAD  装箱单
MOVE_ORDER  物料搬运单
TRANSACTION  物料事务处理
DELIVER   发货通知单 */
    @Excel(name = "")
    private String erpOrderType;

    /** ERP单据编号 */
    @Excel(name = "ERP单据编号")
    private String erpOrderNumber;

    /** 出入库类型,1入库,-1出库，0调拨 */
    @Excel(name = "出入库类型,1入库,-1出库，0调拨")
    private Long actionInout;

    /** 源系统代码，追溯字段 */
    @Excel(name = "源系统代码，追溯字段")
    private String sourceCode;

    /** 原出入库单头ID(无来源时为-1) */
    @Excel(name = "原出入库单头ID(无来源时为-1)")
    private Long sourceHeaderId;

    /** 源系统参考，显示在界面供用户看 */
    @Excel(name = "源系统参考，显示在界面供用户看")
    private String sourceReference;

    /** 后台处理组ID，供分批、并发控制用 */
    @Excel(name = "后台处理组ID，供分批、并发控制用")
    private Long processGroupId;

    /** 后台处理状态：
PENDING 等待,UPDATE 更新,PROCESS 处理,SUCESS 成功,ERROR 错误 */
    @Excel(name = "")
    private String processStatus;

    /** 后台处理日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "后台处理日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date processDate;

    /** 后台处理信息 */
    @Excel(name = "后台处理信息")
    private String processMessage;

    /** 库存组织ID */
    @Excel(name = "库存组织ID")
    private Long organizationId;

    /** 库存组织 */
    @Excel(name = "库存组织")
    private String organizationName;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long customerId;

    /** 客户编码 */
    @Excel(name = "客户编码")
    private String customerNumber;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long vendorId;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String vendorNumber;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String vendorName;

    /** 发货地址 */
    @Excel(name = "发货地址")
    private String receiveSiteName;

    /** 收货人 */
    @Excel(name = "收货人")
    private String consignee;

    /** 电话 */
    @Excel(name = "电话")
    private String rcvTelephone;

    /** 单据最后更新日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "单据最后更新日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderLastDate;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationDate;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createdBy;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lastUpdatedBy;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date lastUpdateDate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lastUpdateLogin;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long programApplicationId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long programId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date programUpdateDate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long requestId;

    /** - */
    @Excel(name = "-")
    private String attributeCategory;

    /** - */
    @Excel(name = "-")
    private String attribute1;

    /** - */
    @Excel(name = "-")
    private String attribute2;

    /** - */
    @Excel(name = "-")
    private String attribute3;

    /** - */
    @Excel(name = "-")
    private String attribute4;

    /** - */
    @Excel(name = "-")
    private String attribute5;

    /** - */
    @Excel(name = "-")
    private String attribute6;

    /** - */
    @Excel(name = "-")
    private Long attribute7;

    /** - */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "-", width = 30, dateFormat = "yyyy-MM-dd")
    private Date attribute8;

    /** - */
    @Excel(name = "-")
    private String attribute9;

    /** - */
    @Excel(name = "-")
    private Long attribute10;

    /** - */
    @Excel(name = "-")
    private String attribute11;

    /** - */
    @Excel(name = "-")
    private String attribute12;

    /** - */
    @Excel(name = "-")
    private String attribute13;

    /** - */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "-", width = 30, dateFormat = "yyyy-MM-dd")
    private Date attribute14;

    /** - */
    @Excel(name = "-")
    private Long attribute15;

    /** 供应商地点ID */
    @Excel(name = "供应商地点ID")
    private Long vendorSiteId;

    /** 供应商地点
对于入库 :  如果是空，则自采; 否则: 外购 */
    @Excel(name = "")
    private String vendorSiteCode;

    /** 来源单号 */
    @Excel(name = "来源单号")
    private String sourceNumber;

    /** 来源单号ID */
    @Excel(name = "来源单号ID")
    private Long sourceNumberId;

    /** 来源单号类型 */
    @Excel(name = "来源单号类型")
    private String sourceNumberType;

    /** 是否生产补单 */
    @Excel(name = "是否生产补单")
    private String wipSupplementFlag;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** - */
    @Excel(name = "-")
    private String data1;

    /** 0，新建；1，下达 */
    @Excel(name = "0，新建；1，下达")
    private String data2;

    /** 新建时间 */
    @Excel(name = "新建时间")
    private String data3;

    /** 下达时间 */
    @Excel(name = "下达时间")
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

    /** - */
    @Excel(name = "-")
    private String data9;

    /** - */
    @Excel(name = "-")
    private String data10;

    /** 新建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "新建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 新建人 */
    @Excel(name = "新建人")
    private Long createEmpid;

    /** 下达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date executeDate;

    /** 下达人 */
    @Excel(name = "下达人")
    private Long executeEmpid;

    /** 0：新建；1：下达 */
    @Excel(name = "0：新建；1：下达")
    private Long prostate;

    /** 零部件发货合并处理：0：未处理；1：已经处理；2：处理失败 */
    @Excel(name = "零部件发货合并处理：0：未处理；1：已经处理；2：处理失败")
    private Long shipstate;

    /** 生成调拨状态 0：新建；1：下达  */
    @Excel(name = "生成调拨状态 0：新建；1：下达 ")
    private Long transferstate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String receiveName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String receiveStockSiteCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String receiveSiteCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String receiveProjectCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String receiveAddress;

    public void setOrderTransactionId(Long orderTransactionId)
    {
        this.orderTransactionId = orderTransactionId;
    }

    public Long getOrderTransactionId()
    {
        return orderTransactionId;
    }
    public void setOrgId(Long orgId)
    {
        this.orgId = orgId;
    }

    public Long getOrgId()
    {
        return orgId;
    }
    public void setTransactionType(String transactionType)
    {
        this.transactionType = transactionType;
    }

    public String getTransactionType()
    {
        return transactionType;
    }
    public void setTransactionMode(String transactionMode)
    {
        this.transactionMode = transactionMode;
    }

    public String getTransactionMode()
    {
        return transactionMode;
    }
    public void setErpOrderType(String erpOrderType)
    {
        this.erpOrderType = erpOrderType;
    }

    public String getErpOrderType()
    {
        return erpOrderType;
    }
    public void setErpOrderNumber(String erpOrderNumber)
    {
        this.erpOrderNumber = erpOrderNumber;
    }

    public String getErpOrderNumber()
    {
        return erpOrderNumber;
    }
    public void setActionInout(Long actionInout)
    {
        this.actionInout = actionInout;
    }

    public Long getActionInout()
    {
        return actionInout;
    }
    public void setSourceCode(String sourceCode)
    {
        this.sourceCode = sourceCode;
    }

    public String getSourceCode()
    {
        return sourceCode;
    }
    public void setSourceHeaderId(Long sourceHeaderId)
    {
        this.sourceHeaderId = sourceHeaderId;
    }

    public Long getSourceHeaderId()
    {
        return sourceHeaderId;
    }
    public void setSourceReference(String sourceReference)
    {
        this.sourceReference = sourceReference;
    }

    public String getSourceReference()
    {
        return sourceReference;
    }
    public void setProcessGroupId(Long processGroupId)
    {
        this.processGroupId = processGroupId;
    }

    public Long getProcessGroupId()
    {
        return processGroupId;
    }
    public void setProcessStatus(String processStatus)
    {
        this.processStatus = processStatus;
    }

    public String getProcessStatus()
    {
        return processStatus;
    }
    public void setProcessDate(Date processDate)
    {
        this.processDate = processDate;
    }

    public Date getProcessDate()
    {
        return processDate;
    }
    public void setProcessMessage(String processMessage)
    {
        this.processMessage = processMessage;
    }

    public String getProcessMessage()
    {
        return processMessage;
    }
    public void setOrganizationId(Long organizationId)
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId()
    {
        return organizationId;
    }
    public void setOrganizationName(String organizationName)
    {
        this.organizationName = organizationName;
    }

    public String getOrganizationName()
    {
        return organizationName;
    }
    public void setCustomerId(Long customerId)
    {
        this.customerId = customerId;
    }

    public Long getCustomerId()
    {
        return customerId;
    }
    public void setCustomerNumber(String customerNumber)
    {
        this.customerNumber = customerNumber;
    }

    public String getCustomerNumber()
    {
        return customerNumber;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerName()
    {
        return customerName;
    }
    public void setVendorId(Long vendorId)
    {
        this.vendorId = vendorId;
    }

    public Long getVendorId()
    {
        return vendorId;
    }
    public void setVendorNumber(String vendorNumber)
    {
        this.vendorNumber = vendorNumber;
    }

    public String getVendorNumber()
    {
        return vendorNumber;
    }
    public void setVendorName(String vendorName)
    {
        this.vendorName = vendorName;
    }

    public String getVendorName()
    {
        return vendorName;
    }
    public void setReceiveSiteName(String receiveSiteName)
    {
        this.receiveSiteName = receiveSiteName;
    }

    public String getReceiveSiteName()
    {
        return receiveSiteName;
    }
    public void setConsignee(String consignee)
    {
        this.consignee = consignee;
    }

    public String getConsignee()
    {
        return consignee;
    }
    public void setRcvTelephone(String rcvTelephone)
    {
        this.rcvTelephone = rcvTelephone;
    }

    public String getRcvTelephone()
    {
        return rcvTelephone;
    }
    public void setOrderLastDate(Date orderLastDate)
    {
        this.orderLastDate = orderLastDate;
    }

    public Date getOrderLastDate()
    {
        return orderLastDate;
    }
    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }
    public void setCreatedBy(Long createdBy)
    {
        this.createdBy = createdBy;
    }

    public Long getCreatedBy()
    {
        return createdBy;
    }
    public void setLastUpdatedBy(Long lastUpdatedBy)
    {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Long getLastUpdatedBy()
    {
        return lastUpdatedBy;
    }
    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }
    public void setLastUpdateLogin(Long lastUpdateLogin)
    {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public Long getLastUpdateLogin()
    {
        return lastUpdateLogin;
    }
    public void setProgramApplicationId(Long programApplicationId)
    {
        this.programApplicationId = programApplicationId;
    }

    public Long getProgramApplicationId()
    {
        return programApplicationId;
    }
    public void setProgramId(Long programId)
    {
        this.programId = programId;
    }

    public Long getProgramId()
    {
        return programId;
    }
    public void setProgramUpdateDate(Date programUpdateDate)
    {
        this.programUpdateDate = programUpdateDate;
    }

    public Date getProgramUpdateDate()
    {
        return programUpdateDate;
    }
    public void setRequestId(Long requestId)
    {
        this.requestId = requestId;
    }

    public Long getRequestId()
    {
        return requestId;
    }
    public void setAttributeCategory(String attributeCategory)
    {
        this.attributeCategory = attributeCategory;
    }

    public String getAttributeCategory()
    {
        return attributeCategory;
    }
    public void setAttribute1(String attribute1)
    {
        this.attribute1 = attribute1;
    }

    public String getAttribute1()
    {
        return attribute1;
    }
    public void setAttribute2(String attribute2)
    {
        this.attribute2 = attribute2;
    }

    public String getAttribute2()
    {
        return attribute2;
    }
    public void setAttribute3(String attribute3)
    {
        this.attribute3 = attribute3;
    }

    public String getAttribute3()
    {
        return attribute3;
    }
    public void setAttribute4(String attribute4)
    {
        this.attribute4 = attribute4;
    }

    public String getAttribute4()
    {
        return attribute4;
    }
    public void setAttribute5(String attribute5)
    {
        this.attribute5 = attribute5;
    }

    public String getAttribute5()
    {
        return attribute5;
    }
    public void setAttribute6(String attribute6)
    {
        this.attribute6 = attribute6;
    }

    public String getAttribute6()
    {
        return attribute6;
    }
    public void setAttribute7(Long attribute7)
    {
        this.attribute7 = attribute7;
    }

    public Long getAttribute7()
    {
        return attribute7;
    }
    public void setAttribute8(Date attribute8)
    {
        this.attribute8 = attribute8;
    }

    public Date getAttribute8()
    {
        return attribute8;
    }
    public void setAttribute9(String attribute9)
    {
        this.attribute9 = attribute9;
    }

    public String getAttribute9()
    {
        return attribute9;
    }
    public void setAttribute10(Long attribute10)
    {
        this.attribute10 = attribute10;
    }

    public Long getAttribute10()
    {
        return attribute10;
    }
    public void setAttribute11(String attribute11)
    {
        this.attribute11 = attribute11;
    }

    public String getAttribute11()
    {
        return attribute11;
    }
    public void setAttribute12(String attribute12)
    {
        this.attribute12 = attribute12;
    }

    public String getAttribute12()
    {
        return attribute12;
    }
    public void setAttribute13(String attribute13)
    {
        this.attribute13 = attribute13;
    }

    public String getAttribute13()
    {
        return attribute13;
    }
    public void setAttribute14(Date attribute14)
    {
        this.attribute14 = attribute14;
    }

    public Date getAttribute14()
    {
        return attribute14;
    }
    public void setAttribute15(Long attribute15)
    {
        this.attribute15 = attribute15;
    }

    public Long getAttribute15()
    {
        return attribute15;
    }
    public void setVendorSiteId(Long vendorSiteId)
    {
        this.vendorSiteId = vendorSiteId;
    }

    public Long getVendorSiteId()
    {
        return vendorSiteId;
    }
    public void setVendorSiteCode(String vendorSiteCode)
    {
        this.vendorSiteCode = vendorSiteCode;
    }

    public String getVendorSiteCode()
    {
        return vendorSiteCode;
    }
    public void setSourceNumber(String sourceNumber)
    {
        this.sourceNumber = sourceNumber;
    }

    public String getSourceNumber()
    {
        return sourceNumber;
    }
    public void setSourceNumberId(Long sourceNumberId)
    {
        this.sourceNumberId = sourceNumberId;
    }

    public Long getSourceNumberId()
    {
        return sourceNumberId;
    }
    public void setSourceNumberType(String sourceNumberType)
    {
        this.sourceNumberType = sourceNumberType;
    }

    public String getSourceNumberType()
    {
        return sourceNumberType;
    }
    public void setWipSupplementFlag(String wipSupplementFlag)
    {
        this.wipSupplementFlag = wipSupplementFlag;
    }

    public String getWipSupplementFlag()
    {
        return wipSupplementFlag;
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
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }
    public void setCreateEmpid(Long createEmpid)
    {
        this.createEmpid = createEmpid;
    }

    public Long getCreateEmpid()
    {
        return createEmpid;
    }
    public void setExecuteDate(Date executeDate)
    {
        this.executeDate = executeDate;
    }

    public Date getExecuteDate()
    {
        return executeDate;
    }
    public void setExecuteEmpid(Long executeEmpid)
    {
        this.executeEmpid = executeEmpid;
    }

    public Long getExecuteEmpid()
    {
        return executeEmpid;
    }
    public void setProstate(Long prostate)
    {
        this.prostate = prostate;
    }

    public Long getProstate()
    {
        return prostate;
    }
    public void setShipstate(Long shipstate)
    {
        this.shipstate = shipstate;
    }

    public Long getShipstate()
    {
        return shipstate;
    }
    public void setTransferstate(Long transferstate)
    {
        this.transferstate = transferstate;
    }

    public Long getTransferstate()
    {
        return transferstate;
    }
    public void setReceiveName(String receiveName)
    {
        this.receiveName = receiveName;
    }

    public String getReceiveName()
    {
        return receiveName;
    }
    public void setReceiveStockSiteCode(String receiveStockSiteCode)
    {
        this.receiveStockSiteCode = receiveStockSiteCode;
    }

    public String getReceiveStockSiteCode()
    {
        return receiveStockSiteCode;
    }
    public void setReceiveSiteCode(String receiveSiteCode)
    {
        this.receiveSiteCode = receiveSiteCode;
    }

    public String getReceiveSiteCode()
    {
        return receiveSiteCode;
    }
    public void setReceiveProjectCode(String receiveProjectCode)
    {
        this.receiveProjectCode = receiveProjectCode;
    }

    public String getReceiveProjectCode()
    {
        return receiveProjectCode;
    }
    public void setReceiveAddress(String receiveAddress)
    {
        this.receiveAddress = receiveAddress;
    }

    public String getReceiveAddress()
    {
        return receiveAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderTransactionId", getOrderTransactionId())
            .append("orgId", getOrgId())
            .append("transactionType", getTransactionType())
            .append("transactionMode", getTransactionMode())
            .append("erpOrderType", getErpOrderType())
            .append("erpOrderNumber", getErpOrderNumber())
            .append("actionInout", getActionInout())
            .append("sourceCode", getSourceCode())
            .append("sourceHeaderId", getSourceHeaderId())
            .append("sourceReference", getSourceReference())
            .append("processGroupId", getProcessGroupId())
            .append("processStatus", getProcessStatus())
            .append("processDate", getProcessDate())
            .append("processMessage", getProcessMessage())
            .append("organizationId", getOrganizationId())
            .append("organizationName", getOrganizationName())
            .append("customerId", getCustomerId())
            .append("customerNumber", getCustomerNumber())
            .append("customerName", getCustomerName())
            .append("vendorId", getVendorId())
            .append("vendorNumber", getVendorNumber())
            .append("vendorName", getVendorName())
            .append("receiveSiteName", getReceiveSiteName())
            .append("consignee", getConsignee())
            .append("rcvTelephone", getRcvTelephone())
            .append("orderLastDate", getOrderLastDate())
            .append("creationDate", getCreationDate())
            .append("createdBy", getCreatedBy())
            .append("lastUpdatedBy", getLastUpdatedBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("lastUpdateLogin", getLastUpdateLogin())
            .append("programApplicationId", getProgramApplicationId())
            .append("programId", getProgramId())
            .append("programUpdateDate", getProgramUpdateDate())
            .append("requestId", getRequestId())
            .append("attributeCategory", getAttributeCategory())
            .append("attribute1", getAttribute1())
            .append("attribute2", getAttribute2())
            .append("attribute3", getAttribute3())
            .append("attribute4", getAttribute4())
            .append("attribute5", getAttribute5())
            .append("attribute6", getAttribute6())
            .append("attribute7", getAttribute7())
            .append("attribute8", getAttribute8())
            .append("attribute9", getAttribute9())
            .append("attribute10", getAttribute10())
            .append("attribute11", getAttribute11())
            .append("attribute12", getAttribute12())
            .append("attribute13", getAttribute13())
            .append("attribute14", getAttribute14())
            .append("attribute15", getAttribute15())
            .append("vendorSiteId", getVendorSiteId())
            .append("vendorSiteCode", getVendorSiteCode())
            .append("sourceNumber", getSourceNumber())
            .append("sourceNumberId", getSourceNumberId())
            .append("sourceNumberType", getSourceNumberType())
            .append("wipSupplementFlag", getWipSupplementFlag())
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
            .append("createDate", getCreateDate())
            .append("createEmpid", getCreateEmpid())
            .append("executeDate", getExecuteDate())
            .append("executeEmpid", getExecuteEmpid())
            .append("prostate", getProstate())
            .append("shipstate", getShipstate())
            .append("transferstate", getTransferstate())
            .append("receiveName", getReceiveName())
            .append("receiveStockSiteCode", getReceiveStockSiteCode())
            .append("receiveSiteCode", getReceiveSiteCode())
            .append("receiveProjectCode", getReceiveProjectCode())
            .append("receiveAddress", getReceiveAddress())
            .toString();
    }
}

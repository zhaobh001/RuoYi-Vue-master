package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 入库凭证主对象 inproof
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public class Inproof extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long inproofid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String proofno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String prosource;

    /** 入库单号 */
    @Excel(name = "入库单号")
    private String orderno;

    /** 采购入库专用 */
    @Excel(name = "采购入库专用")
    private String inboxno;

    /** 检验结果是否在WMS录入
0：否
1：是 */
    @Excel(name = "检验结果是否在WMS录入0：否1：是")
    private String iswmsCheck;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String protype;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date prodate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long proempid;

    /** 允许在凭证上选择供应商，一旦选择则入库单中的供应商可不填
 */
    @Excel(name = "允许在凭证上选择供应商，一旦选择则入库单中的供应商可不填")
    private Long partnerid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String transportinfo;

    /** 0：新建
1：执行
2：审核 */
    @Excel(name = "0：新建1：执行2：审核")
    private Long prostate;

    /** 库房ID */
    @Excel(name = "库房ID")
    private Long depotno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long totalvolume;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long totalweight;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String prodesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** 用来区别指令时计算自动生成或者其他方式生成的
0：通过单据中新建按钮手动创建
1：根据物料规则系统自动生成
2：采集器采集数据成功登记创建 */
    @Excel(name = "用来区别指令时计算自动生成或者其他方式生成的0：通过单据中新建按钮手动创建1：根据物料规则系统自动生成2：采集器采集数据成功登记创建")
    private String data1;

    /** 出库单号，调拨用 */
    @Excel(name = "出库单号，调拨用")
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

    /** 中间头表的ID */
    @Excel(name = "中间头表的ID")
    private String orderTransactionId;

    /** 来源单号 */
    @Excel(name = "来源单号")
    private String poNumber;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String transactionType;

    /** 发送状态(发送ERP) */
    @Excel(name = "发送状态(发送ERP)")
    private Long sendstate;

    /** 执行人 */
    @Excel(name = "执行人")
    private Long executeempid;

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** 调拨类型 */
    @Excel(name = "调拨类型")
    private String transfertype;

    /** 调拨出库凭证ID */
    @Excel(name = "调拨出库凭证ID")
    private Long outproofid;

    /** 调拨出库凭证号 */
    @Excel(name = "调拨出库凭证号")
    private String outproofno;

    public void setInproofid(Long inproofid) 
    {
        this.inproofid = inproofid;
    }

    public Long getInproofid() 
    {
        return inproofid;
    }
    public void setProofno(String proofno) 
    {
        this.proofno = proofno;
    }

    public String getProofno() 
    {
        return proofno;
    }
    public void setProsource(String prosource) 
    {
        this.prosource = prosource;
    }

    public String getProsource() 
    {
        return prosource;
    }
    public void setOrderno(String orderno) 
    {
        this.orderno = orderno;
    }

    public String getOrderno() 
    {
        return orderno;
    }
    public void setInboxno(String inboxno) 
    {
        this.inboxno = inboxno;
    }

    public String getInboxno() 
    {
        return inboxno;
    }
    public void setIswmsCheck(String iswmsCheck) 
    {
        this.iswmsCheck = iswmsCheck;
    }

    public String getIswmsCheck() 
    {
        return iswmsCheck;
    }
    public void setProtype(String protype) 
    {
        this.protype = protype;
    }

    public String getProtype() 
    {
        return protype;
    }
    public void setProdate(Date prodate) 
    {
        this.prodate = prodate;
    }

    public Date getProdate() 
    {
        return prodate;
    }
    public void setProempid(Long proempid) 
    {
        this.proempid = proempid;
    }

    public Long getProempid() 
    {
        return proempid;
    }
    public void setPartnerid(Long partnerid) 
    {
        this.partnerid = partnerid;
    }

    public Long getPartnerid() 
    {
        return partnerid;
    }
    public void setTransportinfo(String transportinfo) 
    {
        this.transportinfo = transportinfo;
    }

    public String getTransportinfo() 
    {
        return transportinfo;
    }
    public void setProstate(Long prostate) 
    {
        this.prostate = prostate;
    }

    public Long getProstate() 
    {
        return prostate;
    }
    public void setDepotno(Long depotno) 
    {
        this.depotno = depotno;
    }

    public Long getDepotno() 
    {
        return depotno;
    }
    public void setTotalvolume(Long totalvolume) 
    {
        this.totalvolume = totalvolume;
    }

    public Long getTotalvolume() 
    {
        return totalvolume;
    }
    public void setTotalweight(Long totalweight) 
    {
        this.totalweight = totalweight;
    }

    public Long getTotalweight() 
    {
        return totalweight;
    }
    public void setProdesc(String prodesc) 
    {
        this.prodesc = prodesc;
    }

    public String getProdesc() 
    {
        return prodesc;
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
    public void setOrderTransactionId(String orderTransactionId) 
    {
        this.orderTransactionId = orderTransactionId;
    }

    public String getOrderTransactionId() 
    {
        return orderTransactionId;
    }
    public void setPoNumber(String poNumber) 
    {
        this.poNumber = poNumber;
    }

    public String getPoNumber() 
    {
        return poNumber;
    }
    public void setTransactionType(String transactionType) 
    {
        this.transactionType = transactionType;
    }

    public String getTransactionType() 
    {
        return transactionType;
    }
    public void setSendstate(Long sendstate) 
    {
        this.sendstate = sendstate;
    }

    public Long getSendstate() 
    {
        return sendstate;
    }
    public void setExecuteempid(Long executeempid) 
    {
        this.executeempid = executeempid;
    }

    public Long getExecuteempid() 
    {
        return executeempid;
    }
    public void setPalletno(String palletno) 
    {
        this.palletno = palletno;
    }

    public String getPalletno() 
    {
        return palletno;
    }
    public void setTransfertype(String transfertype) 
    {
        this.transfertype = transfertype;
    }

    public String getTransfertype() 
    {
        return transfertype;
    }
    public void setOutproofid(Long outproofid) 
    {
        this.outproofid = outproofid;
    }

    public Long getOutproofid() 
    {
        return outproofid;
    }
    public void setOutproofno(String outproofno) 
    {
        this.outproofno = outproofno;
    }

    public String getOutproofno() 
    {
        return outproofno;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inproofid", getInproofid())
            .append("proofno", getProofno())
            .append("prosource", getProsource())
            .append("orderno", getOrderno())
            .append("inboxno", getInboxno())
            .append("iswmsCheck", getIswmsCheck())
            .append("protype", getProtype())
            .append("prodate", getProdate())
            .append("proempid", getProempid())
            .append("partnerid", getPartnerid())
            .append("transportinfo", getTransportinfo())
            .append("prostate", getProstate())
            .append("depotno", getDepotno())
            .append("totalvolume", getTotalvolume())
            .append("totalweight", getTotalweight())
            .append("prodesc", getProdesc())
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
            .append("orderTransactionId", getOrderTransactionId())
            .append("poNumber", getPoNumber())
            .append("transactionType", getTransactionType())
            .append("sendstate", getSendstate())
            .append("executeempid", getExecuteempid())
            .append("palletno", getPalletno())
            .append("transfertype", getTransfertype())
            .append("outproofid", getOutproofid())
            .append("outproofno", getOutproofno())
            .toString();
    }
}

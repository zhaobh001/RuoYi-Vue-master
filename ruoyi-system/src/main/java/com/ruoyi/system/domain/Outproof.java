package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 outproof
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public class Outproof extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long outproofid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outproofno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String prosource;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String orderno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long depotno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String protype;

    /** 0：新建,1：执行,2：审核,3：部分执行,4：配盘,5：合盘,6：配盘完成,7：合盘完成 */
    @Excel(name = "0：新建,1：执行,2：审核,3：部分执行,4：配盘,5：合盘,6：配盘完成,7：合盘完成")
    private Long outstate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long partnerid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date prodate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long proempid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String prodesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** 调拨入的库房 */
    @Excel(name = "调拨入的库房")
    private String data1;

    /** 存放PO_NUMBER */
    @Excel(name = "存放PO_NUMBER")
    private String data2;

    /** 判断是否下达任务，如果，下达则为1，否则没有 */
    @Excel(name = "判断是否下达任务，如果，下达则为1，否则没有")
    private String data3;

    /** 调拨入的子库 */
    @Excel(name = "调拨入的子库")
    private String data4;

    /** 调拨出的子库 */
    @Excel(name = "调拨出的子库")
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

    /** 0：未生成配盘任务  1：已生成 */
    @Excel(name = "0：未生成配盘任务  1：已生成")
    private String isgerneratepallettask;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sourceHeaderId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String transactionType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sourceNumber;

    /** 存放PO_NUMBER */
    @Excel(name = "存放PO_NUMBER")
    private String poNumber;

    /** 调拨入的库房 */
    @Excel(name = "调拨入的库房")
    private Long inStoreroomid;

    /** 发送状态(发送ERP) */
    @Excel(name = "发送状态(发送ERP)")
    private Long sendstate;

    /** 是否生产补单 */
    @Excel(name = "是否生产补单")
    private String wipSupplementFlag;

    /** 执行人 */
    @Excel(name = "执行人")
    private Long executeempid;

    /** 产线编号 */
    @Excel(name = "产线编号")
    private String productline;

    /** 工位 */
    @Excel(name = "工位")
    private String workstation;

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

    /** 调拨类型 */
    @Excel(name = "调拨类型")
    private String transfertype;

    /** 是否含有变桨电机 Y：含有 其他值: 没有 */
    @Excel(name = "是否含有变桨电机 Y：含有 其他值: 没有")
    private String isPitchmotor;

    /** 二级大件节拍配送标识 */
    @Excel(name = "二级大件节拍配送标识")
    private String beatflag;

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
    public void setDepotno(Long depotno) 
    {
        this.depotno = depotno;
    }

    public Long getDepotno() 
    {
        return depotno;
    }
    public void setProtype(String protype) 
    {
        this.protype = protype;
    }

    public String getProtype() 
    {
        return protype;
    }
    public void setOutstate(Long outstate) 
    {
        this.outstate = outstate;
    }

    public Long getOutstate() 
    {
        return outstate;
    }
    public void setPartnerid(Long partnerid) 
    {
        this.partnerid = partnerid;
    }

    public Long getPartnerid() 
    {
        return partnerid;
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
    public void setIsgerneratepallettask(String isgerneratepallettask) 
    {
        this.isgerneratepallettask = isgerneratepallettask;
    }

    public String getIsgerneratepallettask() 
    {
        return isgerneratepallettask;
    }
    public void setSourceHeaderId(String sourceHeaderId) 
    {
        this.sourceHeaderId = sourceHeaderId;
    }

    public String getSourceHeaderId() 
    {
        return sourceHeaderId;
    }
    public void setTransactionType(String transactionType) 
    {
        this.transactionType = transactionType;
    }

    public String getTransactionType() 
    {
        return transactionType;
    }
    public void setSourceNumber(String sourceNumber) 
    {
        this.sourceNumber = sourceNumber;
    }

    public String getSourceNumber() 
    {
        return sourceNumber;
    }
    public void setPoNumber(String poNumber) 
    {
        this.poNumber = poNumber;
    }

    public String getPoNumber() 
    {
        return poNumber;
    }
    public void setInStoreroomid(Long inStoreroomid) 
    {
        this.inStoreroomid = inStoreroomid;
    }

    public Long getInStoreroomid() 
    {
        return inStoreroomid;
    }
    public void setSendstate(Long sendstate) 
    {
        this.sendstate = sendstate;
    }

    public Long getSendstate() 
    {
        return sendstate;
    }
    public void setWipSupplementFlag(String wipSupplementFlag) 
    {
        this.wipSupplementFlag = wipSupplementFlag;
    }

    public String getWipSupplementFlag() 
    {
        return wipSupplementFlag;
    }
    public void setExecuteempid(Long executeempid) 
    {
        this.executeempid = executeempid;
    }

    public Long getExecuteempid() 
    {
        return executeempid;
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
    public void setTransfertype(String transfertype) 
    {
        this.transfertype = transfertype;
    }

    public String getTransfertype() 
    {
        return transfertype;
    }
    public void setIsPitchmotor(String isPitchmotor) 
    {
        this.isPitchmotor = isPitchmotor;
    }

    public String getIsPitchmotor() 
    {
        return isPitchmotor;
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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("outproofid", getOutproofid())
            .append("outproofno", getOutproofno())
            .append("prosource", getProsource())
            .append("orderno", getOrderno())
            .append("depotno", getDepotno())
            .append("protype", getProtype())
            .append("outstate", getOutstate())
            .append("partnerid", getPartnerid())
            .append("prodate", getProdate())
            .append("proempid", getProempid())
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
            .append("isgerneratepallettask", getIsgerneratepallettask())
            .append("sourceHeaderId", getSourceHeaderId())
            .append("transactionType", getTransactionType())
            .append("sourceNumber", getSourceNumber())
            .append("poNumber", getPoNumber())
            .append("inStoreroomid", getInStoreroomid())
            .append("sendstate", getSendstate())
            .append("wipSupplementFlag", getWipSupplementFlag())
            .append("executeempid", getExecuteempid())
            .append("productline", getProductline())
            .append("workstation", getWorkstation())
            .append("operationSeqNum", getOperationSeqNum())
            .append("wholesetno", getWholesetno())
            .append("wholesetnum", getWholesetnum())
            .append("palletno", getPalletno())
            .append("transfertype", getTransfertype())
            .append("isPitchmotor", getIsPitchmotor())
            .append("beatflag", getBeatflag())
            .toString();
    }
}

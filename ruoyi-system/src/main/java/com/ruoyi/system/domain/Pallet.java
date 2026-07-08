package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

/**
 * 托盘对象 pallet
 * 
 * @author ruoyi
 * @date 2023-08-06
 */
public class Pallet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long palletid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String palletNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String palletName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal palletLength;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal palletWidth;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal palletHight;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal palletPlotratio;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal palletCurrentPlot;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal palletCurrentWeight;

    private Long i_taskId;
    private String i_palletNo;
    private String i_tasktype;
    private String o_message;
    private String o_true;

    public Long getI_taskId() {
        return i_taskId;
    }

    public void setI_taskId(Long i_taskId) {
        this.i_taskId = i_taskId;
    }

    public String getI_palletNo() {
        return i_palletNo;
    }

    public void setI_palletNo(String i_palletNo) {
        this.i_palletNo = i_palletNo;
    }

    public String getI_tasktype() {
        return i_tasktype;
    }

    public void setI_tasktype(String i_tasktype) {
        this.i_tasktype = i_tasktype;
    }

    public String getO_message() {
        return o_message;
    }

    public void setO_message(String o_message) {
        this.o_message = o_message;
    }

    public String getO_true() {
        return o_true;
    }

    public void setO_true(String o_true) {
        this.o_true = o_true;
    }

    /** 0：:否
1：是 */
    @Excel(name = "0：:否1：是")
    private String palletIsfull;

    /** 0：原料盘   1：合料盘   2：配料盘  4：空托盘 */
    @Excel(name = "0：原料盘   1：合料盘   2：配料盘  4：空托盘")
    private String palletUseState;

    /** 0：否
1：是 */
    @Excel(name = "0：否1：是")
    private String palletIslack;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String palletWorkOrderNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long palletSite;

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
    private Long currentposition;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long goalposition;

    public Long getPalletid() {
        return palletid;
    }

    public void setPalletid(Long palletid) {
        this.palletid = palletid;
    }

    public String getPalletNo() {
        return palletNo;
    }

    public void setPalletNo(String palletNo) {
        this.palletNo = palletNo;
    }

    public String getPalletName() {
        return palletName;
    }

    public void setPalletName(String palletName) {
        this.palletName = palletName;
    }

    public BigDecimal getPalletLength() {
        return palletLength;
    }

    public void setPalletLength(BigDecimal palletLength) {
        this.palletLength = palletLength;
    }

    public BigDecimal getPalletWidth() {
        return palletWidth;
    }

    public void setPalletWidth(BigDecimal palletWidth) {
        this.palletWidth = palletWidth;
    }

    public BigDecimal getPalletHight() {
        return palletHight;
    }

    public void setPalletHight(BigDecimal palletHight) {
        this.palletHight = palletHight;
    }

    public BigDecimal getPalletPlotratio() {
        return palletPlotratio;
    }

    public void setPalletPlotratio(BigDecimal palletPlotratio) {
        this.palletPlotratio = palletPlotratio;
    }

    public BigDecimal getPalletCurrentPlot() {
        return palletCurrentPlot;
    }

    public void setPalletCurrentPlot(BigDecimal palletCurrentPlot) {
        this.palletCurrentPlot = palletCurrentPlot;
    }

    public BigDecimal getPalletCurrentWeight() {
        return palletCurrentWeight;
    }

    public void setPalletCurrentWeight(BigDecimal palletCurrentWeight) {
        this.palletCurrentWeight = palletCurrentWeight;
    }

    public String getPalletIsfull() {
        return palletIsfull;
    }

    public void setPalletIsfull(String palletIsfull) {
        this.palletIsfull = palletIsfull;
    }

    public String getPalletUseState() {
        return palletUseState;
    }

    public void setPalletUseState(String palletUseState) {
        this.palletUseState = palletUseState;
    }

    public String getPalletIslack() {
        return palletIslack;
    }

    public void setPalletIslack(String palletIslack) {
        this.palletIslack = palletIslack;
    }

    public String getPalletWorkOrderNo() {
        return palletWorkOrderNo;
    }

    public void setPalletWorkOrderNo(String palletWorkOrderNo) {
        this.palletWorkOrderNo = palletWorkOrderNo;
    }

    public Long getPalletSite() {
        return palletSite;
    }

    public void setPalletSite(Long palletSite) {
        this.palletSite = palletSite;
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

    public Long getCurrentposition() {
        return currentposition;
    }

    public void setCurrentposition(Long currentposition) {
        this.currentposition = currentposition;
    }

    public Long getGoalposition() {
        return goalposition;
    }

    public void setGoalposition(Long goalposition) {
        this.goalposition = goalposition;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("palletid", palletid)
                .append("palletNo", palletNo)
                .append("palletName", palletName)
                .append("palletLength", palletLength)
                .append("palletWidth", palletWidth)
                .append("palletHight", palletHight)
                .append("palletPlotratio", palletPlotratio)
                .append("palletCurrentPlot", palletCurrentPlot)
                .append("palletCurrentWeight", palletCurrentWeight)
                .append("i_taskId", i_taskId)
                .append("i_palletNo", i_palletNo)
                .append("i_tasktype", i_tasktype)
                .append("o_message", o_message)
                .append("o_true", o_true)
                .append("palletIsfull", palletIsfull)
                .append("palletUseState", palletUseState)
                .append("palletIslack", palletIslack)
                .append("palletWorkOrderNo", palletWorkOrderNo)
                .append("palletSite", palletSite)
                .append("dataversion", dataversion)
                .append("data1", data1)
                .append("data2", data2)
                .append("data3", data3)
                .append("data4", data4)
                .append("currentposition", currentposition)
                .append("goalposition", goalposition)
                .toString();
    }
}

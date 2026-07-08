package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 入库采集数据对象 incollectdata
 *
 * @author ruoyi
 * @date 2023-07-30
 */
public class Incollectdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long incollectdataid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dcConnectid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long intaskitemid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date collecttime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long insite;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long materialid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String batchno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal qty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sn;

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

    /** 采集数据处理状态   0：采集已上传   1：WMS处理完成  -1：WMS处理失败   2：ERP处理成功  -2：ERP处理失败 */
    @Excel(name = "采集数据处理状态   0：采集已上传   1：WMS处理完成  -1：WMS处理失败   2：ERP处理成功  -2：ERP处理失败")
    private Long cstate;

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** 任务ID */
    @Excel(name = "任务ID")
    private Long intaskid;

    /** cux_wms_trans_interface的ID */
    @Excel(name = "cux_wms_trans_interface的ID")
    private Long transactionId;

    private String filter;
    private String sb;

    private String year_id;
    private String month_id;
    private BigDecimal kindqty;
    private BigDecimal ly_qty;
    private BigDecimal ly_kindqty;
    private BigDecimal qty_voy;
    private BigDecimal kindqty_voy;
    private String storeroomname;
    private String start_month;
    private String end_month;

    private String difference_reason;
    private String reason_proper;
    private String reason_category;
    private String first_date;


    public String getDifference_reason() {
        return difference_reason;
    }

    public void setDifference_reason(String difference_reason) {
        this.difference_reason = difference_reason;
    }

    public String getReason_proper() {
        return reason_proper;
    }

    public void setReason_proper(String reason_proper) {
        this.reason_proper = reason_proper;
    }

    public String getReason_category() {
        return reason_category;
    }

    public void setReason_category(String reason_category) {
        this.reason_category = reason_category;
    }

    public String getFirst_date() {
        return first_date;
    }

    public void setFirst_date(String first_date) {
        this.first_date = first_date;
    }

    public String getStart_month() {
        return start_month;
    }

    public String getStoreroomname() {
        return storeroomname;
    }

    public void setStoreroomname(String storeroomname) {
        this.storeroomname = storeroomname;
    }

    public void setStart_month(String start_month) {
        this.start_month = start_month;
    }

    public String getEnd_month() {
        return end_month;
    }

    public void setEnd_month(String end_month) {
        this.end_month = end_month;
    }

    public String getYear_id() {
        return year_id;
    }

    public void setYear_id(String year_id) {
        this.year_id = year_id;
    }

    public String getMonth_id() {
        return month_id;
    }

    public void setMonth_id(String month_id) {
        this.month_id = month_id;
    }

    public BigDecimal getKindqty() {
        return kindqty;
    }

    public void setKindqty(BigDecimal kindqty) {
        this.kindqty = kindqty;
    }

    public BigDecimal getLy_qty() {
        return ly_qty;
    }

    public void setLy_qty(BigDecimal ly_qty) {
        this.ly_qty = ly_qty;
    }

    public BigDecimal getLy_kindqty() {
        return ly_kindqty;
    }

    public void setLy_kindqty(BigDecimal ly_kindqty) {
        this.ly_kindqty = ly_kindqty;
    }

    public BigDecimal getQty_voy() {
        return qty_voy;
    }

    public void setQty_voy(BigDecimal qty_voy) {
        this.qty_voy = qty_voy;
    }

    public BigDecimal getKindqty_voy() {
        return kindqty_voy;
    }

    public void setKindqty_voy(BigDecimal kindqty_voy) {
        this.kindqty_voy = kindqty_voy;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSb() {
        return sb;
    }

    public void setSb(String sb) {
        this.sb = sb;
    }

    public void setIncollectdataid(Long incollectdataid)
    {
        this.incollectdataid = incollectdataid;
    }

    public Long getIncollectdataid()
    {
        return incollectdataid;
    }
    public void setDcConnectid(Long dcConnectid)
    {
        this.dcConnectid = dcConnectid;
    }

    public Long getDcConnectid()
    {
        return dcConnectid;
    }
    public void setIntaskitemid(Long intaskitemid)
    {
        this.intaskitemid = intaskitemid;
    }

    public Long getIntaskitemid()
    {
        return intaskitemid;
    }
    public void setCollecttime(Date collecttime)
    {
        this.collecttime = collecttime;
    }

    public Date getCollecttime()
    {
        return collecttime;
    }
    public void setInsite(Long insite)
    {
        this.insite = insite;
    }

    public Long getInsite()
    {
        return insite;
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

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
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
    public void setCstate(Long cstate)
    {
        this.cstate = cstate;
    }

    public Long getCstate()
    {
        return cstate;
    }
    public void setPalletno(String palletno)
    {
        this.palletno = palletno;
    }

    public String getPalletno()
    {
        return palletno;
    }
    public void setIntaskid(Long intaskid)
    {
        this.intaskid = intaskid;
    }

    public Long getIntaskid()
    {
        return intaskid;
    }
    public void setTransactionId(Long transactionId)
    {
        this.transactionId = transactionId;
    }

    public Long getTransactionId()
    {
        return transactionId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("incollectdataid", incollectdataid)
                .append("dcConnectid", dcConnectid)
                .append("intaskitemid", intaskitemid)
                .append("collecttime", collecttime)
                .append("insite", insite)
                .append("materialid", materialid)
                .append("batchno", batchno)
                .append("qty", qty)
                .append("sn", sn)
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
                .append("cstate", cstate)
                .append("palletno", palletno)
                .append("intaskid", intaskid)
                .append("transactionId", transactionId)
                .append("filter", filter)
                .append("sb", sb)
                .toString();
    }
}

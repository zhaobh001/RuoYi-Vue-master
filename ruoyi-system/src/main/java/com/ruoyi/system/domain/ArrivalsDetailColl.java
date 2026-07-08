package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

/**
 * PDA采集对象 arrivals_detail_coll
 *
 * @author ruoyi
 * @date 2023-07-04
 */
public class ArrivalsDetailColl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 到货物料主键 */
    private Long arrivalsDetailid;

    /** 到货主单主键 */
    @Excel(name = "到货主单主键")
    private Long arrivalsBillid;

    /** 物料ID */
    @Excel(name = "物料ID")
    private Long materialid;

    /** 批号序列号控制当时 */
    @Excel(name = "批号序列号控制当时")
    private String seqctrl;

    /** 是否原始任务批号 */
    @Excel(name = "是否原始任务批号")
    private String ynorig;

    /** 任务数量 */
    @Excel(name = "任务数量")
    private BigDecimal qty;

    /** 批次号 */
    private String batchno;

    /** 序列号 */
    private String sn;

    /** 生产日期 */
    @Excel(name = "生产日期")
    private String pdate;

    /** 保质期天数 */
    @Excel(name = "保质期天数")
    private String vdays;

    /** 采集批次号 */
    private String cjbatchno;

    /** 采集序列号 */
    private String cjsn;

    /** 采集数量 */
    @Excel(name = "采集数量")
    private  BigDecimal goodqty;

    /** 是否匹配 */
    @Excel(name = "是否匹配")
    private String ynpipei;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String matcode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String matname;

    /** 物料编码方式 */
    @Excel(name = "编码方式")
    private String id_old;

    /** drawCode */
    @Excel(name = "drawCode")
    private String drawCode;

    /** drawVersion */
    @Excel(name = "drawVersion")
    private String drawVersion;

    /** manufacturerCode */
    @Excel(name = "manufacturerCode")
    private String manufacturerCode;

    /** agentCode */
    @Excel(name = "agentCode")
    private String agentCode;

    private String dgFlg;

    public String getDgFlg() {
        return dgFlg;
    }

    public void setDgFlg(String dgFlg) {
        this.dgFlg = dgFlg;
    }

    public String getDrawCode() {
        return drawCode;
    }

    public void setDrawCode(String drawCode) {
        this.drawCode = drawCode;
    }

    public String getDrawVersion() {
        return drawVersion;
    }

    public void setDrawVersion(String drawVersion) {
        this.drawVersion = drawVersion;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getMatcode() {
        return matcode;
    }

    public void setMatcode(String matcode) {
        this.matcode = matcode;
    }

    public String getMatname() {
        return matname;
    }

    public void setMatname(String matname) {
        this.matname = matname;
    }

    public String getId_old() {
        return id_old;
    }

    public void setId_old(String id_old) {
        this.id_old = id_old;
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
    public void setSeqctrl(String seqctrl)
    {
        this.seqctrl = seqctrl;
    }

    public String getSeqctrl()
    {
        return seqctrl;
    }
    public void setYnorig(String ynorig)
    {
        this.ynorig = ynorig;
    }

    public String getYnorig()
    {
        return ynorig;
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

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getGoodqty() {
        return goodqty;
    }

    public void setGoodqty(BigDecimal goodqty) {
        this.goodqty = goodqty;
    }

    public String getSn()
    {
        return sn;
    }
    public void setPdate(String pdate)
    {
        this.pdate = pdate;
    }

    public String getPdate()
    {
        return pdate;
    }
    public void setVdays(String vdays)
    {
        this.vdays = vdays;
    }

    public String getVdays()
    {
        return vdays;
    }
    public void setCjbatchno(String cjbatchno)
    {
        this.cjbatchno = cjbatchno;
    }

    public String getCjbatchno()
    {
        return cjbatchno;
    }
    public void setCjsn(String cjsn)
    {
        this.cjsn = cjsn;
    }

    public String getCjsn()
    {
        return cjsn;
    }

    public void setYnpipei(String ynpipei)
    {
        this.ynpipei = ynpipei;
    }

    public String getYnpipei()
    {
        return ynpipei;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("arrivalsDetailid", getArrivalsDetailid())
            .append("arrivalsBillid", getArrivalsBillid())
            .append("materialid", getMaterialid())
            .append("seqctrl", getSeqctrl())
            .append("ynorig", getYnorig())
            .append("qty", getQty())
            .append("batchno", getBatchno())
            .append("sn", getSn())
            .append("pdate", getPdate())
            .append("vdays", getVdays())
            .append("cjbatchno", getCjbatchno())
            .append("cjsn", getCjsn())
            .append("goodqty", getGoodqty())
            .append("ynpipei", getYnpipei())
            .append("matcode", getMatcode())
            .append("matname", getMatname())
            .append("id_old", getId_old())
            .toString();
    }
}

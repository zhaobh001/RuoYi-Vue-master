package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 移库移入移出对象 moveinout
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public class Moveinout extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long moveinoutid;

    /** 目标库位（移入库位） */
    @Excel(name = "目标库位", readConverterExp = "移=入库位")
    private Long insite;

    /** 来源库位（移出库位） */
    @Excel(name = "来源库位", readConverterExp = "移=出库位")
    private Long outsite;

    /** 物料ID */
    @Excel(name = "物料ID")
    private Long materialid;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchno;

    /** 序列号（SN号） */
    @Excel(name = "序列号", readConverterExp = "S=N号")
    private String sn;

    /** 移库数量 */
    @Excel(name = "移库数量")
    private BigDecimal qty;

    /** 备注 */
    @Excel(name = "备注")
    private String movedesc;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String data1;

    /** 作业时间 */
    @Excel(name = "作业时间")
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

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** 颜色 */
    @Excel(name = "颜色")
    private String repColor;

    /** 特殊属性 */
    @Excel(name = "特殊属性")
    private String repProperty;

    /** 拥有方编码 */
    @Excel(name = "拥有方编码")
    private String repOwnerCode;

    /** 拥有方名称 */
    @Excel(name = "拥有方名称")
    private String repOwnerName;

    /** 库存组织 */
    @Excel(name = "库存组织")
    private String repOrg;

    /** ERP子库 */
    @Excel(name = "ERP子库")
    private String erpStoreroom;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdate;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long creator;

    /** "0  成功
1  失败" */
    @Excel(name = "0  成功1  失败")
    private Long movestate;

    /** 库存ID */
    @Excel(name = "库存ID")
    private Long repertoryid;

    /** 项目号 */
    @Excel(name = "项目号")
    private String projectNum;

    public void setMoveinoutid(Long moveinoutid) 
    {
        this.moveinoutid = moveinoutid;
    }

    public Long getMoveinoutid() 
    {
        return moveinoutid;
    }
    public void setInsite(Long insite) 
    {
        this.insite = insite;
    }

    public Long getInsite() 
    {
        return insite;
    }
    public void setOutsite(Long outsite) 
    {
        this.outsite = outsite;
    }

    public Long getOutsite() 
    {
        return outsite;
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

    public void setMovedesc(String movedesc)
    {
        this.movedesc = movedesc;
    }

    public String getMovedesc() 
    {
        return movedesc;
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
    public void setPalletno(String palletno) 
    {
        this.palletno = palletno;
    }

    public String getPalletno() 
    {
        return palletno;
    }
    public void setRepColor(String repColor) 
    {
        this.repColor = repColor;
    }

    public String getRepColor() 
    {
        return repColor;
    }
    public void setRepProperty(String repProperty) 
    {
        this.repProperty = repProperty;
    }

    public String getRepProperty() 
    {
        return repProperty;
    }
    public void setRepOwnerCode(String repOwnerCode) 
    {
        this.repOwnerCode = repOwnerCode;
    }

    public String getRepOwnerCode() 
    {
        return repOwnerCode;
    }
    public void setRepOwnerName(String repOwnerName) 
    {
        this.repOwnerName = repOwnerName;
    }

    public String getRepOwnerName() 
    {
        return repOwnerName;
    }
    public void setRepOrg(String repOrg) 
    {
        this.repOrg = repOrg;
    }

    public String getRepOrg() 
    {
        return repOrg;
    }
    public void setErpStoreroom(String erpStoreroom) 
    {
        this.erpStoreroom = erpStoreroom;
    }

    public String getErpStoreroom() 
    {
        return erpStoreroom;
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
    public void setMovestate(Long movestate) 
    {
        this.movestate = movestate;
    }

    public Long getMovestate() 
    {
        return movestate;
    }
    public void setRepertoryid(Long repertoryid) 
    {
        this.repertoryid = repertoryid;
    }

    public Long getRepertoryid() 
    {
        return repertoryid;
    }
    public void setProjectNum(String projectNum) 
    {
        this.projectNum = projectNum;
    }

    public String getProjectNum() 
    {
        return projectNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("moveinoutid", getMoveinoutid())
            .append("insite", getInsite())
            .append("outsite", getOutsite())
            .append("materialid", getMaterialid())
            .append("batchno", getBatchno())
            .append("sn", getSn())
            .append("qty", getQty())
            .append("movedesc", getMovedesc())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("data5", getData5())
            .append("data6", getData6())
            .append("data7", getData7())
            .append("data8", getData8())
            .append("palletno", getPalletno())
            .append("repColor", getRepColor())
            .append("repProperty", getRepProperty())
            .append("repOwnerCode", getRepOwnerCode())
            .append("repOwnerName", getRepOwnerName())
            .append("repOrg", getRepOrg())
            .append("erpStoreroom", getErpStoreroom())
            .append("createdate", getCreatedate())
            .append("creator", getCreator())
            .append("movestate", getMovestate())
            .append("repertoryid", getRepertoryid())
            .append("projectNum", getProjectNum())
            .toString();
    }
}

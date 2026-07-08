package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

/**
 * 拉式发料商品明细对象 drawmaterial_rf_bill_item
 * 
 * @author ruoyi
 * @date 2023-08-23
 */
public class DrawmaterialRfBillItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 子表主键 */
    private Long drawmaterialRfBillItemid;

    /** 父表主键 */
    @Excel(name = "父表主键")
    private Long drawmaterialRfBillid;

    /** P01-XXXX
P02-XXXX

按P01\P02分组创建出库凭证 */
    @Excel(name = "P01P02分组创建出库凭证")
    private String goodsshelf;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String matcode;

    /** 计划数 */
    @Excel(name = "计划数")
    private BigDecimal planqty;

    /** 完成数 */
    @Excel(name = "完成数")
    private BigDecimal finishqty;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    /** 0:需求提交，1：备货，2：已发，3：取消 */
    @Excel(name = "0:需求提交，1：备货，2：已发，3：取消")
    private String data1;

    /** 出库凭证号 */
    @Excel(name = "出库凭证号")
    private String data2;

    /** 出库单号 */
    @Excel(name = "出库单号")
    private String data3;

    /** ? */
    @Excel(name = "?")
    private String data4;

    /** 领料信息编号 */
    @Excel(name = "领料信息编号")
    private String transactionid;

    /** 组织编号 */
    @Excel(name = "组织编号")
    private String organizationcode;

    /** P库 */
    @Excel(name = "P库")
    private String warehouse;

    /** 产线编号 */
    @Excel(name = "产线编号")
    private String productline;

    /** 工位 */
    @Excel(name = "工位")
    private String workstation;

    public void setDrawmaterialRfBillItemid(Long drawmaterialRfBillItemid) 
    {
        this.drawmaterialRfBillItemid = drawmaterialRfBillItemid;
    }

    public Long getDrawmaterialRfBillItemid() 
    {
        return drawmaterialRfBillItemid;
    }
    public void setDrawmaterialRfBillid(Long drawmaterialRfBillid) 
    {
        this.drawmaterialRfBillid = drawmaterialRfBillid;
    }

    public Long getDrawmaterialRfBillid() 
    {
        return drawmaterialRfBillid;
    }
    public void setGoodsshelf(String goodsshelf) 
    {
        this.goodsshelf = goodsshelf;
    }

    public String getGoodsshelf() 
    {
        return goodsshelf;
    }
    public void setMatcode(String matcode) 
    {
        this.matcode = matcode;
    }

    public String getMatcode() 
    {
        return matcode;
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

    public BigDecimal getPlanqty() {
        return planqty;
    }

    public void setPlanqty(BigDecimal planqty) {
        this.planqty = planqty;
    }

    public BigDecimal getFinishqty() {
        return finishqty;
    }

    public void setFinishqty(BigDecimal finishqty) {
        this.finishqty = finishqty;
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
    public void setTransactionid(String transactionid) 
    {
        this.transactionid = transactionid;
    }

    public String getTransactionid() 
    {
        return transactionid;
    }
    public void setOrganizationcode(String organizationcode) 
    {
        this.organizationcode = organizationcode;
    }

    public String getOrganizationcode() 
    {
        return organizationcode;
    }
    public void setWarehouse(String warehouse) 
    {
        this.warehouse = warehouse;
    }

    public String getWarehouse() 
    {
        return warehouse;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("drawmaterialRfBillItemid", getDrawmaterialRfBillItemid())
            .append("drawmaterialRfBillid", getDrawmaterialRfBillid())
            .append("goodsshelf", getGoodsshelf())
            .append("matcode", getMatcode())
            .append("planqty", getPlanqty())
            .append("finishqty", getFinishqty())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("transactionid", getTransactionid())
            .append("organizationcode", getOrganizationcode())
            .append("warehouse", getWarehouse())
            .append("productline", getProductline())
            .append("workstation", getWorkstation())
            .toString();
    }
}

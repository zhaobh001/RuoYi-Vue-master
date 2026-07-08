package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 入库指令(创建任务intask 和 记账时都有写这个)对象 inorder
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public class Inorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long inorderid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long inbillid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String inorderno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long insite;

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String inbatchno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sn;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long taskqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long finishqty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long createor;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String orderdesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** 用来区别指令时计算自动生成或者其他方式生成的
0：通过单据中新建按钮手动创建
1：根据物料规则系统自动生成
2：采集器采集数据成功登记创建 */
    @Excel(name = "用来区别指令时计算自动生成或者其他方式生成的0：通过单据中新建按钮手动创建1：根据物料规则系统自动生成2：采集器采集数据成功登记创建")
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

    public void setInorderid(Long inorderid) 
    {
        this.inorderid = inorderid;
    }

    public Long getInorderid() 
    {
        return inorderid;
    }
    public void setInbillid(Long inbillid) 
    {
        this.inbillid = inbillid;
    }

    public Long getInbillid() 
    {
        return inbillid;
    }
    public void setInorderno(String inorderno) 
    {
        this.inorderno = inorderno;
    }

    public String getInorderno() 
    {
        return inorderno;
    }
    public void setInsite(Long insite) 
    {
        this.insite = insite;
    }

    public Long getInsite() 
    {
        return insite;
    }
    public void setPalletno(String palletno) 
    {
        this.palletno = palletno;
    }

    public String getPalletno() 
    {
        return palletno;
    }
    public void setInbatchno(String inbatchno) 
    {
        this.inbatchno = inbatchno;
    }

    public String getInbatchno() 
    {
        return inbatchno;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
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
    public void setCreateor(Long createor) 
    {
        this.createor = createor;
    }

    public Long getCreateor() 
    {
        return createor;
    }
    public void setOrderdesc(String orderdesc) 
    {
        this.orderdesc = orderdesc;
    }

    public String getOrderdesc() 
    {
        return orderdesc;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inorderid", getInorderid())
            .append("inbillid", getInbillid())
            .append("inorderno", getInorderno())
            .append("insite", getInsite())
            .append("palletno", getPalletno())
            .append("inbatchno", getInbatchno())
            .append("sn", getSn())
            .append("taskqty", getTaskqty())
            .append("finishqty", getFinishqty())
            .append("createor", getCreateor())
            .append("orderdesc", getOrderdesc())
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
            .append("repColor", getRepColor())
            .append("repProperty", getRepProperty())
            .append("repOwnerCode", getRepOwnerCode())
            .append("repOwnerName", getRepOwnerName())
            .append("repOrg", getRepOrg())
            .append("erpStoreroom", getErpStoreroom())
            .toString();
    }
}

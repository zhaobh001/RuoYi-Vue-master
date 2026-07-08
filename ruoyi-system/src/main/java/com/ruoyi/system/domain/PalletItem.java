package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 托盘物料档案对象 pallet_item
 * 
 * @author ruoyi
 * @date 2023-08-06
 */
public class PalletItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long palletItemid;

    /** 托盘id */
    @Excel(name = "托盘id")
    private Long palletid;

    /** 物料 */
    @Excel(name = "物料")
    private Long itemMaterialid;

    /** 批次 */
    @Excel(name = "批次")
    private String itemBatch;

    /** 序列号 */
    @Excel(name = "序列号")
    private String itemSn;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal itemQty;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    /** 库位ID */
    @Excel(name = "库位ID")
    private String data1;

    /** - */
    @Excel(name = "-")
    private String data2;

    /** - */
    @Excel(name = "-")
    private String data3;

    /** - */
    @Excel(name = "-")
    private String data4;

    /** 任务ID */
    @Excel(name = "任务ID")
    private Long taskid;

    /** 任务号 */
    @Excel(name = "任务号")
    private String taskno;

    /** 凭证单据ID */
    @Excel(name = "凭证单据ID")
    private Long billid;

    /** 凭证单据号 */
    @Excel(name = "凭证单据号")
    private String billno;

    /** 凭证ID */
    @Excel(name = "凭证ID")
    private Long proofid;

    /** 凭证号 */
    @Excel(name = "凭证号")
    private String proofno;

    /** 任务明细 ID */
    @Excel(name = "任务明细 ID")
    private Long taskitemid;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collecttime;

    /** 采集人 */
    @Excel(name = "采集人")
    private Long collector;


    private String matcode;
    private String matname;
    private String palletNo;

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

    public String getPalletNo() {
        return palletNo;
    }

    public void setPalletNo(String palletNo) {
        this.palletNo = palletNo;
    }

    public void setPalletItemid(Long palletItemid)
    {
        this.palletItemid = palletItemid;
    }

    public Long getPalletItemid() 
    {
        return palletItemid;
    }
    public void setPalletid(Long palletid) 
    {
        this.palletid = palletid;
    }

    public Long getPalletid() 
    {
        return palletid;
    }
    public void setItemMaterialid(Long itemMaterialid) 
    {
        this.itemMaterialid = itemMaterialid;
    }

    public Long getItemMaterialid() 
    {
        return itemMaterialid;
    }
    public void setItemBatch(String itemBatch) 
    {
        this.itemBatch = itemBatch;
    }

    public String getItemBatch() 
    {
        return itemBatch;
    }
    public void setItemSn(String itemSn) 
    {
        this.itemSn = itemSn;
    }

    public String getItemSn() 
    {
        return itemSn;
    }

    public BigDecimal getItemQty() {
        return itemQty;
    }

    public void setItemQty(BigDecimal itemQty) {
        this.itemQty = itemQty;
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
    public void setTaskid(Long taskid) 
    {
        this.taskid = taskid;
    }

    public Long getTaskid() 
    {
        return taskid;
    }
    public void setTaskno(String taskno) 
    {
        this.taskno = taskno;
    }

    public String getTaskno() 
    {
        return taskno;
    }
    public void setBillid(Long billid) 
    {
        this.billid = billid;
    }

    public Long getBillid() 
    {
        return billid;
    }
    public void setBillno(String billno) 
    {
        this.billno = billno;
    }

    public String getBillno() 
    {
        return billno;
    }
    public void setProofid(Long proofid) 
    {
        this.proofid = proofid;
    }

    public Long getProofid() 
    {
        return proofid;
    }
    public void setProofno(String proofno) 
    {
        this.proofno = proofno;
    }

    public String getProofno() 
    {
        return proofno;
    }
    public void setTaskitemid(Long taskitemid) 
    {
        this.taskitemid = taskitemid;
    }

    public Long getTaskitemid() 
    {
        return taskitemid;
    }
    public void setCollecttime(Date collecttime) 
    {
        this.collecttime = collecttime;
    }

    public Date getCollecttime() 
    {
        return collecttime;
    }
    public void setCollector(Long collector) 
    {
        this.collector = collector;
    }

    public Long getCollector() 
    {
        return collector;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("palletItemid", palletItemid)
                .append("palletid", palletid)
                .append("itemMaterialid", itemMaterialid)
                .append("itemBatch", itemBatch)
                .append("itemSn", itemSn)
                .append("itemQty", itemQty)
                .append("dataversion", dataversion)
                .append("data1", data1)
                .append("data2", data2)
                .append("data3", data3)
                .append("data4", data4)
                .append("taskid", taskid)
                .append("taskno", taskno)
                .append("billid", billid)
                .append("billno", billno)
                .append("proofid", proofid)
                .append("proofno", proofno)
                .append("taskitemid", taskitemid)
                .append("collecttime", collecttime)
                .append("collector", collector)
                .append("matcode", matcode)
                .append("matname", matname)
                .append("palletNo", palletNo)
                .toString();
    }
}

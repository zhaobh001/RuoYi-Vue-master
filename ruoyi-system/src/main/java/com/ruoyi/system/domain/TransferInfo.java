package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

/**
 * 移库上传数据
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public class TransferInfo
{
    private static final long serialVersionUID = 1L;

    /** 移入库位 */
    @Excel(name = "移入库位")
    private String inSite;

    /** 移出库位 */
    @Excel(name = "移出库位")
    private String outSite;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materialCode;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchNo;

    /** 序列号 */
    @Excel(name = "序列号")
    private String sn;

    /** 采集数量 */
    @Excel(name = "采集数量")
    private BigDecimal qty;

    /** 说明 */
    @Excel(name = "说明")
    private String moveDesc;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplier;

    /** 子库 */
    @Excel(name = "子库")
    private String erpRoom;

    /** 项目号 */
    @Excel(name = "项目号")
    private String projectNum;

    /** 库存ID */
    @Excel(name = "库存ID")
    private Long repertoryId;

    public String getInSite() {
        return inSite;
    }

    public void setInSite(String inSite) {
        this.inSite = inSite;
    }

    public String getOutSite() {
        return outSite;
    }

    public void setOutSite(String outSite) {
        this.outSite = outSite;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getMoveDesc() {
        return moveDesc;
    }

    public void setMoveDesc(String moveDesc) {
        this.moveDesc = moveDesc;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getErpRoom() {
        return erpRoom;
    }

    public void setErpRoom(String erpRoom) {
        this.erpRoom = erpRoom;
    }

    public String getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum;
    }

    public Long getRepertoryId() {
        return repertoryId;
    }

    public void setRepertoryId(Long repertoryId) {
        this.repertoryId = repertoryId;
    }
}

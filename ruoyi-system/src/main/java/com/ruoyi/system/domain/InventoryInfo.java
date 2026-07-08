package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

/**
 * 入库上架采集
 *
 * @author ruoyi
 * @date 2023-07-04
 */
public class InventoryInfo
{
    private static final long serialVersionUID = 1L;

    private String TaskComment;
    private String matCode;
    private String batchNo;
    private String sn;
    private BigDecimal collectQty;
    private String storeRoomNo;
    private String storeSiteNo;
    private String desc;
    private String invTaskItemid;
    private String materialId;
    private String trayNo;

    public String getTaskComment() {
        return TaskComment;
    }

    public void setTaskComment(String taskComment) {
        TaskComment = taskComment;
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode;
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

    public BigDecimal getCollectQty() {
        return collectQty;
    }

    public void setCollectQty(BigDecimal collectQty) {
        this.collectQty = collectQty;
    }

    public String getStoreRoomNo() {
        return storeRoomNo;
    }

    public void setStoreRoomNo(String storeRoomNo) {
        this.storeRoomNo = storeRoomNo;
    }

    public String getStoreSiteNo() {
        return storeSiteNo;
    }

    public void setStoreSiteNo(String storeSiteNo) {
        this.storeSiteNo = storeSiteNo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getInvTaskItemid() {
        return invTaskItemid;
    }

    public void setInvTaskItemid(String invTaskItemid) {
        this.invTaskItemid = invTaskItemid;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getTrayNo() {
        return trayNo;
    }

    public void setTrayNo(String trayNo) {
        this.trayNo = trayNo;
    }
}

package com.ruoyi.system.domain;

import java.math.BigDecimal;

/**
 * 入库上架采集
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public class ExceptShelvesInfo
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
    private String taskNo;
    private BigDecimal taskQty;
    private String type;
    private String data1;
    private String data2;
    private String data3;
    private String data4;
    private String taskid;
    private String proofNo;
    private String excepttype;
    private String protype;
    private String palletNo;

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public BigDecimal getTaskQty() {
        return taskQty;
    }

    public void setTaskQty(BigDecimal taskQty) {
        this.taskQty = taskQty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getProofNo() {
        return proofNo;
    }

    public void setProofNo(String proofNo) {
        this.proofNo = proofNo;
    }

    public String getExcepttype() {
        return excepttype;
    }

    public void setExcepttype(String excepttype) {
        this.excepttype = excepttype;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public String getPalletNo() {
        return palletNo;
    }

    public void setPalletNo(String palletNo) {
        this.palletNo = palletNo;
    }

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

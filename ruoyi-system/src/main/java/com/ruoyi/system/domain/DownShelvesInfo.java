package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

/**
 * 入库上架采集
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public class DownShelvesInfo
{
    private static final long serialVersionUID = 1L;

    private String taskNo;
    private String matCode;
    private String batchNo ;
    private String sn;
    private BigDecimal taskQty;
    private BigDecimal collectQty;
    private String storeRoomNo;
    private String storeSiteNo;
    private String storeSiteFlag;
    private String BatchNoFlag;
    private String desc;
    private String data1;
    private String data2;
    private String data3;
    private String data4;
    private String outTaskItemid;
    private String erpStore;
    private String trayNo;
    private String productionDate;

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getTrayNo() {
        return trayNo;
    }

    public void setTrayNo(String trayNo) {
        this.trayNo = trayNo;
    }

    public String getErpStore() {
        return erpStore;
    }

    public void setErpStore(String erpStore) {
        this.erpStore = erpStore;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
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

    public BigDecimal getTaskQty() {
        return taskQty;
    }

    public void setTaskQty(BigDecimal taskQty) {
        this.taskQty = taskQty;
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

    public String getStoreSiteFlag() {
        return storeSiteFlag;
    }

    public void setStoreSiteFlag(String storeSiteFlag) {
        this.storeSiteFlag = storeSiteFlag;
    }

    public String getBatchNoFlag() {
        return BatchNoFlag;
    }

    public void setBatchNoFlag(String batchNoFlag) {
        BatchNoFlag = batchNoFlag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getOutTaskItemid() {
        return outTaskItemid;
    }

    public void setOutTaskItemid(String outTaskItemid) {
        this.outTaskItemid = outTaskItemid;
    }
}

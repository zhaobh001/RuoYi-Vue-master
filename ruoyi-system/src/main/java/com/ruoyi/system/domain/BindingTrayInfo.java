package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

/**
 * 入库上架采集
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public class BindingTrayInfo
{
    private static final long serialVersionUID = 1L;

    /** 采集任务编码 */
    @Excel(name = "采集任务编码")
    private String taskNo;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String matCode;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchNo;

    /** 序列号 */
    @Excel(name = "序列号")
    private String sn;

    /** 任务数量 */
    @Excel(name = "任务数量")
    private Long taskQty;

    /** 采集数量 */
    @Excel(name = "采集数量")
    private BigDecimal collectQty;

    /** 子库编码 */
    @Excel(name = "子库编码")
    private String storeRoomNo;

    /** 库位编码 */
    @Excel(name = "库位编码")
    private String storeSiteNo;

    /** desc */
    @Excel(name = "desc")
    private String desc;

    /** data1 */
    @Excel(name = "data1")
    private String data1;

    /** data2 */
    @Excel(name = "data2")
    private String data2;

    /** data3 */
    @Excel(name = "data3")
    private String data3;

    /** data4 */
    @Excel(name = "data4")
    private String data4;

    /** 入库任务明细 */
    @Excel(name = "入库任务明细")
    private String inTaskItemid;

    /** 物料ID */
    @Excel(name = "物料ID")
    private String materialId;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 待入库任务ID */
    @Excel(name = "待入库任务ID")
    private String taskid;

    /** 匹配任性 */
    @Excel(name = "匹配任性")
    private String matchingFlg;

    private String trayNo;

    public String getTrayNo() {
        return trayNo;
    }

    public void setTrayNo(String trayNo) {
        this.trayNo = trayNo;
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

    public Long getTaskQty() {
        return taskQty;
    }

    public void setTaskQty(Long taskQty) {
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

    public String getInTaskItemid() {
        return inTaskItemid;
    }

    public void setInTaskItemid(String inTaskItemid) {
        this.inTaskItemid = inTaskItemid;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getMatchingFlg() {
        return matchingFlg;
    }

    public void setMatchingFlg(String matchingFlg) {
        this.matchingFlg = matchingFlg;
    }
}

package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.List;

public class DownShelvesInfoReq {
    private List<DownShelvesInfo> downShelvesInfos;
    private List<ItemListInfo> itemListInfos;
    private List<InventoryInfo> inventoryInfos;
    private List<ExceptShelvesInfo> exceptShelvesInfos;
    private List<InvCheckInfos> invCheckInfos;

    public List<InvCheckInfos> getInvCheckInfos() {
        return invCheckInfos;
    }

    public void setInvCheckInfos(List<InvCheckInfos> invCheckInfos) {
        this.invCheckInfos = invCheckInfos;
    }

    private String filter;
    private String taskNo;
    private String trayNo;
    private BigDecimal currentWeight;
    private BigDecimal currentCapacity;

    private List<Long> intaskitemids;
    private String roomTag;
    private String isCanel;
    private List<Long> outtaskitemids;

    private String taskComment;

    public List<ExceptShelvesInfo> getExceptShelvesInfos() {
        return exceptShelvesInfos;
    }

    public void setExceptShelvesInfos(List<ExceptShelvesInfo> exceptShelvesInfos) {
        this.exceptShelvesInfos = exceptShelvesInfos;
    }

    public String getTaskComment() {
        return taskComment;
    }

    public void setTaskComment(String taskComment) {
        this.taskComment = taskComment;
    }

    public List<InventoryInfo> getInventoryInfos() {
        return inventoryInfos;
    }

    public void setInventoryInfos(List<InventoryInfo> inventoryInfos) {
        this.inventoryInfos = inventoryInfos;
    }

    public List<Long> getOuttaskitemids() {
        return outtaskitemids;
    }

    public void setOuttaskitemids(List<Long> outtaskitemids) {
        this.outtaskitemids = outtaskitemids;
    }

    public List<Long> getIntaskitemids() {
        return intaskitemids;
    }

    public void setIntaskitemids(List<Long> intaskitemids) {
        this.intaskitemids = intaskitemids;
    }

    public String getRoomTag() {
        return roomTag;
    }

    public void setRoomTag(String roomTag) {
        this.roomTag = roomTag;
    }

    public String getIsCanel() {
        return isCanel;
    }

    public void setIsCanel(String isCanel) {
        this.isCanel = isCanel;
    }

    public List<ItemListInfo> getItemListInfos() {
        return itemListInfos;
    }

    public void setItemListInfos(List<ItemListInfo> itemListInfos) {
        this.itemListInfos = itemListInfos;
    }

    public List<DownShelvesInfo> getDownShelvesInfos() {
        return downShelvesInfos;
    }

    public void setDownShelvesInfos(List<DownShelvesInfo> downShelvesInfos) {
        this.downShelvesInfos = downShelvesInfos;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getTrayNo() {
        return trayNo;
    }

    public void setTrayNo(String trayNo) {
        this.trayNo = trayNo;
    }

    public BigDecimal getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(BigDecimal currentWeight) {
        this.currentWeight = currentWeight;
    }

    public BigDecimal getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(BigDecimal currentCapacity) {
        this.currentCapacity = currentCapacity;
    }
}

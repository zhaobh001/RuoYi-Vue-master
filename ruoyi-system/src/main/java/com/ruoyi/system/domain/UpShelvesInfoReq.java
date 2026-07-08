package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.List;

public class UpShelvesInfoReq {
    private List<UpShelvesInfo> upShelvesInfos;
    private List<ItemListInfo> itemListInfos;
    private List<MtlSenderInfo> mtlSenderInfos;
    private List<BindingTrayInfo> trayInfos;
    private List<TransferInfo> transferInfos;

    private String filter;
    private String taskNo;
    private String trayNo;
    private BigDecimal currentWeight;
    private BigDecimal currentCapacity;

    private List<Long> intaskitemids;
    private String roomTag;
    private String isCanel;
    private List<Long> outtaskitemids;

    public List<TransferInfo> getTransferInfos() {
        return transferInfos;
    }

    public void setTransferInfos(List<TransferInfo> transferInfos) {
        this.transferInfos = transferInfos;
    }

    public List<BindingTrayInfo> getTrayInfos() {
        return trayInfos;
    }

    public void setTrayInfos(List<BindingTrayInfo> trayInfos) {
        this.trayInfos = trayInfos;
    }

    public List<MtlSenderInfo> getMtlSenderInfos() {
        return mtlSenderInfos;
    }

    public void setMtlSenderInfos(List<MtlSenderInfo> mtlSenderInfos) {
        this.mtlSenderInfos = mtlSenderInfos;
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

    public List<UpShelvesInfo> getUpShelvesInfos() {
        return upShelvesInfos;
    }

    public void setUpShelvesInfos(List<UpShelvesInfo> upShelvesInfos) {
        this.upShelvesInfos = upShelvesInfos;
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
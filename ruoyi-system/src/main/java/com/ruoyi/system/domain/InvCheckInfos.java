package com.ruoyi.system.domain;

import java.math.BigDecimal;

/**
 * 入库上架采集
 *
 * @author ruoyi
 * @date 2023-07-04
 */
public class InvCheckInfos
{
    private static final long serialVersionUID = 1L;

    private String stockid;
    private String matCode;
    private String trayNo;
    private String storeSiteNo;
    private String storeSite;
    private BigDecimal collectQty;

    public String getStoreSite() {
        return storeSite;
    }

    public void setStoreSite(String storeSite) {
        this.storeSite = storeSite;
    }

    public String getStockid() {
        return stockid;
    }

    public void setStockid(String stockid) {
        this.stockid = stockid;
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode;
    }

    public String getTrayNo() {
        return trayNo;
    }

    public void setTrayNo(String trayNo) {
        this.trayNo = trayNo;
    }

    public String getStoreSiteNo() {
        return storeSiteNo;
    }

    public void setStoreSiteNo(String storeSiteNo) {
        this.storeSiteNo = storeSiteNo;
    }

    public BigDecimal getCollectQty() {
        return collectQty;
    }

    public void setCollectQty(BigDecimal collectQty) {
        this.collectQty = collectQty;
    }
}

package com.ruoyi.system.domain;

import java.math.BigDecimal;

/**
 * 入库上架采集
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public class MtlSenderInfo
{
    private static final long serialVersionUID = 1L;

    private String locationNo;
    private String matCode;
    private String subCode ;
    private String subTranferCode;
    private String batchNo;
    private BigDecimal qty;

    public String getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo;
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubTranferCode() {
        return subTranferCode;
    }

    public void setSubTranferCode(String subTranferCode) {
        this.subTranferCode = subTranferCode;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
}

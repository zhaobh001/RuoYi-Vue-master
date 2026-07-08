package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

/**
 * 入库上架采集
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public class ItemListInfo
{
    private static final long serialVersionUID = 1L;

    /** 采集任务编码 */
    @Excel(name = "入库任务ID")
    private String inTaskItemid;

    private String outTaskItemid;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String mtlCode;

    /** 批次号 */
    @Excel(name = "批次号")
    private String[] mtlQty;

    public String getInTaskItemid() {
        return inTaskItemid;
    }

    public String getOutTaskItemid() {
        return outTaskItemid;
    }

    public void setOutTaskItemid(String outTaskItemid) {
        this.outTaskItemid = outTaskItemid;
    }

    public void setInTaskItemid(String inTaskItemid) {
        this.inTaskItemid = inTaskItemid;
    }

    public String getMtlCode() {
        return mtlCode;
    }

    public void setMtlCode(String mtlCode) {
        this.mtlCode = mtlCode;
    }

    public String[] getMtlQty() {
        return mtlQty;
    }

    public void setMtlQty(String[] mtlQty) {
        this.mtlQty = mtlQty;
    }
}

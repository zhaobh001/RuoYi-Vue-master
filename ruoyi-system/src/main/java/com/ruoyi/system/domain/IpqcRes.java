package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 入库采集数据对象 incollectdata
 *
 * @author ruoyi
 * @date 2023-07-30
 */
public class IpqcRes
{
    private static final long serialVersionUID = 1L;


    private String ipqcno;
    private String transno;
    private String supplier;
    private String responsible;
    private String nonconforming;
    private String disposal;

    private String receive_name;
    private String receive_stock_site_code;
    private String receive_site_code;
    private String receive_site_name;
    private String receive_project_code;

    private String receive_address;

    public String getReceive_address() {
        return receive_address;
    }

    public void setReceive_address(String receive_address) {
        this.receive_address = receive_address;
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name;
    }

    public String getReceive_stock_site_code() {
        return receive_stock_site_code;
    }

    public void setReceive_stock_site_code(String receive_stock_site_code) {
        this.receive_stock_site_code = receive_stock_site_code;
    }

    public String getReceive_site_code() {
        return receive_site_code;
    }

    public void setReceive_site_code(String receive_site_code) {
        this.receive_site_code = receive_site_code;
    }

    public String getReceive_site_name() {
        return receive_site_name;
    }

    public void setReceive_site_name(String receive_site_name) {
        this.receive_site_name = receive_site_name;
    }

    public String getReceive_project_code() {
        return receive_project_code;
    }

    public void setReceive_project_code(String receive_project_code) {
        this.receive_project_code = receive_project_code;
    }

    public String getIpqcno() {
        return ipqcno;
    }

    public void setIpqcno(String ipqcno) {
        this.ipqcno = ipqcno;
    }

    public String getTransno() {
        return transno;
    }

    public void setTransno(String transno) {
        this.transno = transno;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getNonconforming() {
        return nonconforming;
    }

    public void setNonconforming(String nonconforming) {
        this.nonconforming = nonconforming;
    }

    public String getDisposal() {
        return disposal;
    }

    public void setDisposal(String disposal) {
        this.disposal = disposal;
    }
}

package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 入库采集数据对象 incollectdata
 *
 * @author ruoyi
 * @date 2023-07-30
 */
public class IncollectdataRes extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    private BigDecimal value;
    private String name;



    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

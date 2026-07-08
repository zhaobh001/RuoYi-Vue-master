package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 立体库出入口档案对象 sterrooutexit
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public class Sterrooutexit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long sterrooutexitid;

    /** 编号 */
    @Excel(name = "编号")
    private String exitcode;

    /** 说明 */
    @Excel(name = "说明")
    private String exitname;

    /** 0:正常出库口
1:拣货出库口
2:组盘入库口 */
    @Excel(name = "0:正常出库口1:拣货出库口2:组盘入库口")
    private String type;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    /** - */
    @Excel(name = "-")
    private String data1;

    /** - */
    @Excel(name = "-")
    private String data2;

    /** - */
    @Excel(name = "-")
    private String data3;

    /** - */
    @Excel(name = "-")
    private String data4;

    public void setSterrooutexitid(Long sterrooutexitid) 
    {
        this.sterrooutexitid = sterrooutexitid;
    }

    public Long getSterrooutexitid() 
    {
        return sterrooutexitid;
    }
    public void setExitcode(String exitcode) 
    {
        this.exitcode = exitcode;
    }

    public String getExitcode() 
    {
        return exitcode;
    }
    public void setExitname(String exitname) 
    {
        this.exitname = exitname;
    }

    public String getExitname() 
    {
        return exitname;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setDataversion(Long dataversion) 
    {
        this.dataversion = dataversion;
    }

    public Long getDataversion() 
    {
        return dataversion;
    }
    public void setData1(String data1) 
    {
        this.data1 = data1;
    }

    public String getData1() 
    {
        return data1;
    }
    public void setData2(String data2) 
    {
        this.data2 = data2;
    }

    public String getData2() 
    {
        return data2;
    }
    public void setData3(String data3) 
    {
        this.data3 = data3;
    }

    public String getData3() 
    {
        return data3;
    }
    public void setData4(String data4) 
    {
        this.data4 = data4;
    }

    public String getData4() 
    {
        return data4;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sterrooutexitid", getSterrooutexitid())
            .append("exitcode", getExitcode())
            .append("exitname", getExitname())
            .append("type", getType())
            .append("remark", getRemark())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .toString();
    }
}

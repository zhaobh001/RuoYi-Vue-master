package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 库位对象 storesite
 * 
 * @author ruoyi
 * @date 2023-08-04
 */
public class Storesite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long storesiteid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long storeroomid;

    /** (1-4区;  5-6倍;  7-8排;  9-10层) */
    @Excel(name = "(1-4区;  5-6倍;  7-8排;  9-10层)")
    private String storesiteno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String storesitename;

    /** 0：正常
1：冻结
2：锁定3：占用 */
    @Excel(name = "0：正常1：冻结2：锁定3：占用")
    private String isfrozen;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long length;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long width;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long height;

    /** 限重量 */
    @Excel(name = "限重量")
    private Long limitedweight;

    /** 当前重量 */
    @Excel(name = "当前重量")
    private Long currentweight;

    /** 单位容积 */
    @Excel(name = "单位容积")
    private Long plotratio;

    /** 当前容积率 */
    @Excel(name = "当前容积率")
    private Long currentplot;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String stackingno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String velocity;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String highness;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String floors;

    /** 0：WMS
1：外系统 */
    @Excel(name = "0：WMS1：外系统")
    private Long issystem;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String storesitedesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data4;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data5;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data6;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data7;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data8;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data9;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data10;

    /** 0：否  1：是 */
    @Excel(name = "0：否  1：是")
    private String ispallettempsite;

    /** 重量等级：1：<= 400kg   2：<= 500kg  3：< =100kg */
    @Excel(name = "重量等级：1：<= 400kg   2：<= 500kg  3：< =100kg")
    private String weightGrade;

    /** 高度等级：1：< =560mm  2：<= 1160mm */
    @Excel(name = "高度等级：1：< =560mm  2：<= 1160mm")
    private String highGrade;

    /** 物料类型控制:  标准件 = 0,辅料 = 1 */
    @Excel(name = "物料类型控制:  标准件 = 0,辅料 = 1")
    private Long mattypecontrol;

    /** 货位类型控制:  货架货位 = 0,临时货位 = 1 */
    @Excel(name = "货位类型控制:  货架货位 = 0,临时货位 = 1")
    private Long storesitetype;

    /** 货位优先次序 */
    @Excel(name = "货位优先次序")
    private Long storesiteorder;

    /** 冷藏箱? */
    @Excel(name = "冷藏箱?")
    private String ystRfstatus;

    /** 在场箱ID */
    @Excel(name = "在场箱ID")
    private Long ystIycCntrid;

    /** 倍ID */
    @Excel(name = "倍ID")
    private Long ystYbyBayid;

    /** 所属客户ID */
    @Excel(name = "所属客户ID")
    private Long ystCstmid;

    /** 排 */
    @Excel(name = "排")
    private String ystRowno;

    /** 层 */
    @Excel(name = "层")
    private String ystTierno;

    /** 占位状态;RV_Main=占位状态 */
    @Excel(name = "占位状态;RV_Main=占位状态")
    private String ystOccurfg;

    /** 限容积率 */
    @Excel(name = "限容积率")
    private Long limitedplot;

    /** 剩余的积率 */
    @Excel(name = "剩余的积率")
    private Long remainplot;

    /** 0：空闲
 1：占用 */
    @Excel(name = "0：空闲 1：占用")
    private Long issiteuse;

    public void setStoresiteid(Long storesiteid) 
    {
        this.storesiteid = storesiteid;
    }

    public Long getStoresiteid() 
    {
        return storesiteid;
    }
    public void setStoreroomid(Long storeroomid) 
    {
        this.storeroomid = storeroomid;
    }

    public Long getStoreroomid() 
    {
        return storeroomid;
    }
    public void setStoresiteno(String storesiteno) 
    {
        this.storesiteno = storesiteno;
    }

    public String getStoresiteno() 
    {
        return storesiteno;
    }
    public void setStoresitename(String storesitename) 
    {
        this.storesitename = storesitename;
    }

    public String getStoresitename() 
    {
        return storesitename;
    }
    public void setIsfrozen(String isfrozen) 
    {
        this.isfrozen = isfrozen;
    }

    public String getIsfrozen() 
    {
        return isfrozen;
    }
    public void setLength(Long length) 
    {
        this.length = length;
    }

    public Long getLength() 
    {
        return length;
    }
    public void setWidth(Long width) 
    {
        this.width = width;
    }

    public Long getWidth() 
    {
        return width;
    }
    public void setHeight(Long height) 
    {
        this.height = height;
    }

    public Long getHeight() 
    {
        return height;
    }
    public void setLimitedweight(Long limitedweight) 
    {
        this.limitedweight = limitedweight;
    }

    public Long getLimitedweight() 
    {
        return limitedweight;
    }
    public void setCurrentweight(Long currentweight) 
    {
        this.currentweight = currentweight;
    }

    public Long getCurrentweight() 
    {
        return currentweight;
    }
    public void setPlotratio(Long plotratio) 
    {
        this.plotratio = plotratio;
    }

    public Long getPlotratio() 
    {
        return plotratio;
    }
    public void setCurrentplot(Long currentplot) 
    {
        this.currentplot = currentplot;
    }

    public Long getCurrentplot() 
    {
        return currentplot;
    }
    public void setStackingno(String stackingno) 
    {
        this.stackingno = stackingno;
    }

    public String getStackingno() 
    {
        return stackingno;
    }
    public void setVelocity(String velocity) 
    {
        this.velocity = velocity;
    }

    public String getVelocity() 
    {
        return velocity;
    }
    public void setHighness(String highness) 
    {
        this.highness = highness;
    }

    public String getHighness() 
    {
        return highness;
    }
    public void setFloors(String floors) 
    {
        this.floors = floors;
    }

    public String getFloors() 
    {
        return floors;
    }
    public void setIssystem(Long issystem) 
    {
        this.issystem = issystem;
    }

    public Long getIssystem() 
    {
        return issystem;
    }
    public void setStoresitedesc(String storesitedesc) 
    {
        this.storesitedesc = storesitedesc;
    }

    public String getStoresitedesc() 
    {
        return storesitedesc;
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
    public void setData5(String data5) 
    {
        this.data5 = data5;
    }

    public String getData5() 
    {
        return data5;
    }
    public void setData6(String data6) 
    {
        this.data6 = data6;
    }

    public String getData6() 
    {
        return data6;
    }
    public void setData7(String data7) 
    {
        this.data7 = data7;
    }

    public String getData7() 
    {
        return data7;
    }
    public void setData8(String data8) 
    {
        this.data8 = data8;
    }

    public String getData8() 
    {
        return data8;
    }
    public void setData9(String data9) 
    {
        this.data9 = data9;
    }

    public String getData9() 
    {
        return data9;
    }
    public void setData10(String data10) 
    {
        this.data10 = data10;
    }

    public String getData10() 
    {
        return data10;
    }
    public void setIspallettempsite(String ispallettempsite) 
    {
        this.ispallettempsite = ispallettempsite;
    }

    public String getIspallettempsite() 
    {
        return ispallettempsite;
    }
    public void setWeightGrade(String weightGrade) 
    {
        this.weightGrade = weightGrade;
    }

    public String getWeightGrade() 
    {
        return weightGrade;
    }
    public void setHighGrade(String highGrade) 
    {
        this.highGrade = highGrade;
    }

    public String getHighGrade() 
    {
        return highGrade;
    }
    public void setMattypecontrol(Long mattypecontrol) 
    {
        this.mattypecontrol = mattypecontrol;
    }

    public Long getMattypecontrol() 
    {
        return mattypecontrol;
    }
    public void setStoresitetype(Long storesitetype) 
    {
        this.storesitetype = storesitetype;
    }

    public Long getStoresitetype() 
    {
        return storesitetype;
    }
    public void setStoresiteorder(Long storesiteorder) 
    {
        this.storesiteorder = storesiteorder;
    }

    public Long getStoresiteorder() 
    {
        return storesiteorder;
    }
    public void setYstRfstatus(String ystRfstatus) 
    {
        this.ystRfstatus = ystRfstatus;
    }

    public String getYstRfstatus() 
    {
        return ystRfstatus;
    }
    public void setYstIycCntrid(Long ystIycCntrid) 
    {
        this.ystIycCntrid = ystIycCntrid;
    }

    public Long getYstIycCntrid() 
    {
        return ystIycCntrid;
    }
    public void setYstYbyBayid(Long ystYbyBayid) 
    {
        this.ystYbyBayid = ystYbyBayid;
    }

    public Long getYstYbyBayid() 
    {
        return ystYbyBayid;
    }
    public void setYstCstmid(Long ystCstmid) 
    {
        this.ystCstmid = ystCstmid;
    }

    public Long getYstCstmid() 
    {
        return ystCstmid;
    }
    public void setYstRowno(String ystRowno) 
    {
        this.ystRowno = ystRowno;
    }

    public String getYstRowno() 
    {
        return ystRowno;
    }
    public void setYstTierno(String ystTierno) 
    {
        this.ystTierno = ystTierno;
    }

    public String getYstTierno() 
    {
        return ystTierno;
    }
    public void setYstOccurfg(String ystOccurfg) 
    {
        this.ystOccurfg = ystOccurfg;
    }

    public String getYstOccurfg() 
    {
        return ystOccurfg;
    }
    public void setLimitedplot(Long limitedplot) 
    {
        this.limitedplot = limitedplot;
    }

    public Long getLimitedplot() 
    {
        return limitedplot;
    }
    public void setRemainplot(Long remainplot) 
    {
        this.remainplot = remainplot;
    }

    public Long getRemainplot() 
    {
        return remainplot;
    }
    public void setIssiteuse(Long issiteuse) 
    {
        this.issiteuse = issiteuse;
    }

    public Long getIssiteuse() 
    {
        return issiteuse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("storesiteid", getStoresiteid())
            .append("storeroomid", getStoreroomid())
            .append("storesiteno", getStoresiteno())
            .append("storesitename", getStoresitename())
            .append("isfrozen", getIsfrozen())
            .append("length", getLength())
            .append("width", getWidth())
            .append("height", getHeight())
            .append("limitedweight", getLimitedweight())
            .append("currentweight", getCurrentweight())
            .append("plotratio", getPlotratio())
            .append("currentplot", getCurrentplot())
            .append("stackingno", getStackingno())
            .append("velocity", getVelocity())
            .append("highness", getHighness())
            .append("floors", getFloors())
            .append("issystem", getIssystem())
            .append("storesitedesc", getStoresitedesc())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("data5", getData5())
            .append("data6", getData6())
            .append("data7", getData7())
            .append("data8", getData8())
            .append("data9", getData9())
            .append("data10", getData10())
            .append("ispallettempsite", getIspallettempsite())
            .append("weightGrade", getWeightGrade())
            .append("highGrade", getHighGrade())
            .append("mattypecontrol", getMattypecontrol())
            .append("storesitetype", getStoresitetype())
            .append("storesiteorder", getStoresiteorder())
            .append("ystRfstatus", getYstRfstatus())
            .append("ystIycCntrid", getYstIycCntrid())
            .append("ystYbyBayid", getYstYbyBayid())
            .append("ystCstmid", getYstCstmid())
            .append("ystRowno", getYstRowno())
            .append("ystTierno", getYstTierno())
            .append("ystOccurfg", getYstOccurfg())
            .append("limitedplot", getLimitedplot())
            .append("remainplot", getRemainplot())
            .append("issiteuse", getIssiteuse())
            .toString();
    }
}

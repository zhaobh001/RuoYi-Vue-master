package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 物料对象 pm_material
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public class PmMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long pmMaterialid;

    /** 对应的PM_MATTYPE类型,值都是153 */
    @Excel(name = "对应的PM_MATTYPE类型,值都是153")
    private Long pmMattypeid;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private String matcode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String matname;

    /** 物料规格 */
    @Excel(name = "物料规格")
    private String matmodel;

    /** 图号 */
    @Excel(name = "图号")
    private String matdrawingno;

    /** 主计量单位 */
    @Excel(name = "主计量单位")
    private Long matunit;

    /** ?内部编号 */
    @Excel(name = "?内部编号")
    private String matinnercode;

    /** ?客户定义码,可用来存旧编码 */
    @Excel(name = "?客户定义码,可用来存旧编码")
    private String matcustomcode;

    /** 条码 */
    @Excel(name = "条码")
    private String matupc;

    /** ?数据状态 */
    @Excel(name = "?数据状态")
    private Long matdatastate;

    /** 单长 */
    @Excel(name = "单长")
    private Long matweimeter;

    /** ?物料详细说明 */
    @Excel(name = "?物料详细说明")
    private String matdetail;

    /** ? */
    @Excel(name = "?")
    private Long matsort;

    /** 0：原料
1：半成品
2：成品 */
    @Excel(name = "0：原料1：半成品2：成品")
    private Long matstate;

    /** 归属的物料类 */
    @Excel(name = "归属的物料类")
    private String mattype;

    /** 序列控制 = 0,
批次控制 = 1,
无控制 = 2 */
    @Excel(name = "序列控制 = 0,批次控制 = 1,无控制 = 2")
    private Long matcodecontrol;

    /** 包装数量 */
    @Excel(name = "包装数量")
    private Long matqtypacket;

    /** 标准批量 */
    @Excel(name = "标准批量")
    private Long matqtybox;

    /** ?批次数共有几个批次 */
    @Excel(name = "?批次数共有几个批次")
    private Long matlotqty;

    /** 最新修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最新修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date matupdated;

    /** 最新修改人 */
    @Excel(name = "最新修改人")
    private Long matuuser;

    /** ?最少烘烤时间 */
    @Excel(name = "?最少烘烤时间")
    private Long matminiroasttime;

    /** ? */
    @Excel(name = "?")
    private Long matmaxroast;

    /** ? */
    @Excel(name = "?")
    private Long matmaxrepar;

    /** 备注 */
    @Excel(name = "备注")
    private String matdescription;

    /** ?件内数量 */
    @Excel(name = "?件内数量")
    private String matpackreq;

    /** ? */
    @Excel(name = "?")
    private String matreq1;

    /** ? */
    @Excel(name = "?")
    private String matreq2;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    /** ? */
    @Excel(name = "?")
    private String data1;

    /** ? */
    @Excel(name = "?")
    private String data2;

    /** ? */
    @Excel(name = "?")
    private String data3;

    /** ? */
    @Excel(name = "?")
    private String data4;

    /** ? */
    @Excel(name = "?")
    private String data5;

    /** ? */
    @Excel(name = "?")
    private String data6;

    /** ? */
    @Excel(name = "?")
    private String data7;

    /** ? */
    @Excel(name = "?")
    private String data8;

    /** ? */
    @Excel(name = "?")
    private String data9;

    /** ? */
    @Excel(name = "?")
    private String data10;

    /** 收退标准 */
    @Excel(name = "收退标准")
    private String oqcstandard;

    /** 入库检, 0是1否 */
    @Excel(name = "入库检, 0是1否")
    private Long storagecheck;

    /** ?是否打收货标签 */
    @Excel(name = "?是否打收货标签")
    private Long printreceivelabel;

    /** ?工类型 */
    @Excel(name = "?工类型")
    private Long worktype;

    /** 最小库存 */
    @Excel(name = "最小库存")
    private Long minrep;

    /** 最大库存 */
    @Excel(name = "最大库存")
    private Long maxrep;

    /** 保质期（天数）库存有效期 */
    @Excel(name = "保质期", readConverterExp = "天=数")
    private String deadline;

    /** 库存冲减原则 0-FIFO 其他-
FILO */
    @Excel(name = "库存冲减原则 0-FIFO 其他-FILO")
    private String outtype;

    /** 0：正常
1：冻结
2：锁定 */
    @Excel(name = "0：正常1：冻结2：锁定")
    private String isfrozen;

    /** 默认库房 */
    @Excel(name = "默认库房")
    private Long defaultroom;

    /** 默认库位 */
    @Excel(name = "默认库位")
    private Long defaultsite;

    /** Y   批次管理
N  非批次管理

注：批次管理和单件管理互斥 */
    @Excel(name = "Y   批次管理N  非批次管理注：批次管理和单件管理互斥")
    private String isbatch;

    /** Y   单件管理
N  非单件管理

注：批次管理和单件管理互斥 */
    @Excel(name = "Y   单件管理N  非单件管理注：批次管理和单件管理互斥")
    private String issingle;

    /** 次计量单位 */
    @Excel(name = "次计量单位")
    private String secondunit;

    /** 主单位当前库存数 */
    @Excel(name = "主单位当前库存数")
    private Long mainunitrep;

    /** 第一单位 换算为 第二单位的比重（如   0.8）
第一单位：100 KG   第二单位：100 *0.8 = 80 */
    @Excel(name = "第一单位 换算为 第二单位的比重", readConverterExp = "如=,0=.8")
    private Long unitrate;

    /** 次单位库存数量 */
    @Excel(name = "次单位库存数量")
    private Long secunitrep;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String issystem;

    /** 内包装数 */
    @Excel(name = "内包装数")
    private Long innerpackages;

    /** 箱包装数 */
    @Excel(name = "箱包装数")
    private Long boxpackages;

    /** 托盘包装数 */
    @Excel(name = "托盘包装数")
    private Long palletpackages;

    /** 长 */
    @Excel(name = "长")
    private BigDecimal length;

    /** 宽 */
    @Excel(name = "宽")
    private BigDecimal width;

    /** 高 */
    @Excel(name = "高")
    private BigDecimal height;

    /** 周转速度 */
    @Excel(name = "周转速度")
    private String velocity;

    /** 高低货架H/L */
    @Excel(name = "高低货架H/L")
    private String highness;

    /** 单重 */
    @Excel(name = "单重")
    private BigDecimal matweisingle;

    /** 是否需要配盘Y：是
N：否 */
    @Excel(name = "是否需要配盘Y：是N：否")
    private String isplate;

    /** 分类1 */
    @Excel(name = "分类1")
    private String assortment1;

    /** 分类2 */
    @Excel(name = "分类2")
    private String assortment2;

    /** 分类3 */
    @Excel(name = "分类3")
    private String assortment3;

    /** 分类4 */
    @Excel(name = "分类4")
    private String assortment4;

    /** ABC分类 */
    @Excel(name = "ABC分类")
    private String assortmentAbc;

    /** 物料类型控制 "标准件 = 0,
辅料 = 1,2其他" */
    @Excel(name = "物料类型控制 标准件 = 0,辅料 = 1,2其他")
    private Long mattypecontrol;

    /** 存储类别 */
    @Excel(name = "存储类别")
    private String storageType;

    /** 质量类别 */
    @Excel(name = "质量类别")
    private String qualityType;

    /** 物料采集方式 0：单件 
1：套 */
    @Excel(name = "物料采集方式 0：单件 1：套")
    private Long matsendcontrol;

    /** 物料存储属性1:平库小件物料;2:平库大件物料;3:立体库存储物料 */
    @Excel(name = "物料存储属性1:平库小件物料;2:平库大件物料;3:立体库存储物料")
    private String storetype;

    public Long getPmMaterialid() {
        return pmMaterialid;
    }

    public void setPmMaterialid(Long pmMaterialid) {
        this.pmMaterialid = pmMaterialid;
    }

    public Long getPmMattypeid() {
        return pmMattypeid;
    }

    public void setPmMattypeid(Long pmMattypeid) {
        this.pmMattypeid = pmMattypeid;
    }

    public String getMatcode() {
        return matcode;
    }

    public void setMatcode(String matcode) {
        this.matcode = matcode;
    }

    public String getMatname() {
        return matname;
    }

    public void setMatname(String matname) {
        this.matname = matname;
    }

    public String getMatmodel() {
        return matmodel;
    }

    public void setMatmodel(String matmodel) {
        this.matmodel = matmodel;
    }

    public String getMatdrawingno() {
        return matdrawingno;
    }

    public void setMatdrawingno(String matdrawingno) {
        this.matdrawingno = matdrawingno;
    }

    public Long getMatunit() {
        return matunit;
    }

    public void setMatunit(Long matunit) {
        this.matunit = matunit;
    }

    public String getMatinnercode() {
        return matinnercode;
    }

    public void setMatinnercode(String matinnercode) {
        this.matinnercode = matinnercode;
    }

    public String getMatcustomcode() {
        return matcustomcode;
    }

    public void setMatcustomcode(String matcustomcode) {
        this.matcustomcode = matcustomcode;
    }

    public String getMatupc() {
        return matupc;
    }

    public void setMatupc(String matupc) {
        this.matupc = matupc;
    }

    public Long getMatdatastate() {
        return matdatastate;
    }

    public void setMatdatastate(Long matdatastate) {
        this.matdatastate = matdatastate;
    }

    public Long getMatweimeter() {
        return matweimeter;
    }

    public void setMatweimeter(Long matweimeter) {
        this.matweimeter = matweimeter;
    }

    public String getMatdetail() {
        return matdetail;
    }

    public void setMatdetail(String matdetail) {
        this.matdetail = matdetail;
    }

    public Long getMatsort() {
        return matsort;
    }

    public void setMatsort(Long matsort) {
        this.matsort = matsort;
    }

    public Long getMatstate() {
        return matstate;
    }

    public void setMatstate(Long matstate) {
        this.matstate = matstate;
    }

    public String getMattype() {
        return mattype;
    }

    public void setMattype(String mattype) {
        this.mattype = mattype;
    }

    public Long getMatcodecontrol() {
        return matcodecontrol;
    }

    public void setMatcodecontrol(Long matcodecontrol) {
        this.matcodecontrol = matcodecontrol;
    }

    public Long getMatqtypacket() {
        return matqtypacket;
    }

    public void setMatqtypacket(Long matqtypacket) {
        this.matqtypacket = matqtypacket;
    }

    public Long getMatqtybox() {
        return matqtybox;
    }

    public void setMatqtybox(Long matqtybox) {
        this.matqtybox = matqtybox;
    }

    public Long getMatlotqty() {
        return matlotqty;
    }

    public void setMatlotqty(Long matlotqty) {
        this.matlotqty = matlotqty;
    }

    public Date getMatupdated() {
        return matupdated;
    }

    public void setMatupdated(Date matupdated) {
        this.matupdated = matupdated;
    }

    public Long getMatuuser() {
        return matuuser;
    }

    public void setMatuuser(Long matuuser) {
        this.matuuser = matuuser;
    }

    public Long getMatminiroasttime() {
        return matminiroasttime;
    }

    public void setMatminiroasttime(Long matminiroasttime) {
        this.matminiroasttime = matminiroasttime;
    }

    public Long getMatmaxroast() {
        return matmaxroast;
    }

    public void setMatmaxroast(Long matmaxroast) {
        this.matmaxroast = matmaxroast;
    }

    public Long getMatmaxrepar() {
        return matmaxrepar;
    }

    public void setMatmaxrepar(Long matmaxrepar) {
        this.matmaxrepar = matmaxrepar;
    }

    public String getMatdescription() {
        return matdescription;
    }

    public void setMatdescription(String matdescription) {
        this.matdescription = matdescription;
    }

    public String getMatpackreq() {
        return matpackreq;
    }

    public void setMatpackreq(String matpackreq) {
        this.matpackreq = matpackreq;
    }

    public String getMatreq1() {
        return matreq1;
    }

    public void setMatreq1(String matreq1) {
        this.matreq1 = matreq1;
    }

    public String getMatreq2() {
        return matreq2;
    }

    public void setMatreq2(String matreq2) {
        this.matreq2 = matreq2;
    }

    public Long getDataversion() {
        return dataversion;
    }

    public void setDataversion(Long dataversion) {
        this.dataversion = dataversion;
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

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getData6() {
        return data6;
    }

    public void setData6(String data6) {
        this.data6 = data6;
    }

    public String getData7() {
        return data7;
    }

    public void setData7(String data7) {
        this.data7 = data7;
    }

    public String getData8() {
        return data8;
    }

    public void setData8(String data8) {
        this.data8 = data8;
    }

    public String getData9() {
        return data9;
    }

    public void setData9(String data9) {
        this.data9 = data9;
    }

    public String getData10() {
        return data10;
    }

    public void setData10(String data10) {
        this.data10 = data10;
    }

    public String getOqcstandard() {
        return oqcstandard;
    }

    public void setOqcstandard(String oqcstandard) {
        this.oqcstandard = oqcstandard;
    }

    public Long getStoragecheck() {
        return storagecheck;
    }

    public void setStoragecheck(Long storagecheck) {
        this.storagecheck = storagecheck;
    }

    public Long getPrintreceivelabel() {
        return printreceivelabel;
    }

    public void setPrintreceivelabel(Long printreceivelabel) {
        this.printreceivelabel = printreceivelabel;
    }

    public Long getWorktype() {
        return worktype;
    }

    public void setWorktype(Long worktype) {
        this.worktype = worktype;
    }

    public Long getMinrep() {
        return minrep;
    }

    public void setMinrep(Long minrep) {
        this.minrep = minrep;
    }

    public Long getMaxrep() {
        return maxrep;
    }

    public void setMaxrep(Long maxrep) {
        this.maxrep = maxrep;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getOuttype() {
        return outtype;
    }

    public void setOuttype(String outtype) {
        this.outtype = outtype;
    }

    public String getIsfrozen() {
        return isfrozen;
    }

    public void setIsfrozen(String isfrozen) {
        this.isfrozen = isfrozen;
    }

    public Long getDefaultroom() {
        return defaultroom;
    }

    public void setDefaultroom(Long defaultroom) {
        this.defaultroom = defaultroom;
    }

    public Long getDefaultsite() {
        return defaultsite;
    }

    public void setDefaultsite(Long defaultsite) {
        this.defaultsite = defaultsite;
    }

    public String getIsbatch() {
        return isbatch;
    }

    public void setIsbatch(String isbatch) {
        this.isbatch = isbatch;
    }

    public String getIssingle() {
        return issingle;
    }

    public void setIssingle(String issingle) {
        this.issingle = issingle;
    }

    public String getSecondunit() {
        return secondunit;
    }

    public void setSecondunit(String secondunit) {
        this.secondunit = secondunit;
    }

    public Long getMainunitrep() {
        return mainunitrep;
    }

    public void setMainunitrep(Long mainunitrep) {
        this.mainunitrep = mainunitrep;
    }

    public Long getUnitrate() {
        return unitrate;
    }

    public void setUnitrate(Long unitrate) {
        this.unitrate = unitrate;
    }

    public Long getSecunitrep() {
        return secunitrep;
    }

    public void setSecunitrep(Long secunitrep) {
        this.secunitrep = secunitrep;
    }

    public String getIssystem() {
        return issystem;
    }

    public void setIssystem(String issystem) {
        this.issystem = issystem;
    }

    public Long getInnerpackages() {
        return innerpackages;
    }

    public void setInnerpackages(Long innerpackages) {
        this.innerpackages = innerpackages;
    }

    public Long getBoxpackages() {
        return boxpackages;
    }

    public void setBoxpackages(Long boxpackages) {
        this.boxpackages = boxpackages;
    }

    public Long getPalletpackages() {
        return palletpackages;
    }

    public void setPalletpackages(Long palletpackages) {
        this.palletpackages = palletpackages;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }

    public String getHighness() {
        return highness;
    }

    public void setHighness(String highness) {
        this.highness = highness;
    }

    public BigDecimal getMatweisingle() {
        return matweisingle;
    }

    public void setMatweisingle(BigDecimal matweisingle) {
        this.matweisingle = matweisingle;
    }

    public String getIsplate() {
        return isplate;
    }

    public void setIsplate(String isplate) {
        this.isplate = isplate;
    }

    public String getAssortment1() {
        return assortment1;
    }

    public void setAssortment1(String assortment1) {
        this.assortment1 = assortment1;
    }

    public String getAssortment2() {
        return assortment2;
    }

    public void setAssortment2(String assortment2) {
        this.assortment2 = assortment2;
    }

    public String getAssortment3() {
        return assortment3;
    }

    public void setAssortment3(String assortment3) {
        this.assortment3 = assortment3;
    }

    public String getAssortment4() {
        return assortment4;
    }

    public void setAssortment4(String assortment4) {
        this.assortment4 = assortment4;
    }

    public String getAssortmentAbc() {
        return assortmentAbc;
    }

    public void setAssortmentAbc(String assortmentAbc) {
        this.assortmentAbc = assortmentAbc;
    }

    public Long getMattypecontrol() {
        return mattypecontrol;
    }

    public void setMattypecontrol(Long mattypecontrol) {
        this.mattypecontrol = mattypecontrol;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getQualityType() {
        return qualityType;
    }

    public void setQualityType(String qualityType) {
        this.qualityType = qualityType;
    }

    public Long getMatsendcontrol() {
        return matsendcontrol;
    }

    public void setMatsendcontrol(Long matsendcontrol) {
        this.matsendcontrol = matsendcontrol;
    }

    public String getStoretype() {
        return storetype;
    }

    public void setStoretype(String storetype) {
        this.storetype = storetype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pmMaterialid", getPmMaterialid())
            .append("pmMattypeid", getPmMattypeid())
            .append("matcode", getMatcode())
            .append("matname", getMatname())
            .append("matmodel", getMatmodel())
            .append("matdrawingno", getMatdrawingno())
            .append("matunit", getMatunit())
            .append("matinnercode", getMatinnercode())
            .append("matcustomcode", getMatcustomcode())
            .append("matupc", getMatupc())
            .append("matdatastate", getMatdatastate())
            .append("matweimeter", getMatweimeter())
            .append("matdetail", getMatdetail())
            .append("matsort", getMatsort())
            .append("matstate", getMatstate())
            .append("mattype", getMattype())
            .append("matcodecontrol", getMatcodecontrol())
            .append("matqtypacket", getMatqtypacket())
            .append("matqtybox", getMatqtybox())
            .append("matlotqty", getMatlotqty())
            .append("matupdated", getMatupdated())
            .append("matuuser", getMatuuser())
            .append("matminiroasttime", getMatminiroasttime())
            .append("matmaxroast", getMatmaxroast())
            .append("matmaxrepar", getMatmaxrepar())
            .append("matdescription", getMatdescription())
            .append("matpackreq", getMatpackreq())
            .append("matreq1", getMatreq1())
            .append("matreq2", getMatreq2())
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
            .append("oqcstandard", getOqcstandard())
            .append("storagecheck", getStoragecheck())
            .append("printreceivelabel", getPrintreceivelabel())
            .append("worktype", getWorktype())
            .append("minrep", getMinrep())
            .append("maxrep", getMaxrep())
            .append("deadline", getDeadline())
            .append("outtype", getOuttype())
            .append("isfrozen", getIsfrozen())
            .append("defaultroom", getDefaultroom())
            .append("defaultsite", getDefaultsite())
            .append("isbatch", getIsbatch())
            .append("issingle", getIssingle())
            .append("secondunit", getSecondunit())
            .append("mainunitrep", getMainunitrep())
            .append("unitrate", getUnitrate())
            .append("secunitrep", getSecunitrep())
            .append("issystem", getIssystem())
            .append("innerpackages", getInnerpackages())
            .append("boxpackages", getBoxpackages())
            .append("palletpackages", getPalletpackages())
            .append("length", getLength())
            .append("width", getWidth())
            .append("height", getHeight())
            .append("velocity", getVelocity())
            .append("highness", getHighness())
            .append("matweisingle", getMatweisingle())
            .append("isplate", getIsplate())
            .append("assortment1", getAssortment1())
            .append("assortment2", getAssortment2())
            .append("assortment3", getAssortment3())
            .append("assortment4", getAssortment4())
            .append("assortmentAbc", getAssortmentAbc())
            .append("mattypecontrol", getMattypecontrol())
            .append("storageType", getStorageType())
            .append("qualityType", getQualityType())
            .append("matsendcontrol", getMatsendcontrol())
            .append("storetype", getStoretype())
            .toString();
    }
}

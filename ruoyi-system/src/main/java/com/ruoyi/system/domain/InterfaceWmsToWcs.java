package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 写仓储控制系统(堆垛机)对象 interface_wms_to_wcs
 * 
 * @author ruoyi
 * @date 2023-08-07
 */
public class InterfaceWmsToWcs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long interfaceWmsToWcsId;

    /** 采集数据ID (如INCOLLECTDATAID ) WMS生成，WCS照原样返回 */
    @Excel(name = "采集数据ID (如INCOLLECTDATAID ) WMS生成，WCS照原样返回")
    private Long sid;

    /** 0：入库
1：出库
2：同巷道移库
3：双重入库再入库
4：空出库任务撤销
5：空托盘直进直出
6：空托盘入库
7：空托盘出库
8：空笼子入库
9：空笼子出库
 */
    @Excel(name = "0：入库1：出库2：同巷道移库3：双重入库再入库4：空出库任务撤销5：空托盘直进直出6：空托盘入库7：空托盘出库8：空笼子入库9：空笼子出库")
    private String typ;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String palno;

    /** G 排排列列层层 */
    @Excel(name = "G 排排列列层层")
    private String saddr;

    /** G 排排列列层层 */
    @Excel(name = "G 排排列列层层")
    private String daddr;

    /** 01—09 分别代表9台堆垛机 */
    @Excel(name = "01—09 分别代表9台堆垛机")
    private String dvno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date sendtime;

    /** g 为单位 */
    @Excel(name = "g 为单位")
    private Long weight;

    /** 00：正常状态
01：双重入库
02：空出库
03：其他
 */
    @Excel(name = "00：正常状态01：双重入库02：空出库03：其他")
    private String errno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ledId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ledLine1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ledLine2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ledLine3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ledLine4;

    /** 0：未读取  1：已读取  2：WCS已完成任务  3：WMS处理成功  4：WMS处理失败 5：WMS撤销指令 6：WCS执行失败 */
    @Excel(name = "0：未读取  1：已读取  2：WCS已完成任务  3：WMS处理成功  4：WMS处理失败 5：WMS撤销指令 6：WCS执行失败")
    private String state;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long seq;

    /** 重量等级：1：<= 400kg   2：<= 500kg  3：< =100kg */
    @Excel(name = "重量等级：1：<= 400kg   2：<= 500kg  3：< =100kg")
    private String weightGrade;

    /** 高度等级：1：< =560mm  2：<= 1160mm */
    @Excel(name = "高度等级：1：< =560mm  2：<= 1160mm")
    private String highGrade;

    /** WMS更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "WMS更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wmsLastDate;

    /** WMS信息 */
    @Excel(name = "WMS信息")
    private String wmsErrMessage;

    /** WCS更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "WCS更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wcsLastDate;

    /** WCS信息 */
    @Excel(name = "WCS信息")
    private String wcsErrMessage;

    /** 来源货位 */
    @Excel(name = "来源货位")
    private Long fromsiteid;

    /** 目标货位 */
    @Excel(name = "目标货位")
    private Long tositeid;

    /** 任务ID */
    @Excel(name = "任务ID")
    private Long taskId;

    /** 任务号 */
    @Excel(name = "任务号")
    private String taskNo;

    /** 单据ID */
    @Excel(name = "单据ID")
    private Long billid;

    /** 单据号 */
    @Excel(name = "单据号")
    private String billno;

    /** 凭证ID */
    @Excel(name = "凭证ID")
    private Long proofid;

    /** 凭证号 */
    @Excel(name = "凭证号")
    private String proofno;

    /** 托盘类型(1:托盘;2:笼子) */
    @Excel(name = "托盘类型(1:托盘;2:笼子)")
    private String palnotype;

   private String trayNo;
   private String startADDR;

   private String endADDR;

   private Long collecterId;

   private Long i_palletTaskId;
   private String i_pallettaskNo;
   private String i_palletNo;
   private String i_startADDR;
   private String i_endADDR;
   private Long i_operatorId;

   private String o_message;
   private String o_true;


    private String sendtime2;
    private String state2;
    private String weightGrade2;
    private String highGrade2;
    private String tasktype2;
    private String changetype2;
    private String typ2;
    private String errno2;
    private String wmsLastDate2;


    /** 任务类型:
00：组盘入库
01：配盘入库
02：合盘入库
03：托盘回库
04：空托盘入库
07: 盘点回库
08: 盘点配料盘回库
10：在线拣选出库
11：整盘出库
12：配/合盘出库
13：空托盘跺、空笼子出库
14：空托盘出库
15：盘点出库
16: 盘点配料盘出库
17: 配/合盘补料盘出库 */
    @Excel(name = "任务类型:00：组盘入库01：配盘入库02：合盘入库03：托盘回库04：空托盘入库07: 盘点回库08: 盘点配料盘回库10：在线拣选出库11：整盘出库12：配/合盘出库13：空托盘跺、空笼子出库14：空托盘出库15：盘点出库16: 盘点配料盘出库17: 配/合盘补料盘出库")
    private String tasktype;

    /** 更改类型 0新建1更改目标地址;2更改起始地址 */
    @Excel(name = "更改类型 0新建1更改目标地址;2更改起始地址")
    private Long changetype;

    public void setInterfaceWmsToWcsId(Long interfaceWmsToWcsId) 
    {
        this.interfaceWmsToWcsId = interfaceWmsToWcsId;
    }

    public Long getInterfaceWmsToWcsId() 
    {
        return interfaceWmsToWcsId;
    }
    public void setSid(Long sid) 
    {
        this.sid = sid;
    }

    public Long getSid() 
    {
        return sid;
    }
    public void setTyp(String typ) 
    {
        this.typ = typ;
    }

    public String getTyp() 
    {
        return typ;
    }
    public void setPalno(String palno) 
    {
        this.palno = palno;
    }

    public String getPalno() 
    {
        return palno;
    }
    public void setSaddr(String saddr) 
    {
        this.saddr = saddr;
    }

    public String getSaddr() 
    {
        return saddr;
    }
    public void setDaddr(String daddr) 
    {
        this.daddr = daddr;
    }

    public String getDaddr() 
    {
        return daddr;
    }
    public void setDvno(String dvno) 
    {
        this.dvno = dvno;
    }

    public String getDvno() 
    {
        return dvno;
    }
    public void setSendtime(Date sendtime) 
    {
        this.sendtime = sendtime;
    }

    public Date getSendtime() 
    {
        return sendtime;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }
    public void setErrno(String errno) 
    {
        this.errno = errno;
    }

    public String getErrno() 
    {
        return errno;
    }
    public void setLedId(String ledId) 
    {
        this.ledId = ledId;
    }

    public String getLedId() 
    {
        return ledId;
    }
    public void setLedLine1(String ledLine1) 
    {
        this.ledLine1 = ledLine1;
    }

    public String getLedLine1() 
    {
        return ledLine1;
    }
    public void setLedLine2(String ledLine2) 
    {
        this.ledLine2 = ledLine2;
    }

    public String getLedLine2() 
    {
        return ledLine2;
    }
    public void setLedLine3(String ledLine3) 
    {
        this.ledLine3 = ledLine3;
    }

    public String getLedLine3() 
    {
        return ledLine3;
    }
    public void setLedLine4(String ledLine4) 
    {
        this.ledLine4 = ledLine4;
    }

    public String getLedLine4() 
    {
        return ledLine4;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setSeq(Long seq) 
    {
        this.seq = seq;
    }

    public Long getSeq() 
    {
        return seq;
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
    public void setWmsLastDate(Date wmsLastDate) 
    {
        this.wmsLastDate = wmsLastDate;
    }

    public Date getWmsLastDate() 
    {
        return wmsLastDate;
    }
    public void setWmsErrMessage(String wmsErrMessage) 
    {
        this.wmsErrMessage = wmsErrMessage;
    }

    public String getWmsErrMessage() 
    {
        return wmsErrMessage;
    }
    public void setWcsLastDate(Date wcsLastDate) 
    {
        this.wcsLastDate = wcsLastDate;
    }

    public Date getWcsLastDate() 
    {
        return wcsLastDate;
    }
    public void setWcsErrMessage(String wcsErrMessage) 
    {
        this.wcsErrMessage = wcsErrMessage;
    }

    public String getWcsErrMessage() 
    {
        return wcsErrMessage;
    }
    public void setFromsiteid(Long fromsiteid) 
    {
        this.fromsiteid = fromsiteid;
    }

    public Long getFromsiteid() 
    {
        return fromsiteid;
    }
    public void setTositeid(Long tositeid) 
    {
        this.tositeid = tositeid;
    }

    public Long getTositeid() 
    {
        return tositeid;
    }

    public void setBillid(Long billid) 
    {
        this.billid = billid;
    }

    public Long getBillid() 
    {
        return billid;
    }
    public void setBillno(String billno) 
    {
        this.billno = billno;
    }

    public String getBillno() 
    {
        return billno;
    }
    public void setProofid(Long proofid) 
    {
        this.proofid = proofid;
    }

    public Long getProofid() 
    {
        return proofid;
    }
    public void setProofno(String proofno) 
    {
        this.proofno = proofno;
    }

    public String getProofno() 
    {
        return proofno;
    }
    public void setPalnotype(String palnotype) 
    {
        this.palnotype = palnotype;
    }

    public String getPalnotype() 
    {
        return palnotype;
    }
    public void setTasktype(String tasktype) 
    {
        this.tasktype = tasktype;
    }

    public String getTasktype() 
    {
        return tasktype;
    }
    public void setChangetype(Long changetype) 
    {
        this.changetype = changetype;
    }

    public Long getChangetype() 
    {
        return changetype;
    }

   public Long getTaskId() {
      return taskId;
   }

   public void setTaskId(Long taskId) {
      this.taskId = taskId;
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

   public String getStartADDR() {
      return startADDR;
   }

   public void setStartADDR(String startADDR) {
      this.startADDR = startADDR;
   }

   public String getEndADDR() {
      return endADDR;
   }

   public void setEndADDR(String endADDR) {
      this.endADDR = endADDR;
   }

   public Long getCollecterId() {
      return collecterId;
   }

   public void setCollecterId(Long collecterId) {
      this.collecterId = collecterId;
   }

   public Long getI_palletTaskId() {
      return i_palletTaskId;
   }

   public void setI_palletTaskId(Long i_palletTaskId) {
      this.i_palletTaskId = i_palletTaskId;
   }

   public String getI_pallettaskNo() {
      return i_pallettaskNo;
   }

   public void setI_pallettaskNo(String i_pallettaskNo) {
      this.i_pallettaskNo = i_pallettaskNo;
   }

   public String getI_palletNo() {
      return i_palletNo;
   }

   public void setI_palletNo(String i_palletNo) {
      this.i_palletNo = i_palletNo;
   }

   public String getI_startADDR() {
      return i_startADDR;
   }

   public void setI_startADDR(String i_startADDR) {
      this.i_startADDR = i_startADDR;
   }

   public String getI_endADDR() {
      return i_endADDR;
   }

   public void setI_endADDR(String i_endADDR) {
      this.i_endADDR = i_endADDR;
   }

   public Long getI_operatorId() {
      return i_operatorId;
   }

   public void setI_operatorId(Long i_operatorId) {
      this.i_operatorId = i_operatorId;
   }

   public String getO_message() {
      return o_message;
   }

   public void setO_message(String o_message) {
      this.o_message = o_message;
   }

   public String getO_true() {
      return o_true;
   }

   public void setO_true(String o_true) {
      this.o_true = o_true;
   }

    public String getSendtime2() {
        return sendtime2;
    }

    public void setSendtime2(String sendtime2) {
        this.sendtime2 = sendtime2;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public String getWeightGrade2() {
        return weightGrade2;
    }

    public void setWeightGrade2(String weightGrade2) {
        this.weightGrade2 = weightGrade2;
    }

    public String getHighGrade2() {
        return highGrade2;
    }

    public void setHighGrade2(String highGrade2) {
        this.highGrade2 = highGrade2;
    }

    public String getTasktype2() {
        return tasktype2;
    }

    public void setTasktype2(String tasktype2) {
        this.tasktype2 = tasktype2;
    }

    public String getChangetype2() {
        return changetype2;
    }

    public void setChangetype2(String changetype2) {
        this.changetype2 = changetype2;
    }

    public String getTyp2() {
        return typ2;
    }

    public void setTyp2(String typ2) {
        this.typ2 = typ2;
    }

    public String getErrno2() {
        return errno2;
    }

    public void setErrno2(String errno2) {
        this.errno2 = errno2;
    }

    public String getWmsLastDate2() {
        return wmsLastDate2;
    }

    public void setWmsLastDate2(String wmsLastDate2) {
        this.wmsLastDate2 = wmsLastDate2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("interfaceWmsToWcsId", interfaceWmsToWcsId)
                .append("sid", sid)
                .append("typ", typ)
                .append("palno", palno)
                .append("saddr", saddr)
                .append("daddr", daddr)
                .append("dvno", dvno)
                .append("sendtime", sendtime)
                .append("weight", weight)
                .append("errno", errno)
                .append("ledId", ledId)
                .append("ledLine1", ledLine1)
                .append("ledLine2", ledLine2)
                .append("ledLine3", ledLine3)
                .append("ledLine4", ledLine4)
                .append("state", state)
                .append("seq", seq)
                .append("weightGrade", weightGrade)
                .append("highGrade", highGrade)
                .append("wmsLastDate", wmsLastDate)
                .append("wmsErrMessage", wmsErrMessage)
                .append("wcsLastDate", wcsLastDate)
                .append("wcsErrMessage", wcsErrMessage)
                .append("fromsiteid", fromsiteid)
                .append("tositeid", tositeid)
                .append("taskId", taskId)
                .append("taskNo", taskNo)
                .append("billid", billid)
                .append("billno", billno)
                .append("proofid", proofid)
                .append("proofno", proofno)
                .append("palnotype", palnotype)
                .append("trayNo", trayNo)
                .append("startADDR", startADDR)
                .append("endADDR", endADDR)
                .append("collecterId", collecterId)
                .append("i_palletTaskId", i_palletTaskId)
                .append("i_pallettaskNo", i_pallettaskNo)
                .append("i_palletNo", i_palletNo)
                .append("i_startADDR", i_startADDR)
                .append("i_endADDR", i_endADDR)
                .append("i_operatorId", i_operatorId)
                .append("o_message", o_message)
                .append("o_true", o_true)
                .append("sendtime2", sendtime2)
                .append("state2", state2)
                .append("weightGrade2", weightGrade2)
                .append("highGrade2", highGrade2)
                .append("tasktype2", tasktype2)
                .append("changetype2", changetype2)
                .append("typ2", typ2)
                .append("errno2", errno2)
                .append("wmsLastDate2", wmsLastDate2)
                .append("tasktype", tasktype)
                .append("changetype", changetype)
                .toString();
    }
}

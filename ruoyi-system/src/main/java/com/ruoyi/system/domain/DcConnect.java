package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * ?通讯批次对象 dc_connect
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public class DcConnect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long dcConnectid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dcConnectno;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contime;

    /** 四种 EXPBATCHTASK,BATCHUPTASK,WIRELESS,BATCHDOWNTASK */
    @Excel(name = "四种 EXPBATCHTASK,BATCHUPTASK,WIRELESS,BATCHDOWNTASK")
    private String collectortype;

    /** 七种 SUP,OUT,EXP,INSOLID,IN,CHECK,OUTSOLID */
    @Excel(name = "七种 SUP,OUT,EXP,INSOLID,IN,CHECK,OUTSOLID")
    private String businesskind;

    /** 0  成功
1  失败 */
    @Excel(name = "0  成功1  失败")
    private Long constate;

    /** 0  成功
     1  失败 */
    @Excel(name = "0  成功1  失败")
    private String constateName;

    /** 人员 */
    @Excel(name = "人员")
    private Long conemp;

    /** ? */
    @Excel(name = "?")
    private String condemo;

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

    /** 异常信息 */
    @Excel(name = "异常信息")
    private String data5;

    /** - */
    @Excel(name = "-")
    private String data6;

    /** - */
    @Excel(name = "-")
    private String data7;

    /** - */
    @Excel(name = "-")
    private String data8;

    /** 任务ID */
    @Excel(name = "任务ID")
    private Long taskid;

    /** 任务号 */
    @Excel(name = "任务号")
    private String taskno;

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

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    @Excel(name = "托盘号")
    private String cname;

    private int PageIndex;
    private int PageSize;

    private String ERP_ORDER_NUMBER;
    private String SOURCE_NUMBER;
    private String ORDER_TYPE;
    private String BATCH_ID;
    private String PROCESS_DATE;
    private String source_header_id;
    private String PROCESS_STATUS;
    private String PROCESS_MESSAGE;
    private String RESERVE_F1;
    private String JKNAME;
    private String TXJOBID;
    private String ORDER_TYPE_NAME;

    public String getERP_ORDER_NUMBER() {
        return ERP_ORDER_NUMBER;
    }

    public void setERP_ORDER_NUMBER(String ERP_ORDER_NUMBER) {
        this.ERP_ORDER_NUMBER = ERP_ORDER_NUMBER;
    }

    public String getSOURCE_NUMBER() {
        return SOURCE_NUMBER;
    }

    public void setSOURCE_NUMBER(String SOURCE_NUMBER) {
        this.SOURCE_NUMBER = SOURCE_NUMBER;
    }

    public String getORDER_TYPE() {
        return ORDER_TYPE;
    }

    public void setORDER_TYPE(String ORDER_TYPE) {
        this.ORDER_TYPE = ORDER_TYPE;
    }

    public String getBATCH_ID() {
        return BATCH_ID;
    }

    public void setBATCH_ID(String BATCH_ID) {
        this.BATCH_ID = BATCH_ID;
    }

    public String getPROCESS_DATE() {
        return PROCESS_DATE;
    }

    public void setPROCESS_DATE(String PROCESS_DATE) {
        this.PROCESS_DATE = PROCESS_DATE;
    }

    public String getSource_header_id() {
        return source_header_id;
    }

    public void setSource_header_id(String source_header_id) {
        this.source_header_id = source_header_id;
    }

    public String getPROCESS_STATUS() {
        return PROCESS_STATUS;
    }

    public void setPROCESS_STATUS(String PROCESS_STATUS) {
        this.PROCESS_STATUS = PROCESS_STATUS;
    }

    public String getPROCESS_MESSAGE() {
        return PROCESS_MESSAGE;
    }

    public void setPROCESS_MESSAGE(String PROCESS_MESSAGE) {
        this.PROCESS_MESSAGE = PROCESS_MESSAGE;
    }

    public String getRESERVE_F1() {
        return RESERVE_F1;
    }

    public void setRESERVE_F1(String RESERVE_F1) {
        this.RESERVE_F1 = RESERVE_F1;
    }

    public String getJKNAME() {
        return JKNAME;
    }

    public void setJKNAME(String JKNAME) {
        this.JKNAME = JKNAME;
    }

    public String getTXJOBID() {
        return TXJOBID;
    }

    public void setTXJOBID(String TXJOBID) {
        this.TXJOBID = TXJOBID;
    }

    public String getORDER_TYPE_NAME() {
        return ORDER_TYPE_NAME;
    }

    public void setORDER_TYPE_NAME(String ORDER_TYPE_NAME) {
        this.ORDER_TYPE_NAME = ORDER_TYPE_NAME;
    }

    public String getConstateName() {
        return constateName;
    }

    public void setConstateName(String constateName) {
        this.constateName = constateName;
    }

    private String start_contime;
    private String finish_contime;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public String getStart_contime() {
        return start_contime;
    }

    public void setStart_contime(String start_contime) {
        this.start_contime = start_contime;
    }

    public String getFinish_contime() {
        return finish_contime;
    }

    public void setFinish_contime(String finish_contime) {
        this.finish_contime = finish_contime;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setDcConnectid(Long dcConnectid)
    {
        this.dcConnectid = dcConnectid;
    }

    public Long getDcConnectid() 
    {
        return dcConnectid;
    }
    public void setDcConnectno(String dcConnectno) 
    {
        this.dcConnectno = dcConnectno;
    }

    public String getDcConnectno() 
    {
        return dcConnectno;
    }
    public void setContime(Date contime) 
    {
        this.contime = contime;
    }

    public Date getContime() 
    {
        return contime;
    }
    public void setCollectortype(String collectortype) 
    {
        this.collectortype = collectortype;
    }

    public String getCollectortype() 
    {
        return collectortype;
    }
    public void setBusinesskind(String businesskind) 
    {
        this.businesskind = businesskind;
    }

    public String getBusinesskind() 
    {
        return businesskind;
    }
    public void setConstate(Long constate) 
    {
        this.constate = constate;
    }

    public Long getConstate() 
    {
        return constate;
    }
    public void setConemp(Long conemp) 
    {
        this.conemp = conemp;
    }

    public Long getConemp() 
    {
        return conemp;
    }
    public void setCondemo(String condemo) 
    {
        this.condemo = condemo;
    }

    public String getCondemo() 
    {
        return condemo;
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
    public void setTaskid(Long taskid) 
    {
        this.taskid = taskid;
    }

    public Long getTaskid() 
    {
        return taskid;
    }
    public void setTaskno(String taskno) 
    {
        this.taskno = taskno;
    }

    public String getTaskno() 
    {
        return taskno;
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
    public void setPalletno(String palletno) 
    {
        this.palletno = palletno;
    }

    public String getPalletno() 
    {
        return palletno;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dcConnectid", getDcConnectid())
            .append("dcConnectno", getDcConnectno())
            .append("contime", getContime())
            .append("collectortype", getCollectortype())
            .append("businesskind", getBusinesskind())
            .append("constate", getConstate())
            .append("conemp", getConemp())
            .append("condemo", getCondemo())
            .append("dataversion", getDataversion())
            .append("data1", getData1())
            .append("data2", getData2())
            .append("data3", getData3())
            .append("data4", getData4())
            .append("data5", getData5())
            .append("data6", getData6())
            .append("data7", getData7())
            .append("data8", getData8())
            .append("taskid", getTaskid())
            .append("taskno", getTaskno())
            .append("billid", getBillid())
            .append("billno", getBillno())
            .append("proofid", getProofid())
            .append("proofno", getProofno())
            .append("palletno", getPalletno())
            .toString();
    }
}

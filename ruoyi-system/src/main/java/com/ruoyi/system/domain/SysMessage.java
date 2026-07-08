package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_message
 *
 * @author ruoyi
 * @date 2024-03-17
 */
public class SysMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long messageId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String messageType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long taskitemid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String messageTitle;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String messageConcent;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String messageStatus;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String messageSender;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String messageReceiver;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String cldNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date receiveTime;

    private int PageIndex;
    private int PageSize;

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

    public void setMessageId(Long messageId)
    {
        this.messageId = messageId;
    }

    public Long getMessageId()
    {
        return messageId;
    }
    public void setMessageType(String messageType)
    {
        this.messageType = messageType;
    }

    public String getMessageType()
    {
        return messageType;
    }
    public void setTaskitemid(Long taskitemid)
    {
        this.taskitemid = taskitemid;
    }

    public Long getTaskitemid()
    {
        return taskitemid;
    }
    public void setMessageTitle(String messageTitle)
    {
        this.messageTitle = messageTitle;
    }

    public String getMessageTitle()
    {
        return messageTitle;
    }
    public void setMessageConcent(String messageConcent)
    {
        this.messageConcent = messageConcent;
    }

    public String getMessageConcent()
    {
        return messageConcent;
    }
    public void setMessageStatus(String messageStatus)
    {
        this.messageStatus = messageStatus;
    }

    public String getMessageStatus()
    {
        return messageStatus;
    }
    public void setMessageSender(String messageSender)
    {
        this.messageSender = messageSender;
    }

    public String getMessageSender()
    {
        return messageSender;
    }
    public void setMessageReceiver(String messageReceiver)
    {
        this.messageReceiver = messageReceiver;
    }

    public String getMessageReceiver()
    {
        return messageReceiver;
    }
    public void setCldNo(String cldNo)
    {
        this.cldNo = cldNo;
    }

    public String getCldNo()
    {
        return cldNo;
    }
    public void setReceiveTime(Date receiveTime)
    {
        this.receiveTime = receiveTime;
    }

    public Date getReceiveTime()
    {
        return receiveTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("messageId", getMessageId())
            .append("messageType", getMessageType())
            .append("taskitemid", getTaskitemid())
            .append("messageTitle", getMessageTitle())
            .append("messageConcent", getMessageConcent())
            .append("messageStatus", getMessageStatus())
            .append("messageSender", getMessageSender())
            .append("messageReceiver", getMessageReceiver())
            .append("cldNo", getCldNo())
            .append("createTime", getCreateTime())
            .append("receiveTime", getReceiveTime())
            .toString();
    }
}

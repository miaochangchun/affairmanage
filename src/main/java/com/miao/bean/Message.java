package com.miao.bean;

import java.util.Date;

/**
 * Created by 10048 on 2017/5/9.
 * 文章信息类
 */
public class Message {
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", employeeId=" + employeeId +
                ", publishTime=" + publishTime +
                '}';
    }

    private int messageId;          //消息ID
    private String messageTitle;    //消息标题
    private String messageContent;  //消息内容
    private int employeeId;         //发布人ID
    private Date publishTime;       //发布时间

}

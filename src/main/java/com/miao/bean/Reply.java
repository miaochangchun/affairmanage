package com.miao.bean;

import java.util.Date;

/**
 * Created by 10048 on 2017/5/9.
 * 回复信息类
 */
public class Reply {
    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyContent='" + replyContent + '\'' +
                ", employeeId=" + employeeId +
                ", replyTime=" + replyTime +
                ", messageId=" + messageId +
                '}';
    }

    private int replyId;            //回复ID
    private String replyContent;    //回复内容
    private int employeeId;         //回复人I
    private Date replyTime;         //回复时间
    private int messageId;          //消息ID

}

package com.miao.bean;

import java.util.Date;

/**
 * Created by 10048 on 2017/5/9.
 * 批复类
 */
public class Criticism {
    public int getCriticismId() {
        return criticismId;
    }

    public void setCriticismId(int criticismId) {
        this.criticismId = criticismId;
    }

    public String getCriticismContent() {
        return criticismContent;
    }

    public void setCriticismContent(String criticismContent) {
        this.criticismContent = criticismContent;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getCriticismTime() {
        return criticismTime;
    }

    public void setCriticismTime(Date criticismTime) {
        this.criticismTime = criticismTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "Criticism{" +
                "criticismId=" + criticismId +
                ", criticismContent='" + criticismContent + '\'' +
                ", employeeId=" + employeeId +
                ", criticismTime=" + criticismTime +
                ", messageId=" + messageId +
                '}';
    }

    private int criticismId;            //批复Id
    private String criticismContent;    //批复内容
    private int employeeId;             //批复人Id
    private Date criticismTime;         //批复时间
    private int messageId;              //消息Id


}

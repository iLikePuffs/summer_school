package com.summer_school.domain.homework;

import java.sql.Timestamp;

public class Homework {
    /**
     作业编号
     作业标题
     作业内容
     发布者id
     发布者身份
     作业发布时间
     作业结束时间
     */
    private int homeWorkID;
    private String title;
    private String homeWorkContent;
    private int publisherId  ;
    private String publisherIdentity;
    private Timestamp publishTime;
    private Timestamp endTime;

    public Homework(){

    }

    public Homework(int homeWorkID,String title, String homeWorkContent,int publisherId,String publisherIdentity,Timestamp publishTime,Timestamp endTime){
        this.homeWorkID = homeWorkID;
        this.title = title;
        this.homeWorkContent = homeWorkContent;
        this.publisherId = publisherId;
        this.publisherIdentity = publisherIdentity;
        this.publishTime = publishTime;
        this.endTime = endTime;


    }

    public int getHomeWorkID() {
        return homeWorkID;
    }

    public void setHomeWorkID(int homeWorkID) {
        this.homeWorkID = homeWorkID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHomeWorkContent() {
        return homeWorkContent;
    }

    public void setHomeWorkContent(String homeWorkContent) {
        this.homeWorkContent = homeWorkContent;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherIdentity() {
        return publisherIdentity;
    }

    public void setPublisherIdentity(String publisherIdentity) {
        this.publisherIdentity = publisherIdentity;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "homeWorkID=" + homeWorkID +
                ", title='" + title + '\'' +
                ", homeWorkContent='" + homeWorkContent + '\'' +
                ", publisherId=" + publisherId +
                ", publisherIdentity='" + publisherIdentity + '\'' +
                ", publishTime=" + publishTime +
                ", endTime=" + endTime +
                '}';
    }
}

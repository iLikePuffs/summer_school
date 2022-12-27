package com.summer_school.domain.homework;

import java.sql.Timestamp;

public class StudentHomework {
    /**
     学生作业编号
     学生id
     作业编号
     学生提交的作业内容
     作业提交时间
     批改状态
     批改分数
     */
    private int studentHomeWorkID;
    private int studentId;
    private int homeWorkID;
    private String homeworkContent  ;
    private Timestamp create_time;
    private String correctingStatus;
    private int score;
    public StudentHomework(){

    }
    public StudentHomework(int studentHomeWorkID,int studentId,int homeWorkID,String homeworkContent,Timestamp create_time,String correctingStatus,int score){
        this.studentHomeWorkID = studentHomeWorkID;
        this.studentId = studentId;
        this.homeWorkID = homeWorkID;
        this.homeworkContent = homeworkContent;
        this.create_time = create_time;
        this.correctingStatus = correctingStatus;
        this.score = score;
    }

    public int getStudentHomeWorkID() {
        return studentHomeWorkID;
    }

    public void setStudentHomeWorkID(int studentHomeWorkID) {
        this.studentHomeWorkID = studentHomeWorkID;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getHomeWorkID() {
        return homeWorkID;
    }

    public void setHomeWorkID(int homeWorkID) {
        this.homeWorkID = homeWorkID;
    }

    public String getHomeworkContent() {
        return homeworkContent;
    }

    public void setHomeworkContent(String homeworkContent) {
        this.homeworkContent = homeworkContent;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getCorrectingStatus() {
        return correctingStatus;
    }

    public void setCorrectingStatus(String correctingStatus) {
        this.correctingStatus = correctingStatus;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentHomework{" +
                "studentHomeWorkID=" + studentHomeWorkID +
                ", studentId=" + studentId +
                ", homeWorkID=" + homeWorkID +
                ", homeworkContent='" + homeworkContent + '\'' +
                ", create_time=" + create_time +
                ", correctingStatus='" + correctingStatus + '\'' +
                ", score=" + score +
                '}';
    }
}

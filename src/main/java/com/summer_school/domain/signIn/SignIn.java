package com.summer_school.domain.signIn;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class SignIn {
    /**
     研究热点ID
     学生id
     签到状态
     签到发布时间
     签到时间/补签时间
     */

    private Integer researchHotSpotId;
    private Integer studentId;
    private String signStatus;

    private Timestamp signPutTime;

    private Timestamp signInTime;

    public SignIn(){

    }
    public SignIn(Integer researchHotSpotId,Integer studentId,String signStatus,Timestamp signPutTime,Timestamp signInTime){
        this.researchHotSpotId = researchHotSpotId;
        this.studentId = studentId;
        this.signStatus = signStatus;
        this.signPutTime = signPutTime;
        this.signInTime = signInTime;
    }

    public Integer getResearchHotSpotId() {
        return researchHotSpotId;
    }

    public void setResearchHotSpotId(Integer researchHotSpotId) {
        this.researchHotSpotId = researchHotSpotId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
    }

    public Timestamp getSignPutTime() {
        return signPutTime;
    }

    public void setSignPutTime(Timestamp signPutTime) {
        this.signPutTime = signPutTime;
    }

    public Timestamp getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Timestamp signInTime) {
        this.signInTime = signInTime;
    }


    @Override
    public String toString() {
        return "SignIn{" +
                "researchHotSpotId=" + researchHotSpotId +
                ", studentId=" + studentId +
                ", signStatus='" + signStatus + '\'' +
                ", signPutTime=" + signPutTime +
                ", signInTime=" + signInTime +
                '}';
    }
}

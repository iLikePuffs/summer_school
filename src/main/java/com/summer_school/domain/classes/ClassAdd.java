package com.summer_school.domain.classes;

public class ClassAdd {
    /**
     id
     班级id
     人物id
     身份
     */

    private Integer classAddId;
    private Integer classId;
    private Integer userId;
    private String identity;

    public ClassAdd(){
    }

    public ClassAdd(Integer classAddId,Integer classId,Integer userId,String identity){
        this.classAddId = classAddId;
        this.classId = classId;
        this.userId = userId;
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "ClassAdd{" +
                "classAddId=" + classAddId +
                ", classId=" + classId +
                ", userId=" + userId +
                ", identity='" + identity + '\'' +
                '}';
    }

    public Integer getClassAddId() {
        return classAddId;
    }

    public void setClassAddId(Integer classAddId) {
        this.classAddId = classAddId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}

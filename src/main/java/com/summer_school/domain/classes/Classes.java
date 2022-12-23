package com.summer_school.domain.classes;

public class Classes {
    /**
     班级编号
     班级名字
     所属暑期学校ID
     */

    private Integer id;
    private Integer summerSchoolId;
    private String name;

    public Classes(){

    }

    public Classes(Integer id,Integer summerSchoolId,String name){
        this.id = id;
        this.summerSchoolId = summerSchoolId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSummerSchoolId() {
        return summerSchoolId;
    }

    public void setSummerSchoolId(Integer summerSchoolId) {
        this.summerSchoolId = summerSchoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "Classes{name = " + name + ", id = " + id + ", summerSchoolId = " + summerSchoolId + "}";
    }
}

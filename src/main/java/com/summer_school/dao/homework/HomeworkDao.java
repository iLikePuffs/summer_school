package com.summer_school.dao.homework;

import com.summer_school.domain.homework.Homework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomeworkDao {

    //查看已发布作业
    @Select("select * from homework_table")
    List<Homework> homeworkList();


    //添加作业
    @Insert("insert into homework_table (homeWorkID,title,homeWorkContent,publisherId,publisherIdentity,publishTime,endTime) values(#{homeWorkID},#{title},#{homeWorkContent},#{publisherId},#{publisherIdentity},#{publishTime},#{endTime})")
    int insertHomework(Homework homework);
}

package com.summer_school.dao.homework;

import com.summer_school.domain.homework.Homework;
import com.summer_school.domain.homework.StudentHomework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentHomeworkDao {

    //查看作业详情
    @Select("select * from student_homework_table where homeWorkID = #{homeWorkID}")
    List<StudentHomework> DetailHomeworkList(int homeWorkID);


    //查看作业
    @Select("select * from student_homework_table")
    List<StudentHomework> StudentHomeworkList();

    //学生提交作业

    @Insert("insert into student_homework_table (studentHomeWorkID,studentId,homeWorkID,homeworkContent,create_time,correctingStatus) values(#{studentHomeWorkID},#{studentId},#{homeWorkID},#{homeworkContent},#{create_time},#{correctingStatus})")
    int addStudentHomework(StudentHomework studentHomework);
}

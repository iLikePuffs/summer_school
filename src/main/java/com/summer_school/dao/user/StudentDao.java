package com.summer_school.dao.user;

import com.summer_school.domain.user.lasting.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentDao  {
    //学生登陆
    @Select("select * from student_table where account = #{account} and password = #{password}")
    public Student signIn(String account, String password);


    @Select("select * from student_table where id=#{id}")
    public Student findById(Integer id);

    //修改学生信息
    @Update("update student_table set summerSchoolId=#{summerSchoolId},account=#{account},password=#{password},identity=#{identity},studentName=#{studentName},schoolLevel=#{schoolLevel},schoolName=#{schoolName},studentType=#{studentType},grade=#{grade},profession=#{profession},gender=#{gender},politicalStatus=#{politicalStatus} where id=#{id}")
    public int update(Student student);





}

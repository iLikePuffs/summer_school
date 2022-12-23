package com.summer_school.dao.user;

import com.summer_school.domain.user.lasting.Student;
import com.summer_school.domain.user.lasting.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TeacherDao {
    //老师登陆
    @Select("select * from teacher_table where account = #{account} and password = #{password}")
    public Teacher signIn(String account, String password);

    @Select("select * from teacher_table where id=#{id}")
    public Teacher findById(Integer id);

    //修改老师信息
    @Update("update teacher_table set summerSchoolId=#{summerSchoolId},account=#{account},password=#{password},identity=#{identity},name=#{name},post=#{post},schoolName=#{schoolName},academy=#{academy} where id=#{id}")
    public int update(Teacher teacher);

}
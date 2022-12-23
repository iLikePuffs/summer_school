package com.summer_school.dao.user;

import com.summer_school.domain.user.lasting.EducationalAdministartor;
import com.summer_school.domain.user.lasting.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EducationalAdministartorDao{
    //教务管理员登陆
    @Select("select * from educational_administrator_table where account = #{account} and password = #{password}")
    public EducationalAdministartor signIn(String account, String password);

    //将教务管理员注册信息保存到老师和教务管理员注册申请表（teacher_educational_administrator_sign_up_table）
    @Insert("insert into teacher_educational_administrator_sign_up_table values (identity = #{identity},year = #{year},account = #{account},password = #{password},post = #{post},schoolName = #{schoolName},academy = #{academy},photo = #{photo},schoolName = #{schoolName})")
    public boolean saveSignUpInfo(String identity,Integer year,String account,String password,String post,String schoolName,String academy,String photoschoolName);

    @Select("select * from educational_administrator_table where id=#{id}")
    public EducationalAdministartor findById(Integer id);

    //修改教务管理员信息
    @Update("update educational_administrator_table set summerSchoolId=#{summerSchoolId},account=#{account},password=#{password},identity=#{identity},name=#{name},post=#{post},schoolName=#{schoolName},academy=#{academy} where id=#{id}")
    public int update(EducationalAdministartor educationalAdministartor);



}

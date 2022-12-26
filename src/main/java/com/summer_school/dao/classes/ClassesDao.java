package com.summer_school.dao.classes;


import com.summer_school.domain.classes.Classes;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClassesDao {

    //创建班级
   // @Insert("insert into class_table (summerSchoolId,name) values(#{summerSchoolId},#{name})")
   // @Insert("insert into class_table (id,summerSchoolId,name) values(#{id},#{summerSchoolId},#{name})")

    @Insert("insert into class_table (name,summerSchoolId) values(#{name},#{summerSchoolId})")
    public int save(Classes classes);


    //按id查找班级
    @Select("select * from class_table where id = #{id}")
    public Classes getById(Integer id);

}

package com.summer_school.dao.classes;

import com.summer_school.domain.classes.ClassAdd;
import com.summer_school.domain.classes.Classes;
import com.summer_school.domain.homework.StudentHomework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassAddDao {

    //加入班级
    @Insert("insert into class_add_table (classId,userId,identity) values(#{classId},#{userId},#{identity})")
    public int classAdd(ClassAdd classAdd);

    //查看加入班级的人（根据班级id查找）
    @Select("select * from class_add_table where classId = #{classId}")
    List<ClassAdd> ClassAddList(int classId);

}

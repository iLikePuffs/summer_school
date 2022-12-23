package com.summer_school.service.signup_and_examine;

import com.summer_school.domain.user.lasting.Student;

public interface StudentUpdateService {
    //修改学生信息
    public boolean update(Student student);

    //按id查询
    public Student findById(Integer id);

}

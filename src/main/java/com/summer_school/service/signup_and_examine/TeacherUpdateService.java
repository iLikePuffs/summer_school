package com.summer_school.service.signup_and_examine;

import com.summer_school.domain.user.lasting.Student;
import com.summer_school.domain.user.lasting.Teacher;

public interface TeacherUpdateService {
    //修改老师信息
    public boolean update(Teacher teacher);

    //按id查询
    public Teacher findById(Integer id);

}

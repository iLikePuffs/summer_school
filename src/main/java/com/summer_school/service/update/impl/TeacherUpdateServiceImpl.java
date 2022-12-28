package com.summer_school.service.update.impl;

import com.summer_school.dao.user.TeacherDao;
import com.summer_school.domain.user.lasting.Teacher;
import com.summer_school.service.update.TeacherUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherUpdateServiceImpl implements TeacherUpdateService {

    @Autowired
    private TeacherDao teacherDao;

  //  @Override
    public boolean update(Teacher teacher) {
        return teacherDao.update(teacher)>0;

    }

   // @Override
    public Teacher findById(Integer id) {
        return teacherDao.findById(id);
    }

}

package com.summer_school.service.update.impl;

import com.summer_school.dao.user.StudentDao;
import com.summer_school.domain.user.lasting.Student;
import com.summer_school.service.update.StudentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentUpdateServiceImpl implements StudentUpdateService {

    @Autowired
    private StudentDao studentDao;

  //  @Override
    public boolean update(Student student) {
        return studentDao.update(student)>0;

    }

   // @Override
    public Student findById(Integer id) {
        return studentDao.findById(id);
    }

}

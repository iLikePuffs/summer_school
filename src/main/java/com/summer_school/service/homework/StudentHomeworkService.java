package com.summer_school.service.homework;

import com.summer_school.dao.homework.StudentHomeworkDao;
import com.summer_school.domain.homework.Homework;
import com.summer_school.domain.homework.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentHomeworkService {

    @Autowired
    StudentHomeworkDao studentHomeworkDao;

    public List<StudentHomework> DetailHomeworkList(int homeWorkID){
        return studentHomeworkDao.DetailHomeworkList(homeWorkID);
    }

    public List<StudentHomework> StudentHomeworkList(){
        return studentHomeworkDao.StudentHomeworkList();
    }

    public int addStudentHomework(StudentHomework studentHomework){
        return studentHomeworkDao.addStudentHomework(studentHomework);
    }
}

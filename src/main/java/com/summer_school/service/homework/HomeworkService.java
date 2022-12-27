package com.summer_school.service.homework;

import com.summer_school.dao.homework.HomeworkDao;
import com.summer_school.domain.homework.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkService {

    @Autowired
    HomeworkDao homeworkDao;

    public List<Homework> homeworkList(){
        return homeworkDao.homeworkList();
    }
    public int insertHomework(Homework homework){
        return homeworkDao.insertHomework(homework);
    }
}

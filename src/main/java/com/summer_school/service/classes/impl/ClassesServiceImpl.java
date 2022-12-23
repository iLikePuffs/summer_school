package com.summer_school.service.classes.impl;

import com.summer_school.dao.classes.ClassesDao;
import com.summer_school.domain.classes.Classes;
import com.summer_school.service.classes.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesDao classesDao;
    @Override
    public boolean save(Classes classes){
        return classesDao.save(classes)>0;
    }

    public Classes getById(Integer id) {

        return classesDao.getById(id);
    }
}

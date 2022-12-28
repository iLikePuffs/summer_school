package com.summer_school.service.classes.impl;

import com.summer_school.dao.classes.ClassAddDao;
import com.summer_school.dao.classes.ClassesDao;
import com.summer_school.domain.classes.ClassAdd;
import com.summer_school.service.classes.ClassAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassAddServiceImpl implements ClassAddService {
    @Autowired
    private ClassAddDao classAddDao;
    @Override
    public int classAdd(ClassAdd classAdd){
        return classAddDao.classAdd(classAdd);
    }

    public List<ClassAdd> ClassAddList(int classId){
        return classAddDao.ClassAddList(classId);
    }


}

package com.summer_school.service.classes;

import com.summer_school.domain.classes.Classes;


public interface ClassesService {
    //创建班级
    public boolean save(Classes classes);
    public Classes getById(Integer id);
}

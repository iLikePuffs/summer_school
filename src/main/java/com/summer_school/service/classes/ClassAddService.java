package com.summer_school.service.classes;

import com.summer_school.domain.classes.ClassAdd;
import com.summer_school.domain.classes.Classes;
import com.summer_school.domain.homework.StudentHomework;

import java.util.List;

public interface ClassAddService {

    public int classAdd(ClassAdd classAdd);

    public List<ClassAdd> ClassAddList(int classId);

}

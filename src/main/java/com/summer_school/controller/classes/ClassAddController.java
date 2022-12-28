package com.summer_school.controller.classes;

import com.summer_school.domain.classes.ClassAdd;
import com.summer_school.domain.homework.Homework;
import com.summer_school.domain.homework.StudentHomework;
import com.summer_school.service.classes.ClassAddService;
import com.summer_school.service.classes.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/classAdd")
public class ClassAddController {

    @Autowired
    private ClassAddService classAddService;


    //加入班级
    @RequestMapping("/StudentAdd")
    public String classAdd(@RequestParam(value = "classId") int classId,
                              @RequestParam(value = "userId") int userId,
                              @RequestParam(value = "identity") String identity){
        ClassAdd classAdd=new ClassAdd();
        classAdd.setClassId(classId);
        classAdd.setUserId(userId);
        classAdd.setIdentity(identity);
        if(classAddService.classAdd(classAdd)==1)
            return "Successful ";
        else {
            return "Fail ";
        }
    }

    //查看班级（根据班级id查看）
    @RequestMapping("/getClassAddList")
    public List<ClassAdd> ClassAddList(int classId){
        return classAddService.ClassAddList(classId);
    }

}

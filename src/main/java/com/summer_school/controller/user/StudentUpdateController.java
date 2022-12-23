package com.summer_school.controller.user;


import ch.qos.logback.core.model.Model;
import com.summer_school.controller.tool.Code;
import com.summer_school.controller.tool.Result;
import com.summer_school.domain.user.lasting.Student;
import com.summer_school.service.signup_and_examine.StudentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentUpdate")
public class StudentUpdateController {
    @Autowired
    private StudentUpdateService studentUpdateService;

    @PutMapping
    public Result update(@RequestBody Student student){
        boolean flag=studentUpdateService.update(student);
        return new Result(flag? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Student student = studentUpdateService.findById(id);
        Integer code = student !=null?Code.GET_OK:Code.GET_ERR;
        String msg = student !=null?"":"数据查询失败，请重试！";
        return new Result(code,student,msg);
    }


}

package com.summer_school.controller.update;


import com.summer_school.controller.tool.Code;
import com.summer_school.controller.tool.Result;
import com.summer_school.domain.user.lasting.Teacher;
import com.summer_school.service.update.TeacherUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacherUpdate")
public class TeacherUpdateController {
    @Autowired
    private TeacherUpdateService teacherUpdateService;

    @PutMapping
    public Result update(@RequestBody Teacher teacher){
        boolean flag=teacherUpdateService.update(teacher);
        return new Result(flag? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Teacher teacher = teacherUpdateService.findById(id);
        Integer code = teacher !=null?Code.GET_OK:Code.GET_ERR;
        String msg = teacher !=null?"":"数据查询失败，请重试！";
        return new Result(code,teacher,msg);
    }


}

package com.summer_school.controller.classes;

import com.summer_school.controller.tool.Code;
import com.summer_school.controller.tool.Result;

import com.summer_school.domain.classes.Classes;

import com.summer_school.service.classes.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;


    @PostMapping
    public Result save(@RequestBody Classes classes) {
        boolean flag = classesService.save(classes);
        return new Result(flag ? Code.INSERT_OK: Code.INSERT_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Classes classes = classesService.getById(id);
        Integer code = classes != null ? Code.GET_OK : Code.GET_ERR;
        String msg = classes != null ? "" : "数据查询失败，请重试！";
        return new Result(code,classes,msg);
    }




}

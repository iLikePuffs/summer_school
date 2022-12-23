package com.summer_school.controller.user;


import com.summer_school.controller.tool.Code;
import com.summer_school.controller.tool.Result;
import com.summer_school.domain.user.lasting.EducationalAdministartor;
import com.summer_school.domain.user.lasting.Teacher;
import com.summer_school.service.signup_and_examine.EducationalAdministartorUpdateService;
import com.summer_school.service.signup_and_examine.TeacherUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EducationalAdministartorUpdate")
public class EducationalAdministartorUpdateController {
    @Autowired
    private EducationalAdministartorUpdateService educationalAdministartorUpdateService;

    @PutMapping
    public Result update(@RequestBody EducationalAdministartor educationalAdministartor){
        boolean flag=educationalAdministartorUpdateService.update(educationalAdministartor);
        return new Result(flag? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        EducationalAdministartor educationalAdministartor = educationalAdministartorUpdateService.findById(id);
        Integer code = educationalAdministartor !=null?Code.GET_OK:Code.GET_ERR;
        String msg = educationalAdministartor !=null?"":"数据查询失败，请重试！";
        return new Result(code,educationalAdministartor,msg);
    }


}

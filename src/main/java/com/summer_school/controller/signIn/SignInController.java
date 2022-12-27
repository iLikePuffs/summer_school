package com.summer_school.controller.signIn;


import com.summer_school.controller.tool.Code;
import com.summer_school.controller.tool.Result;
import com.summer_school.domain.classes.Classes;
import com.summer_school.domain.signIn.SignIn;
import com.summer_school.service.signIn.SignInService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/signIn")
public class SignInController {

    @Autowired
    private SignInService signInService;

    //创建签到
    @PostMapping("/put")
/**
    public int punch_in(HttpServletRequest request) throws Exception {
        //操作记录条数，初始化为0

        //打卡控制
        SignIn signIn = new SignIn();
        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//打卡时间格式化

        signIn.setSignPutTime((Timestamp) format.parse(format.format(date)));

        signInService.sign_put(signIn);
       // Date nowTime = format.parse(format.format(date));//当前时分秒


        return 1;
    }
**/

    public Result sign_put(@RequestBody SignIn signIn) {
        boolean flag = signInService.sign_put(signIn);
        return new Result(flag ? Code.INSERT_OK: Code.INSERT_ERR,flag);
    }

    //正常签到
    @PostMapping("/sign_in")
    public Result sign_in(@RequestBody SignIn signIn) {
        boolean flag = signInService.sign_in(signIn);
        return new Result(flag ? Code.INSERT_OK: Code.INSERT_ERR,flag);
    }
    //补签
    @PostMapping("/sign_re")
    public Result sign_in_re(@RequestBody SignIn signIn) {
        boolean flag = signInService.sign_in_re(signIn);
        return new Result(flag ? Code.INSERT_OK: Code.INSERT_ERR,flag);
    }



}
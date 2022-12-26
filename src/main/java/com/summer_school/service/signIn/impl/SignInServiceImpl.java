package com.summer_school.service.signIn.impl;

import com.summer_school.dao.classes.ClassesDao;
import com.summer_school.dao.signIn.SignInDao;
import com.summer_school.domain.classes.Classes;
import com.summer_school.domain.signIn.SignIn;
import com.summer_school.service.signIn.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private SignInDao signInDao;


    //发布签到
    @Override
    /**
    public int sign_put(SignIn signIn){
        return signInDao.sign_put(signIn);
    }
**/

    public boolean sign_put(SignIn signIn){
        return signInDao.sign_put(signIn)>0;
    }

    //正常签到打卡
    public boolean sign_in(SignIn signIn) {

        return signInDao.sign_in(signIn)>0;
    }

    //补签
    public boolean sign_in_re(SignIn signIn) {

        return signInDao.sign_in_re(signIn)>0;
    }

}

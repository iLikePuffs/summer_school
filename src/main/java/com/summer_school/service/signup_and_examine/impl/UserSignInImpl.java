package com.summer_school.service.signup_and_examine.impl;

import com.summer_school.dao.user.EducationalAdministartorDao;
import com.summer_school.dao.user.StudentDao;
import com.summer_school.dao.user.SystemAdministratorDao;
import com.summer_school.dao.user.TeacherDao;

import com.summer_school.service.signup_and_examine.UserSignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSignInImpl implements UserSignInService {

    @Autowired
    private SystemAdministratorDao systemAdministratorDao;

    @Autowired
    private EducationalAdministartorDao educationalAdministartorDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

    //查询账号和密码，并携带身份返回
    @Override
    public String signIn(String account, String password) {
        if (systemAdministratorDao.signIn(account,password) != null){
            return "系统管理员";
        } else if (educationalAdministartorDao.signIn(account,password) != null){
            return "教务管理员";
        } else if (teacherDao.signIn(account,password) != null){
            return "老师";
        } else if (studentDao.signIn(account,password) != null){
            return "学生";
        }

        return null;
    }
}

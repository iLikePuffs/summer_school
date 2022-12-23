package com.summer_school.service.signup_and_examine;

import com.summer_school.domain.user.lasting.EducationalAdministartor;
import com.summer_school.domain.user.lasting.Teacher;

public interface EducationalAdministartorUpdateService {
    //修改教务管理员信息
    public boolean update(EducationalAdministartor educationalAdministartor);

    //按id查询
    public EducationalAdministartor findById(Integer id);

}

package com.summer_school.service.signup_and_examine.impl;

import com.summer_school.dao.user.EducationalAdministartorDao;
import com.summer_school.dao.user.TeacherDao;
import com.summer_school.domain.user.lasting.EducationalAdministartor;
import com.summer_school.domain.user.lasting.Teacher;
import com.summer_school.service.signup_and_examine.EducationalAdministartorUpdateService;
import com.summer_school.service.signup_and_examine.TeacherUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationalAdministartorUpdateServiceImpl implements EducationalAdministartorUpdateService {

    @Autowired
    private EducationalAdministartorDao educationalAdministartorDao;

  //  @Override
    public boolean update(EducationalAdministartor educationalAdministartor) {
        return educationalAdministartorDao.update(educationalAdministartor)>0;

    }

   // @Override
    public EducationalAdministartor findById(Integer id) {
        return educationalAdministartorDao.findById(id);
    }

}

package com.summer_school.service.signIn;

import com.summer_school.domain.classes.Classes;
import com.summer_school.domain.signIn.SignIn;

public interface SignInService {

    //创建签到
   // public int sign_put(SignIn signIn);
   public boolean sign_put(SignIn signIn);
    //正常签到打卡
    boolean sign_in(SignIn signIn);

    //补签
    boolean sign_in_re(SignIn signIn);

}

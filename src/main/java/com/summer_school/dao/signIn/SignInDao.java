package com.summer_school.dao.signIn;


import com.summer_school.domain.signIn.SignIn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignInDao {

    //创建签到（发布签到）
    @Insert("insert into sign_in_attendance_table (researchHotSpotId,signPutTime) values(#{researchHotSpotId},#{signPutTime})")
  //  @Insert("insert into sign_in_attendance_table (researchHotSpotId) values(#{researchHotSpotId})")
    public int sign_put(SignIn signIn);



    //正常签到
    @Insert("insert into sign_in_attendance_table (studentId,signInTime,signStatus) values(#{studentId},#{signInTime},'正常')")
    public int sign_in(SignIn signIn);

    //补签
    @Insert("insert into sign_in_attendance_table (studentId,signInTime,signStatus) values(#{studentId},#{signInTime},'补签')")
    public int sign_in_re(SignIn signIn);
}

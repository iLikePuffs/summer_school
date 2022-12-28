package com.summer_school.controller.homework;

import com.summer_school.domain.homework.Homework;
import com.summer_school.domain.homework.StudentHomework;
import com.summer_school.service.homework.StudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/studentHomework")
public class StudentHomeworkController {

    @Autowired
    private StudentHomeworkService studentHomeworkService;

    //根据作业id获取作业详情
    @RequestMapping("/getDetailHomeworkList")
    public List<StudentHomework> GetDetailHomeworkList(int homeWorkID){
        return studentHomeworkService.DetailHomeworkList(homeWorkID);
    }

    //获取作业
    @RequestMapping("/getHomeworkList")
    public List<StudentHomework> StudentHomeworkList(){
        return studentHomeworkService.StudentHomeworkList();
    }

    //提交作业

    @RequestMapping("/insertHomework")
    public String insertSHomework(@RequestParam(value = "studentHomeWorkID") int studentHomeWorkID,
                              @RequestParam(value = "studentId") int studentId,
                              @RequestParam(value = "homeWorkID") int homeWorkID,
                              @RequestParam(value = "homeworkContent") String homeworkContent,
                              @RequestParam(value = "create_time") Timestamp create_time,
                           //       @RequestParam(value = "correctingStatus") String correctingStatus
                              @RequestParam(value = "correctingStatus") String correctingStatus){
        StudentHomework homework=new StudentHomework();
        homework.setStudentHomeWorkID(studentHomeWorkID);
        homework.setStudentId(studentId);
        homework.setHomeWorkID(homeWorkID);
        homework.setHomeworkContent(homeworkContent);
        homework.setCreate_time(create_time);
        homework.setCorrectingStatus("未批改");
      //  homework.setScore(score);

        if(studentHomeworkService.addStudentHomework(homework)==1)
            return "Successful insert";
        else {
            return "Fail insert";
        }
    }

    //批改作业
    @RequestMapping("/correctHomework")
    public String correctHomework(@RequestParam(value = "studentHomeWorkID") int studentHomeWorkID,
                                  @RequestParam(value = "correctingStatus") String correctingStatus,
                                  @RequestParam(value = "score") int score){
        StudentHomework homework=new StudentHomework();
        homework.setCorrectingStatus("已批改");
        homework.setScore(score);
        if(studentHomeworkService.correctHomework(studentHomeWorkID,correctingStatus,score)==1)
            return "Successful ";
        else {
            return " Fail";
        }


    }


}

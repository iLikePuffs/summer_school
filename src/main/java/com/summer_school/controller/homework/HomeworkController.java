package com.summer_school.controller.homework;


import com.summer_school.domain.homework.Homework;
import com.summer_school.service.homework.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    //获取作业列表
    @RequestMapping("/getHomeworkList")
    public List<Homework> GetHomeworkList(){
        return homeworkService.homeworkList();
    }

    //发布作业
    @RequestMapping("/addHomework")
    public String addHomework(@RequestParam(value = "homeWorkID") int homeWorkID,
                              @RequestParam(value = "title") String title,
                              @RequestParam(value = "homeWorkContent") String homeWorkContent,
                              @RequestParam(value = "publisherId") int publisherId,
                              @RequestParam(value = "publisherIdentity") String publisherIdentity,
                              @RequestParam(value = "publishTime") Timestamp publishTime,
                              @RequestParam(value = "endTime") Timestamp endTime){
        Homework homework=new Homework();
        homework.setHomeWorkID(homeWorkID);
        homework.setTitle(title);
        homework.setHomeWorkContent(homeWorkContent);
        homework.setPublisherId(publisherId);
        homework.setPublisherIdentity(publisherIdentity);
        homework.setPublishTime(publishTime);
        homework.setEndTime(endTime);

        System.out.println(homework.getPublishTime());

        if(homeworkService.insertHomework(homework)==1)
            return "Successful insert";
        else {
            return "Fail insert";
        }
    }


}

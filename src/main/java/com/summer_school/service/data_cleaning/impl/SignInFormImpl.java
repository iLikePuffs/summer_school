package com.summer_school.service.data_cleaning.impl;

import com.summer_school.dao.HotSpotDao;
import com.summer_school.dao.StudentDao;
import com.summer_school.pojo.dto.CleanInfo;
import com.summer_school.pojo.po.HotSpotSignIn;
import com.summer_school.pojo.po.Student;
import com.summer_school.service.data_cleaning.FormCleaningService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.*;

import static com.summer_school.service.data_cleaning.impl.ParticipationFormImpl.extractNameAndSchool;
import static com.summer_school.service.data_cleaning.impl.ParticipationFormImpl.isAllChinese;

@Service
public class SignInFormImpl implements FormCleaningService {
    private List startSignInTime = new ArrayList<>();
    private List<List<String>> userName = new ArrayList<>();
    private List<List> signInTime = new ArrayList<>();
    private List<List<String>> schoolNameList = new ArrayList<>();

    @Autowired
    StudentDao studentDao;
    @Autowired
    HotSpotDao hotSpotDao;

    /**
     * 将表格里每列的数据读到一个list里
     *
     * @return 这些list的集合
     */
    @Override
    public void readToList(CleanInfo cleanInfo) throws Exception {


        String fileURL = cleanInfo.getFileURL();
        File excel = new File(fileURL);
        Workbook wb;

        wb = new XSSFWorkbook(new FileInputStream(excel));

        //有几个签到表就循环几次
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {

            Sheet sheet = wb.getSheetAt(i);

            List<String> nameTemp = new ArrayList<>();
            List<String> signInTimeTemp = new ArrayList<>();

            //读取签到开始时间(从索引7开始截取,就没有中文了)
            Row row = sheet.getRow(0);
            Cell cell = row.getCell(0);
            String startTime = cell.toString().substring(7).trim();
            startSignInTime.add(startTime);


            int lastRowIndex = sheet.getLastRowNum();

            //遍历行
            for (int rIndex = 4; rIndex <= lastRowIndex; rIndex++) {
                row = sheet.getRow(rIndex);
                if (row != null) {
                    int firstCellIndex = row.getFirstCellNum();
                    int lastCellIndex = row.getLastCellNum();

                    //遍历列
                    for (int cIndex = firstCellIndex; cIndex < 7; cIndex++) {
                        switch (cIndex) {
                            case 0:
                                nameTemp.add(row.getCell(cIndex).toString());
                                break;
                            case 2:
                                signInTimeTemp.add(row.getCell(cIndex).toString());
                                break;
                        }
                    }
                }
            }

            //把两个list加入到双重list里
            userName.add(nameTemp);
            signInTime.add(signInTimeTemp);
        }

    }


    /**
     * 调用多个相关清洗算法进行清洗
     *
     * @return
     */
    @Override
    public void clean() {

        //清洗签到表里的名字+学校名称
        cleanUserNameAndSchool();

        //移除获得的列表里的空的名字
        removeNull();

        //清洗签到开始时间
        cleanTime(startSignInTime);

        //清洗每个学生的签到时间
        for (int i = 0; i < startSignInTime.size(); i++) {
            cleanTime(signInTime.get(i));
        }

        System.out.println("");
    }

    /**
     * 计算签到评分（只计算这个暑期学校的学生）
     */
    @Override
    public void analyze(CleanInfo cleanInfo) {
        List<HotSpotSignIn> hotSpotSignIns = new ArrayList<>();

        //根据传入的暑期学校id，从学生表里找出这个暑期学校所有的学生名字和id（接收）
        List<Student> student = studentDao.showPartStudentInfo(cleanInfo.getSummerSchoolId());

        //根据传入的研究热点名字，从研究热点热点表中找出每个对应的id
        List<Integer> hotSpotId = new ArrayList<>();
        for (int i = 0; i < cleanInfo.getHotSpotName().length; i++) {
            hotSpotId.add(hotSpotDao.selectIdByName(cleanInfo.getHotSpotNameSingle()));
        }

        //有几个签到表，最外层就循环几次;第几个签到表，就对应第几个研究热点
        for (int i = 0; i < userName.size(); i++) {
            //这个签到表对应几个学生名字，第二层就循环几次
            for (int j = 0; j < userName.get(i).size(); j++) {
                //从学生表里找出这个暑期学校所有的学生名字有几个，第三层就循环几次
                for (int k = 0; k < student.size(); k++) {
                    /**
                     * 如果找到了相同的名字,就计算签到评分
                     * 然后把研究热点id，学生id和签到评分一起加到存储HotSpotSignIn对象的list里
                     */
                    if (userName.get(i).get(j).equals(student.get(k).getStudentName())) {
                        HotSpotSignIn hotSpotSignIn = new HotSpotSignIn();

                        //计算签到评分
                        int score = calculateSignInScore((Date) startSignInTime.get(i), (Date) signInTime.get(i).get(j));

                        //存入list
                        hotSpotSignIn.setResearchHotSpotId(hotSpotId.get(i));
                        hotSpotSignIn.setStudentId(student.get(k).getId());
                        hotSpotSignIn.setSignInScore(score);
                    }
                }
            }

        }


    }

    /**
     * 将清洗后的数据存入相应的位置
     *
     * @return
     */
    @Override
    public boolean save(CleanInfo cleanInfo) {
        return false;
    }


    /**
     * 清洗签到表的名字和学校名称
     * 因为没有括号，所以和参会详情表略有不同
     */
    void cleanUserNameAndSchool() {
        List<String> stringList;
        List<String> testList = new ArrayList<>();
        String eachUserName = "";
        String eachSchoolName = "";

        //有几个签到表，最外层遍历几次
        for (int k = 0; k < userName.size(); k++) {

            List<String> tempSchoolNameList = new ArrayList<>();

            //每个表有多少数据，第二层就遍历几次
            for (int i = 0; i < userName.get(k).size(); i++) {
                //清空testList
                testList.clear();

                //拿到原始用户名
                String s = userName.get(k).get(i);

                //先只去掉- +
                stringList = Arrays.asList(s.split("[- _+]"));

                //把不为空的字符串放到一个新的list里
                for (int j = 0; j < stringList.size(); j++) {
                    if (!("".equals(stringList.get(j)))) {
                        testList.add(stringList.get(j));
                    }
                }


                //被划分为3个及以上元素的数据
                if (testList.size() >= 3) {
                    boolean schoolName = false;
                    String tempSchoolName = null;
                    boolean profession = false;

                    for (int j = 0; j < testList.size(); j++) {
                        if (testList.get(j).contains("大")) {
                            schoolName = true;
                            tempSchoolName = testList.get(j);
                        }

                        if (testList.get(j).contains("学院")) {
                            profession = true;
                        }

                        if (testList.get(j).contains("大") || testList.get(j).contains("学院")) {
                            eachSchoolName = testList.get(j);
                        }

                        if (testList.get(j).length() >= 2 && testList.get(j).length() <= 3 && !(testList.get(j).contains("院"))) {
                            eachUserName = testList.get(j);
                        }
                    }

                    if (schoolName && profession) {
                        eachSchoolName = tempSchoolName;
                    }

                    //元素2的双元素处理
                } else if (testList.size() == 2) {
                    if (testList.get(0).contains("大") || testList.get(0).contains("学院")) {
                        eachSchoolName = testList.get(0);
                        eachUserName = testList.get(1);
                    } else if (testList.get(1).contains("大") || testList.get(0).contains("学院")) {
                        eachSchoolName = testList.get(1);
                        eachUserName = testList.get(0);
                    }

                    //单元素处理
                } else if (testList.size() == 1) {

                    //如果这个元素不是纯中文，判断为无效数据
                    if (!isAllChinese(testList.get(0))) {
                        eachUserName = "";
                        eachSchoolName = "";

                        //如果这个元素是纯中文，就对他进行(名字+学校名称提取)
                    } else {
                        String[] elementString1 = extractNameAndSchool(testList.get(0));
                        eachUserName = elementString1[0];
                        eachSchoolName = elementString1[1];
                    }

                }

                //在if-else结束后才进行设置和add，防止多add数据导致全部数据错位
                userName.get(k).set(i, eachUserName);
                tempSchoolNameList.add(eachSchoolName);
            }

            schoolNameList.add(tempSchoolNameList);
        }
    }

    /**
     * 迭代器移除名字双重list里为空的元素
     */
    void removeNull() {
        for (int i = 0; i < userName.size(); i++) {
            Iterator<String> it = userName.get(i).iterator();
            while (it.hasNext()) {
                String x = it.next();
                if (x.equals("")) {
                    it.remove();
                }
            }
        }
    }


    /**
     * 根据签到开始时间和签到时间计算这个学生的签到评分
     */
    public int calculateSignInScore(Date startSignInTime,Date signInTime) {
        //计算两个日期的秒数差
        int seconds = (int) Duration.between((Temporal) startSignInTime, (Temporal) signInTime).getSeconds();

        //将秒数差传入计算签到评分的函数表达式
        int score = (int)(-0.000444444444 * seconds + 100);
        return score;
    }

    /**
     * 清洗时间：将传入的List里面的String类型的时间都转为Date类型
     * time是转前的string,date是转后得到的
     */
    public void cleanTime(List stringTimeList) {
        for (int i = 0; i < stringTimeList.size(); i++) {
            Date date = null;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = formatter.parse((String) stringTimeList.get(i));
                stringTimeList.set(i,date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

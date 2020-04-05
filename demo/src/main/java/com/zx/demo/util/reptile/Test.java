package com.zx.demo.util.reptile;


import com.zx.demo.bean.es.Student;
import com.zx.demo.util.PoiUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: Test
 * Description: 爬虫test
 *
 * @author 2957145040@qq.com
 * @version 1.0
 * date 2020/4/4 12:05
 */
@Slf4j
public class Test {

    private static int pageSize = 238;

    public static void main(String[] args) {
        String peopleUrl = "https://baike.baidu.com/api/starflower/starflowerstarlist?weekType=thisWeek&rankType=all&page=";
        String peoplePattern = "\"name\":\"?(.*?)(\"+)";
        List<Student> students = new LinkedList<>();
        for(int i=0; i<pageSize; i++){
            Reptile peopleReptile = new Reptile();
            peopleReptile.regexString(peopleUrl+i, peoplePattern);
            peopleReptile.toUtf();
            List<String> names = peopleReptile.getResultList();
            for(String name:names){
                Student student = new Student();
                student.setName(name);
                students.add(student);
            }
        }
        log.info("student.size:[{}]", students.size());
        long sta = System.currentTimeMillis();
        for(int i=0; i<students.size(); i++){
            StringBuilder personUrl = new StringBuilder("https://baike.baidu.com/item/");
            String personPattern = "<meta name=\"description\" content=\"?(.*?)(\"+)";
            personUrl.append(students.get(i).getName());
            Reptile personReptile = new Reptile();
            personReptile.regexString(personUrl.toString(), personPattern);
            if(!personReptile.getResultList().isEmpty()){
                students.get(i).setAddress(personReptile.getResultList().get(0));
            }else{
                log.warn("[{}] student's address is null;name:[{}]", i, students.get(i).getName());
                students.get(i).setAddress("");
            }
            students.get(i).setAge((int)(Math.random()*60+14));
        }
        log.info("start export...");
        PoiUtil poiUtil = new PoiUtil();
        String fileName = "D:\\WorkSpaces\\MyWorkSpaces\\demo\\demo\\src\\main\\resources\\static\\excel\\student.xlsx";
        poiUtil.exportExcel(fileName, "student", Student.class, students);
    }
}
package com.zx.demo.util.reptile;


import com.zx.demo.bean.es.Star;
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
        List<Star> stars = new LinkedList<>();
        for(int i=0; i<pageSize; i++){
            Reptile peopleReptile = new Reptile();
            peopleReptile.regexString(peopleUrl+i, peoplePattern);
            peopleReptile.toUtf();
            List<String> names = peopleReptile.getResultList();
            for(String name:names){
                Star star = new Star();
                star.setName(name);
                stars.add(star);
            }
        }
        log.info("star.size:[{}]", stars.size());
        long sta = System.currentTimeMillis();
        for(int i=0; i<stars.size(); i++){
            StringBuilder personUrl = new StringBuilder("https://baike.baidu.com/item/");
            String personPattern = "<meta name=\"description\" content=\"?(.*?)(\"+)";
            personUrl.append(stars.get(i).getName());
            Reptile personReptile = new Reptile();
            personReptile.regexString(personUrl.toString(), personPattern);
            if(!personReptile.getResultList().isEmpty()){
                stars.get(i).setAddress(personReptile.getResultList().get(0));
            }else{
                log.warn("[{}] star's address is null;name:[{}]", i, stars.get(i).getName());
                stars.get(i).setAddress("");
            }
            stars.get(i).setAge((int)(Math.random()*60+14));
        }
        log.info("start export...");
        PoiUtil poiUtil = new PoiUtil();
        String fileName = "D:\\WorkSpaces\\MyWorkSpaces\\demo\\demo\\src\\main\\resources\\static\\excel\\star.xlsx";
        poiUtil.exportExcel(fileName, "star", Star.class, stars);
    }
}
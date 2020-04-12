package com.zx.demo.controller;

import com.zx.demo.bean.es.Star;
import com.zx.demo.util.PoiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Title: ExcelController
 * Description: ExcelController
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/31 14:28
 */
@RequestMapping("/excel")
@RestController
@Slf4j
public class ExcelController {

    @Autowired
    private PoiUtil poiUtil;

    /**
     *  读取excel
     * @param file 文件
     * @return 读取结果
     */
    @PostMapping("/read")
    public Object readExcel(MultipartFile file){
        String[] fields = {"name","age", "address"};
        try {
            return poiUtil.importExcel(file.getInputStream(), Star.class, 0, fields);
        } catch (IOException e) {
            log.info("错误信息{}", e);
        }
        return null;
    }
}

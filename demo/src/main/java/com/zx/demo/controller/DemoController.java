package com.zx.demo.controller;

import com.zx.demo.bean.Demo;
import com.zx.demo.enums.ResultStatusEnum;
import com.zx.demo.model.GlobalResponseModel;
import com.zx.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Title: DemoController
 * Description: DemoController
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/14 15:09
 */
@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @GetMapping("/query/{id}")
    public GlobalResponseModel queryDemoById(@PathVariable int id){
        Demo demo = demoService.queryDemoById(id);
        if(null!=demo){
            return GlobalResponseModel.builder()
                    .data(demo)
                    .message(ResultStatusEnum.SUCCESS.getMessage())
                    .code(ResultStatusEnum.SUCCESS.getCode()).build();
        }
        return GlobalResponseModel.builder()
                .message(ResultStatusEnum.ID_NOT_EXIST.getMessage())
                .code(ResultStatusEnum.SUCCESS.getCode()).build();
    }

    @GetMapping("/aspect/read/{id}")
    public GlobalResponseModel aspectRead(@PathVariable int id,int time){
        return GlobalResponseModel.builder()
                .data(demoService.twoReadById(id,time))
                .message(ResultStatusEnum.SUCCESS.getMessage())
                .code(ResultStatusEnum.SUCCESS.getCode()).build();
    }

    @GetMapping("/aspect/write")
    public GlobalResponseModel write(Demo demo, int time){
        demoService.updateDemoById(demo,time);
        return GlobalResponseModel.builder()
                .message(ResultStatusEnum.SUCCESS.getMessage())
                .code(ResultStatusEnum.SUCCESS.getCode()).build();
    }
}

package com.zx.demo.controller;

import com.zx.demo.bean.User;
import org.springframework.web.bind.annotation.*;

/**
 * Title: TestController
 * Description: 示例请求传参
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2019/12/16 14:54
 */
@RequestMapping("/request")
@RestController
public class TestController {

    @RequestMapping(value = "/get/object", method = RequestMethod.GET)
    public Object getRequest(@RequestBody Object user){
        return user;
    }

    @RequestMapping(value = "/post/object", method = RequestMethod.POST)
    public Object postRequestObject(@RequestBody User user){
        return user;
    }

    @RequestMapping(value = "/post/param", method = RequestMethod.POST)
    public Object postRequestParam(@RequestParam("user") User user){
        return user;
    }

}

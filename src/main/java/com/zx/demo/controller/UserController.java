package com.zx.demo.controller;

import com.zx.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Title: UserController
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/9/18 18:00
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/query/id/{param}")
    public Object queryUserById(@PathVariable String param){
        return ResponseEntity.ok(userService.queryById(param));
    }

    @RequestMapping("/user/query/jg/{param}")
    public Object queryUserByJg(@PathVariable String param) {
        return ResponseEntity.ok(userService.queryByJg(param));
    }

}

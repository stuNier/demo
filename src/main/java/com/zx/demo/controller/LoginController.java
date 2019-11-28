package com.zx.demo.controller;

import com.zx.demo.bean.User;
import com.zx.demo.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: LoginController
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/27 14:26
 */
@RestController
public class LoginController {

    private final ILoginService loginService;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/user/login")
    public Object login(HttpServletRequest request, HttpServletResponse response, User user){
        loginService.login(request, response, user);
        logger.info(request.getParameter("url"));
        return request.getParameter("url");
    }

    @RequestMapping("/user/loginOut")
    public Object loginOut(HttpServletRequest request){
        loginService.loginOut(request);
        return ResponseEntity.ok("success");
    }
}

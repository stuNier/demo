package com.zx.demo.controller;

import com.zx.demo.bean.User;
import com.zx.demo.enums.ResultStatusEnum;
import com.zx.demo.model.GlobalResponseModel;
import com.zx.demo.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: LoginController
 * Description: 登录接口Controller
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/27 14:26
 */
@Slf4j
@RestController
@Api(tags = "用户登录登出")
@RequestMapping("/user")
public class LoginController {


    private final ILoginService loginService;


    /**
     * 构造函数
     * @param loginService loginService
     */
    @Autowired
    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 登录接口
     * @param request request
     * @param response response
     * @param user 用户信息
     * @return 结果
     */
    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public GlobalResponseModel login(HttpServletRequest request, HttpServletResponse response,@RequestBody User user){
        return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
            .message(ResultStatusEnum.SUCCESS.getMessage())
            .data(loginService.login(request, response, user)).build();
    }

    /**
     * 登出接口
     * @param request request
     * @return 结果
     */
    @ApiOperation("用户登出接口")
    @PostMapping("/loginOut")
    public Object loginOut(HttpServletRequest request){
        loginService.loginOut(request);
        return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                .message(ResultStatusEnum.SUCCESS.getMessage())
                .build();
    }
}

package com.zx.demo.service.impl;

import com.zx.demo.bean.User;
import com.zx.demo.service.ILoginService;
import com.zx.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Title: LoginServiceImpl
 * Description: 登录Controller
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/27 15:50
 */
@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {

    private final JedisPool jedisPool;

    private final IUserService userService;

    @Autowired
    public LoginServiceImpl(JedisPool jedisPool, IUserService userService) {
        this.jedisPool = jedisPool;
        this.userService = userService;
    }

    @Override
    public Object login(HttpServletRequest request, HttpServletResponse response, User user) {
        log.info(user.toString());
        User result = userService.queryByAccount(user.getAccount());
        if(null==result || !result.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("failed");
        }
        Jedis jedis = jedisPool.getResource();
        String token = DigestUtils.md5Hex(user.getAccount()+new Date().toString());
        jedis.set(token, user.getAccount());
        jedis.expire(token, 600);
        jedis.close();
        Cookie cookie = new Cookie("userAccount",token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResponseEntity.ok("success");
    }

    @Override
    public void loginOut(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(null == cookies) {
            return;
        }
        Jedis jedis = jedisPool.getResource();
        for (Cookie cookie:cookies) {
            if("userAccount".equals(cookie.getName())
                    && Boolean.TRUE.equals(jedis.exists(cookie.getValue()))){
                jedis.del(cookie.getValue());
            }
        }
        jedis.close();
    }
}

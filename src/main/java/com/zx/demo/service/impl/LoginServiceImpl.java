package com.zx.demo.service.impl;

import com.zx.demo.bean.User;
import com.zx.demo.service.ILoginService;
import com.zx.demo.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Title: LoginServiceImpl
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/27 15:50
 */
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
    public void login(HttpServletRequest request, HttpServletResponse response, User user) {
        User result = userService.queryByAccount(user.getAccount());
        if(!result.getPassword().equals(user.getPassword()))
            return;
        Jedis jedis = jedisPool.getResource();
        String token = DigestUtils.md5Hex(user.getAccount()+new Date().toString());
        jedis.set(token, user.getAccount());
        jedis.expire(token, 60);
        jedis.close();
        Cookie cookie = new Cookie("userAccount",token);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public void loginOut(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(null == cookies)
            return;
        Jedis jedis = jedisPool.getResource();
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("userAccount")
                    && jedis.exists(cookie.getValue())){
                jedis.del(cookie.getValue());
            }
        }
        jedis.close();
    }
}

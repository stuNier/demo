package com.zx.demo.service.impl;

import com.zx.demo.bean.User;
import com.zx.demo.mapper.UserMapper;
import com.zx.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title: UserService
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/28 15:14
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryByAccount(String account) {
        return userMapper.queryByAccount(account);
    }
}

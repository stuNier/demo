package com.zx.demo.service;

import com.zx.demo.bean.User;

/**
 * Title: UserService
 * Description: IUserService
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/28 15:12
 */
public interface IUserService {

    /**
     * 查询用户
     * @param account account
     * @return User
     * @author: zhengxin-3@thunisoft.com
     * date: 20-02-19 9:29
     * @version 1.0
     */
    User queryByAccount(String account);
}

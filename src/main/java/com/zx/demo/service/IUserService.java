package com.zx.demo.service;

import com.zx.demo.bean.User;

/**
 * Title: UserService
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/28 15:12
 */
public interface IUserService {

    User queryByAccount(String account);
}

package com.zx.demo.service;

import com.zx.demo.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: ILoginService
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/27 15:49
 */
public interface ILoginService {

    Object login(HttpServletRequest request, HttpServletResponse response, User user);

    void loginOut(HttpServletRequest request);
}

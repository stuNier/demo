package com.zx.demo.javaee.annotation;

import lombok.Data;

/**
 * Title: User
 * Description: user
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 11:15
 */
@Data
public class User {

    @Init(value = "str")
    private String name;

}

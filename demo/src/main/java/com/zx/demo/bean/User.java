package com.zx.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Title: User
 * Description: user
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/9/10 15:02
 */
@Data
@ApiModel("用户实体")
public class User {

    @ApiModelProperty("用户账号")
    private String account;

    @ApiModelProperty("用户登录密码")
    private String password;
}

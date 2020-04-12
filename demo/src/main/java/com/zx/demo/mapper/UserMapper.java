package com.zx.demo.mapper;

import com.zx.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Title: UserMapper
 * Description: UserMapper
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/9/10 15:07
 */
@Mapper
public interface UserMapper {
    /**
     * 查询
     * @param account 账号
     * @return User
     * author: zhengxin@thunisoft.com
     * date: 19-09-10 15:07
     * version 1.0
     */
    User queryByAccount(String account);
}

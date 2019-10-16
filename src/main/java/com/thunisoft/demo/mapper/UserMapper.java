package com.thunisoft.demo.mapper;

import com.thunisoft.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Title: UserMapper
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/9/10 15:07
 */
@Mapper
public interface UserMapper {
    /**
     * @param id
     * @return
     * @author: zhengxin@thunisoft.com
     * @date: 19-09-10 15:07
     * @version 1.0
     */
    User queryById(long id);

    List<User> queryByJg(String jg);
}

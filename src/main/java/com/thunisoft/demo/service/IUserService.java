package com.thunisoft.demo.service;

import com.thunisoft.demo.common.ResultUtil;
import org.springframework.stereotype.Service;

/**
 * Title: IUserService
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/9/10 15:04
 */
@Service
public interface IUserService {
    /**
     * @param param 查询参数
     * @return
     * @author: zhengxin@thunisoft.com
     * @date: 19-09-10 15:08
     * @version 1.0
     */
    ResultUtil queryById(String param);

    ResultUtil queryByJg(String jg);
}

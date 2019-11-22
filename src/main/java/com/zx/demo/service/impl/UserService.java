package com.zx.demo.service.impl;

import com.zx.demo.bean.User;
import com.zx.demo.common.ResultUtil;
import com.zx.demo.mapper.UserMapper;
import com.zx.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: UserService
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/9/10 15:05
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public ResultUtil queryById(String param) {
        ResultUtil resultUtil = new ResultUtil();
        Long id;
        try {
            param = param.replace(" ","");
            id = Long.parseLong(param);
        }catch (NumberFormatException e){
            e.printStackTrace();
            resultUtil.setData(e);
            resultUtil.setCode(500);
            resultUtil.setMessage("failed");
            logger.info(resultUtil.toString());
            return resultUtil;
        }
        User user = userMapper.queryById(id);
        resultUtil.setData(user);
        logger.info(resultUtil.toString());
        return resultUtil;
    }

    @Override
    public ResultUtil queryByJg(String param){
        ResultUtil resultUtil = new ResultUtil();
        param = param.replace(" ","");
        List<User> result = userMapper.queryByJg(param);
        if(result.isEmpty()){
            resultUtil.setMessage("failed");
            resultUtil.setCode(500);
        }
        resultUtil.setData(result);
        return resultUtil;
    }
}

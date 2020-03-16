package com.zx.demo.common;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Title: ResultUtil
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/9/18 18:28
 */
@Component
@Data
public class ResultUtil {

    /**
     * * 1xx：信息
     * 通信传输协议级信息。
     * 2xx：成功
     * 表示客户端的请求已成功接受。
     * 3xx：重定向
     * 表示客户端必须执行一些其他操作才能完成其请求。
     * 4xx：客户端错误
     * 此类错误状态代码指向客户端。
     * 5xx：服务器错误
     */
    private int code = 200;

    private String message = "success";

    private Object data;

    public ResultUtil(Object data){
        this.setData(data);
    }

    public ResultUtil(){
    }
}

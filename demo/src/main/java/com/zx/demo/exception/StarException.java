package com.zx.demo.exception;

/**
 * Title: StarException
 * Description: StarException
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 15:32
 */
public class StarException extends Exception{
    /**
     * StarException
     * @param message m
     */
    public StarException(String message) {
        super(message);
    }

    /**
     * StarException
     * @param cause c
     */
    public StarException(Throwable cause) {
        super(cause);
    }
}

package com.zx.demo.exception;

/**
 * Title: BookException
 * Description: BookException
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 14:20
 */
public class BookException extends Exception {

    /**
     * StarException
     *
     * @param message m
     */
    public BookException(String message) {
        super(message);
    }

    /**
     * StarException
     *
     * @param cause c
     */
    public BookException(Throwable cause) {
        super(cause);
    }

}

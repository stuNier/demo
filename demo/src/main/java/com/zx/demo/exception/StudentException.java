package com.zx.demo.exception;

/**
 * Title: StudentException
 * Description: StudentException
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 15:32
 */
public class StudentException extends Exception{
    /**
     * StudentException
     * @param message m
     */
    public StudentException(String message) {
        super(message);
    }

    /**
     * StudentException
     * @param cause c
     */
    public StudentException(Throwable cause) {
        super(cause);
    }
}

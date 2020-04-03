package com.zx.demo.enums;


/**
 * Title: ResultStatus
 * Description: ResultStatus
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/1 16:10
 */
public enum ResultStatusEnum {

    /**
     * 操作成功
     */
    SUCCESS(200,"操作成功"),
    /**
     * 操作失败
     */
    FAILED(1,"操作失败"),
    /**
     * id不存在
     */
    ID_NOT_EXIST(2,"id不存在"),
    /**
     * 文件不存在
     */
    FILE_NOT_EXISIT(3, "文件不存在"),
    /**
     * 文件为空
     */
    FILE_IS_NULL(4, "文件为空");

    /**
     * code
     */
    private int code;

    /**
     * message
     */
    private String message;

    /**
     * 构造函数
     * @param code 状态码
     * @param message 描述
     */
    ResultStatusEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    /**
     * getter
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * getter
     * @return message
     */
    public String getMessage() {
        return message;
    }
}

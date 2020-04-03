package com.zx.demo.enums;

/**
 * Title: TimeEnum
 * Description: 时间Enum
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/1 16:56
 */
public enum TimeEnum {

    /**
     * 12分钟
     */
    TWELVE_MINUTES(43200, "12分钟");

    /**
     * code
     */
    private int code;

    /**
     * 描述
     */
    private String message;

    /**
     * 构造函数
     * @param code code
     * @param message message
     */
    TimeEnum(int code, String message){
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

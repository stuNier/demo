package com.zx.demo.enums;

import lombok.Getter;

/**
 * Title: ExcelTypeEnum
 * Description: ExcelTypeEnum
 *
 * @author 2957145040@qq.com
 * @version 1.0
 * date 2020/4/5 18:07
 */
public enum ExcelTypeEnum {
    /**
     * 07版本后缀为XLSX
     */
    XLSX("XLSX", "07版本后缀为XLSX"),
    /**
     * 03版本后缀为XLSX
     */
    XLS("XLS", "03版本后缀为XLSX");

    @Getter
    private String str;

    @Getter
    private String message;

    ExcelTypeEnum(String str, String message) {
        this.str = str;
        this.message = message;
    }
}

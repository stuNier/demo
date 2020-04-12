package com.zx.java.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: Color
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2019/12/16 17:15
 */
@Data
@Slf4j
public class Color {
    private String message;

    public String getColor(List<String> colors){
        log.info(Arrays.toString(colors.toArray()));
        return Arrays.toString(colors.toArray());
    }
}

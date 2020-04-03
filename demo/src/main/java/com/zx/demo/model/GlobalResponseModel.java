package com.zx.demo.model;

import lombok.Builder;
import lombok.Data;

/**
 * Title: GlobalResponseModel
 * Description: 全局请求model
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/1 16:21
 */
@Data
@Builder
public class GlobalResponseModel {

    /**
     * code
     */
    private int code;

    /**
     * message
     */
    private String message;

    /**
     * data
     */
    private  Object data;
}

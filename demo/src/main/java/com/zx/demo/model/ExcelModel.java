package com.zx.demo.model;

import lombok.Data;

import java.util.List;

/**
 * Title: ExcelModel
 * Description: Excel导入模型
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 * @param <T> 泛型
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 14:54
 */
@Data
public class ExcelModel<T> {
    /**
     * excel数据列表
     */
    private List<T> dataList;

}

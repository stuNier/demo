package com.zx.demo.bean.es;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Title: Student
 * Description: Student
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/20 11:10
 */
@Data
@Document(indexName = "school")
@Mapping(mappingPath = "esConfig/StudentMapping.json")
public class Student implements Serializable {
    /**
     * id主键
     */
    @Id
    private Long id;

    /**
     *name
     */
    @Excel(name = "name")
    @NotNull
    private String name;

    /**
     * age
     */
    @Excel(name = "age")
    @NotNull
    private Integer age;

    /**
     * address地址
     */
    @Excel(name = "address")
    private String address;
}

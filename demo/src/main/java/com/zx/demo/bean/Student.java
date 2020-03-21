package com.zx.demo.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

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
@Document(indexName = "school", type = "student")
public class Student implements Serializable {
    /**
     * id主键
     */
    @Id
    private String id;

    /**
     *name
     */
    private String name;

    /**
     * age
     */
    private Integer age;

    /**
     * address地址
     */
    private String address;
}

package com.zx.demo.bean.es;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
public class Student implements Serializable {
    /**
     * id主键
     */
    @Id
    @Field(type = FieldType.Long)
    private Long id;

    /**
     *name
     */
    @Excel(name = "name")
    @NotNull
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;

    /**
     * age
     */
    @Excel(name = "age")
    @NotNull
    @Field(type = FieldType.Integer)
    private Integer age;

    /**
     * address地址
     */
    @Excel(name = "address")
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String address;
}

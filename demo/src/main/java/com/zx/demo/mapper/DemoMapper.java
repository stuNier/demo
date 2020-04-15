package com.zx.demo.mapper;

import com.zx.demo.bean.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Title: DemoMapper
 * Description: DemoMapper
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/14 14:47
 */
@Mapper
public interface DemoMapper {

    /**
     * 通过id查询
     * @param id id
     * @return demo实体
     */
    Demo queryDemoById(int id);

    /**
     * 查询所有
     * @return demo实体列表
     */
    List<Demo> queryAll();

    /**
     * 插入实体数据列表
     * @param demoList 实体列表
     */
    void insertDemoList(List<Demo> demoList);

    /**
     * 插入实体
     * @param demo 实体
     */
    void insertDemo(Demo demo);

    /**
     * 通过id更新
     * @param demo 实体
     */
    void updateDemoById(@Param("demo") Demo demo);

}

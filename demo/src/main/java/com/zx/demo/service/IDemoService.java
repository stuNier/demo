package com.zx.demo.service;

import com.zx.demo.bean.Demo;

import java.util.List;

/**
 * Title: UserService
 * Description: IUserService
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/28 15:12
 */
public interface IDemoService {

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
     * @param demoList 数据列表
     */
    void insertDemoList(List<Demo> demoList);

    /**
     * 插入实体
     * @param demo 数据实体
     */
    void insertDemo(Demo demo);


    /**
     * 读取两次
     * @param id id
     * @param time time
     * @return 两次读取的结果
     */
    String[] twoReadById(int id, int time);

    /**
     * 通过id更新
     * @param demo demo
     * @param time time
     * @return 更新结果
     */
    boolean updateDemoById(Demo demo, int time);
}

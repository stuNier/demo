package com.zx.demo.service.impl;

import com.zx.demo.bean.Demo;
import com.zx.demo.mapper.DemoMapper;
import com.zx.demo.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Title: DemoServiceImpl
 * Description: DemoServiceImpl
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/14 14:47
 */
@Slf4j
@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = RuntimeException.class)
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public Demo queryDemoById(int id) {
        return demoMapper.queryDemoById(id);
    }

    @Override
    public List<Demo> queryAll() {
        return demoMapper.queryAll();
    }

    @Override
    public void insertDemoList(List<Demo> demoList) {
        demoMapper.insertDemoList(demoList);
    }

    @Override
    public void insertDemo(Demo demo) {
        demoMapper.insertDemo(demo);
    }

    @Override
    public String[] twoReadById(int id,int time) {
        String[] result = new String[2];
        result[0] = demoMapper.queryDemoById(id).getDes();
        log.info("读：{}",result[0]);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        result[1] = demoMapper.queryDemoById(id).getDes();
        log.info("再读：{}",result[1]);
        return result;
    }

    @Override
    public boolean updateDemoById(Demo demo, int time) {
        if(null==demo){
            return false;
        }
        if(null==demoMapper.queryDemoById(demo.getId())){
            return false;
        }
        log.info("初始值为：{}，开始写入：{}", demoMapper.queryDemoById(demo.getId()).getDes(), demo.getDes());
        demoMapper.updateDemoById(demo);
        log.info("写完成，查询值为：{}", demoMapper.queryDemoById(demo.getId()).getDes());
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("提交，查询值为：{}", demoMapper.queryDemoById(demo.getId()).getDes());
        return true;
    }


}

package com.zx.demo.controller.threadController;

import com.zx.demo.bean.thread.ThreadA;
import com.zx.demo.bean.thread.ThreadB;
import com.zx.demo.common.GlobalValue;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: ThreadController
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/10/8 14:58
 */
@RestController
@RequestMapping("/thread")
@Api(tags = "线程测试")
public class ThreadController {

    private ThreadA tA = new ThreadA();

    private ThreadB tB = new ThreadB();

    /**
     * 随机执行
     */
    @RequestMapping("/random")
    public void threadTest(){
        Thread threadA = new Thread(tA,"ThreadA");
        Thread threadB = new Thread(tB,"ThreadB");
        threadA.start();
        threadB.start();
    }

    @RequestMapping("getvar")
    public Object getVar(){
        return GlobalValue.theadVar;
    }
}

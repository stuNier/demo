package com.zx.java.thread.semaphore;

/**
 * Title: LineOnTest
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/10/31 15:19
 */
public class LineOnTest {
    public static void main(String[] args) throws InterruptedException {
        Line line = new Line();
        line.start("ACB");
    }
}

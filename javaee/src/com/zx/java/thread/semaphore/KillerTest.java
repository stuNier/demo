package com.zx.java.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Title: RacerTest
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/10/31 14:49
 */
public class KillerTest {
    public static void main(String[] args) {
        Semaphore knife = new Semaphore(2);
        Killer killerA = new Killer(knife, "KillerA");
        Killer killerB = new Killer(knife, "KillerB");
        Killer killerC = new Killer(knife, "KillerC");
        new Thread(killerA).start();
        new Thread(killerB).start();
        new Thread(killerC).start();
    }
}

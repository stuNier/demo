package com.zx.demo.util.reptile;

import java.util.List;

/**
 * Title: ThreadRequest
 * Description: RequestThread
 *
 * @author 2957145040@qq.com
 * @version 1.0
 * date 2020/4/5 11:56
 */
public class RequestThread implements Runnable{

    private List<String> names;
    /**
     * 开始位置
     */
    private int startIndex;

    /**
     * 结束位置
     */
    private int endIndex;

    /**
     * url
     */
    private String url = "https://baike.baidu.com/item/";

    private String pattern = "<meta name=\"description\" content=\"?(.*?)(\"+)";
    @Override
    public void run() {

    }
}

package com.zx.demo.javaee.graph;

import java.io.IOException;
import java.util.List;

/**
 * Title: Test
 * Description: test
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/1 13:44
 */
public class Test {

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        List<Edge> edgeList = null;
        try {
            edgeList = readFile.readFromTextFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EdgesetArray edgesetArray = new EdgesetArray(edgeList);
        edgesetArray.print();
    }
}

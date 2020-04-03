package com.zx.demo.javaee.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: ReadFile
 * Description: 读取文件
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/1 13:48
 */
public class ReadFile {

    private String path = "D:\\zx\\demo\\demo\\src\\main\\resources\\static\\txt\\graph.txt";

    public List<Edge> readFromTextFile() throws IOException {
        List<Edge> edgeArray = new LinkedList<>();
        File filename = new File(path);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();
        while(line != null) {
            Edge edge = new Edge();
            edge.setStart(Integer.parseInt(line.split(" ")[0]));
            edge.setEnd(Integer.parseInt(line.split(" ")[1]));
            edgeArray.add(edge);
            line = br.readLine();
        }
        return edgeArray;
    }
}

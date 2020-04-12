package com.zx.demo.javaee.graph;


import java.util.LinkedList;
import java.util.List;

/**
 * Title: EdgesetArray
 * Description: 边集数组
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/1 13:00
 */
public class EdgesetArray {

    private List<Edge> edgeList;

    public EdgesetArray(){
        this.edgeList = new LinkedList<>();
    }

    public EdgesetArray(List<Edge> edgeList){
        this.edgeList = new LinkedList<>();
        for(Edge e:edgeList){
            Edge edge = new Edge();
            edge.setStart(e.getStart());
            edge.setEnd(e.getEnd());
            this.edgeList.add(edge);
        }
    }

    public void add(Edge edge){
        edgeList.add(edge);
    }

    public void print(){
        for(Edge e: edgeList){
            System.out.println(e.toString());
        }
    }

    public void findCircle(){
        for(Edge e:edgeList){

        }
    }
}

package com.zx.demo.service;

import com.zx.demo.bean.book.Order;

import java.util.List;

/**
 * Title: IOrderService
 * Description: IOrderService
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 17:56
 */
public interface IOrderService {

    /**
     * 创建order
     * @param order order
     */
    void insertOrder(Order order);

    /**
     * 删除order
     * @param id orderId
     */
    void deleteOrderById(int id);

    /**
     * 更新
     * @param order order
     */
    void updateOrderById(Order order);

    /**
     * 通过id查询order
     * @param id id
     * @return 结果集
     */
    Order selectOrderByid(int id);

    /**
     * 通过userid查询order
     * @param userId userid
     * @return orderList
     */
    List<Order> selectOrderListByUserId(int userId);
}

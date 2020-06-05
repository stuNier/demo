package com.zx.demo.service.impl;

import com.zx.demo.bean.book.Book;
import com.zx.demo.bean.book.Order;
import com.zx.demo.mapper.OrderMapper;
import com.zx.demo.service.IBookService;
import com.zx.demo.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Title: OrderServiceImpl
 * Description: OrderServiceImpl
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 17:59
 */
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private IBookService bookService;

    /**
     * 创建order
     *
     * @param order order
     */
    @Override
    public void insertOrder(Order order) {
        Book book = bookService.selectBookById(order.getBookId());
        if(null!=book && book.getNumber()>=0 && book.getNumber()>=order.getNumber()){
            order.setUnitPrice(book.getPrice());
            Date date = new Date();
            order.setCreatedTime(date);
            order.setUpdateTime(date);
            orderMapper.insertOrder(order);
        }
    }

    /**
     * 删除order
     *
     * @param id orderId
     */
    @Override
    public void deleteOrderById(int id) {

    }

    /**
     * 更新
     *
     * @param order order
     */
    @Override
    public void updateOrderById(Order order) {

    }

    /**
     * 通过id查询order
     *
     * @param id id
     * @return 结果集
     */
    @Override
    public Order selectOrderByid(int id) {
        return null;
    }

    /**
     * 通过userid查询order
     *
     * @param userId userid
     * @return orderList
     */
    @Override
    public List<Order> selectOrderListByUserId(int userId) {
        return null;
    }
}

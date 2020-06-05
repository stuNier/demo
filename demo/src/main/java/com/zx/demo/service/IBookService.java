package com.zx.demo.service;

import com.zx.demo.bean.book.Book;

import java.util.List;

/**
 * Title: IBookService
 * Description: IBookService
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 14:09
 */
public interface IBookService {

    /**
     * 插入
     *
     * @param book book
     */
    void insertBook(Book book);

    /**
     * 批量插入
     *
     * @param bookList bookList
     */
    void insertBookList(List<Book> bookList);

    /**
     * 通过id更新
     *
     * @param book book
     */
    void updateBookById(Book book);

    /**
     * 更新数量
     *
     * @param id     id
     * @param number number
     */
    void updateBookNumberById(int id, int number);

    /**
     * 通过id查询
     *
     * @param id id
     * @return book
     */
    Book selectBookById(int id);
}

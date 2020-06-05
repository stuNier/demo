package com.zx.demo.service.impl;

import com.zx.demo.bean.book.Book;
import com.zx.demo.mapper.BookMapper;
import com.zx.demo.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: BookService
 * Description: BookService
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 14:11
 */
@Slf4j
@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = RuntimeException.class)
public class BookServiceImpl implements IBookService {

    /**
     * bookMapper
     */
    @Autowired
    private BookMapper bookMapper;

    /**
     * 批量插入数据量
     */
    private static final int LIST_SIZE = 1000;

    /**
     * 插入
     *
     * @param book book
     */
    @Override
    public void insertBook(Book book) {
        Book oldBook = bookMapper.selectBookById(book.getId());
        if (null == oldBook) {
            bookMapper.insertBook(book);
        }
        bookMapper.updateBookNumberById(oldBook.getId(), oldBook.getNumber() + 1);
    }

    /**
     * 批量插入
     *
     * @param bookList bookList
     */
    @Override
    public void insertBookList(List<Book> bookList) {
        int m = (bookList.size() + LIST_SIZE) / LIST_SIZE;
        for (int i = 0; i < m; i++) {
            List<Book> subBookList = new LinkedList<>();
            int n = (i + 1) * LIST_SIZE > bookList.size() ? bookList.size() : (i + 1) * LIST_SIZE;
            for (int j = i * LIST_SIZE; j < n; j++) {
                subBookList.add(bookList.get(j));
            }
            bookMapper.insertBookList(subBookList);
        }
    }

    /**
     * 通过id更新
     *
     * @param book book
     */
    @Override
    public void updateBookById(Book book) {
        bookMapper.updateBookById(book);
    }

    /**
     * 更新数量
     *
     * @param id     id
     * @param number number
     */
    @Override
    public void updateBookNumberById(int id, int number) {
        bookMapper.updateBookNumberById(id, number);
    }

    /**
     * 通过id查询
     *
     * @param id id
     * @return book
     */
    @Override
    public Book selectBookById(int id) {
        return bookMapper.selectBookById(id);
    }
}

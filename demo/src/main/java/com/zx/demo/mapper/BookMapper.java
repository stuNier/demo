package com.zx.demo.mapper;

import com.zx.demo.bean.book.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Title: BookMapper
 * Description: BookMapper
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 13:43
 */
@Mapper
public interface BookMapper {

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
    void updateBookNumberById(@Param("id") int id, @Param("number") int number);

    /**
     * 查询
     *
     * @param id 查询参数
     * @return book
     */
    Book selectBookById(int id);
}

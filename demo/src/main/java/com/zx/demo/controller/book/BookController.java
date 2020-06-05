package com.zx.demo.controller.book;

import com.zx.demo.bean.book.Book;
import com.zx.demo.enums.ResultStatusEnum;
import com.zx.demo.model.ExcelModel;
import com.zx.demo.model.GlobalResponseModel;
import com.zx.demo.service.IBookService;
import com.zx.demo.util.PoiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Title: BookController
 * Description: BookController
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 13:40
 */
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private PoiUtil poiUtil;

    @PostMapping("/insert")
    public GlobalResponseModel insertBooks(MultipartFile file) {
        String[] fields = {"name", "address", "price", "number"};
        ExcelModel<Book> excelModel = null;
        try {
            excelModel = poiUtil.importExcel(file.getInputStream(), Book.class, 0, fields);
        } catch (IOException e) {
            log.error("错误信息{}", e.getMessage());
        }
        if (null != excelModel && !excelModel.getDataList().isEmpty()) {
            bookService.insertBookList(excelModel.getDataList());
            return GlobalResponseModel.builder()
                    .code(ResultStatusEnum.SUCCESS.getCode())
                    .message(ResultStatusEnum.SUCCESS.getMessage()).build();
        }
        return GlobalResponseModel.builder()
                .code(ResultStatusEnum.FAILED.getCode())
                .message(ResultStatusEnum.FAILED.getMessage()).build();
    }
}

package com.zx.demo.service;

import com.zx.demo.exception.StudentException;
import com.zx.demo.model.GlobalResponseModel;
import org.springframework.web.multipart.MultipartFile;


/**
 * Title: IStudentService
 * Description: IStudentService
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 11:11
 */
public interface IStudentService {
    /**
     * 通过名称查询
     * @param id 查询id
     * @return 结果集
     * @throws StudentException StudentException
     * @author: zhengxin-3@thunisoft.com
     * date: 20-03-23 11:14
     * @version 1.0
     */
    GlobalResponseModel searchStudentById(Long id) throws StudentException;


    /**
     * 通过id删除
     * @param id id
     * @return 结果集
     * @throws StudentException StudentException
     * @author: zhengxin-3@thunisoft.com
     * date: 20-04-01 16:08
     * @version 1.0
     */
    GlobalResponseModel deleteStudentById(Long id) throws StudentException;

    /**
     * 查询所有student
     * @return 结果集
     */
    GlobalResponseModel queryAllStudent();

    /**
     * 删除所有
     * @return 操作结果
     */
    GlobalResponseModel deleteAllStudent();

    /**
     * 保存列表
     * @param file 文件
     * @return 操作结果
     */
    GlobalResponseModel saveStudentList(MultipartFile file);
}

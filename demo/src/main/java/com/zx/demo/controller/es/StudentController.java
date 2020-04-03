package com.zx.demo.controller.es;

import com.zx.demo.enums.ResultStatusEnum;
import com.zx.demo.exception.StudentException;
import com.zx.demo.model.GlobalResponseModel;
import com.zx.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



/**
 * Title: StudentController
 * Description: StudentController
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 11:18
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /**
     * 查询student
     * @param id 查询id
     * @return 结果集
     * @author: zhengxin-3@thunisoft.com
     * date: 20-03-23 11:21
     * @version 1.0
     */
    @GetMapping("/query/{id}")
    public GlobalResponseModel queryStudentById(@PathVariable("id") Long id){
        try {
            return studentService.searchStudentById(id);
        } catch (StudentException e) {
            return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                    .message(e.getMessage())
                    .build();
        }
    }

    /**
     * 通过id删除student
     * @param id 需要删除的id
     * @return 全局model
     * @author: zhengxin-3@thunisoft.com
     * date: 20-04-01 16:35
     * @version 1.0
     */
    @GetMapping("delete/{id}")
    public GlobalResponseModel deleteStudentById(@PathVariable("id") Long id){
        try {
            return studentService.deleteStudentById(id);
        } catch (StudentException e) {
            return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                    .message(e.getMessage())
                    .build();
        }
    }

    /**
     * 查询所有
     * @return 结果集
     */
    @GetMapping("/query/all")
    public GlobalResponseModel queryAllStudent(){
        return studentService.queryAllStudent();
    }

    /**
     * 删除所有
     * @return 操作结果
     */
    @GetMapping("/delete/all")
    public GlobalResponseModel deleteAllStudent(){
        return studentService.deleteAllStudent();
    }

    @PostMapping("/save/all")
    public GlobalResponseModel readExcel(MultipartFile file){
        if(file.isEmpty()){
            return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                    .message(ResultStatusEnum.FILE_IS_NULL.getMessage())
                    .data(ResponseEntity.ok()).build();
        }
        return studentService.saveStudentList(file);
    }

}

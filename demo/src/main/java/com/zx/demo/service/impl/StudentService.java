package com.zx.demo.service.impl;

import com.zx.demo.bean.es.Student;
import com.zx.demo.dao.es.StudentRepository;
import com.zx.demo.enums.ResultStatusEnum;
import com.zx.demo.exception.StudentException;
import com.zx.demo.model.ExcelModel;
import com.zx.demo.model.GlobalResponseModel;
import com.zx.demo.service.IStudentService;
import com.zx.demo.util.PoiUtil;
import com.zx.demo.util.SnowFlakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * Title: StudentService
 * Description: IStudentService
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 11:15
 */
@Slf4j
@Service
public class StudentService implements IStudentService {

    private String[] fields = {"name","age", "address"};

    @Autowired
    private SnowFlakeUtil snowFlakeUtil;

    @Autowired
    private PoiUtil poiUtil;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public GlobalResponseModel searchStudentById(Long id) throws StudentException {
        log.info(id.toString());
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                    .message(ResultStatusEnum.SUCCESS.getMessage())
                    .data(student.get()).build();
        }else {
            throw new StudentException(ResultStatusEnum.ID_NOT_EXIST.getMessage());
        }
    }

    @Override
    public GlobalResponseModel deleteStudentById(Long id) throws StudentException {
        log.info(id.toString());
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.deleteById(id);
            return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                    .message(ResultStatusEnum.SUCCESS.getMessage())
                    .build();
        }else{
            throw new StudentException(ResultStatusEnum.ID_NOT_EXIST.getMessage());
        }
    }

    @Override
    public GlobalResponseModel queryAllStudent() {
        Iterable<Student> result = studentRepository.findAll();
        return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                .message(ResultStatusEnum.SUCCESS.getMessage())
                .data(result).build();
    }

    @Override
    public GlobalResponseModel deleteAllStudent() {
        studentRepository.deleteAll();
        return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                .message(ResultStatusEnum.SUCCESS.getMessage())
                .build();
    }

    @Override
    public GlobalResponseModel saveStudentList(MultipartFile file) {
        try {
            ExcelModel<Student> excelModel = poiUtil.importExcel(file.getInputStream(), Student.class, 0, fields);
            log.info("save student...");
            for (Student student:excelModel.getDataList()){
                student.setId(snowFlakeUtil.nextId());
                studentRepository.save(student);
            }
            log.info("total:{}", excelModel.getDataList().size());
            return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                    .message(ResultStatusEnum.SUCCESS.getMessage())
                    .data(excelModel.getDataList().size()).build();
        } catch (IOException e) {
            return GlobalResponseModel.builder().code(ResultStatusEnum.FAILED.getCode())
                    .message(e.getMessage())
                    .build();
        }
    }
}

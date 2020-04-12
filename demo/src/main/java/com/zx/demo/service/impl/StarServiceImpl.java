package com.zx.demo.service.impl;

import com.zx.demo.bean.es.Star;
import com.zx.demo.dao.es.StarRepository;
import com.zx.demo.enums.ResultStatusEnum;
import com.zx.demo.exception.StarException;
import com.zx.demo.model.ExcelModel;
import com.zx.demo.model.GlobalResponseModel;
import com.zx.demo.service.IStarService;
import com.zx.demo.util.PoiUtil;
import com.zx.demo.util.SnowFlakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * Title: StarServiceImpl
 * Description: StarServiceImpl
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 11:15
 */
@Slf4j
@Service
public class StarServiceImpl implements IStarService {

    private String[] fields = {"name","age", "address"};

    @Autowired
    private SnowFlakeUtil snowFlakeUtil;

    @Autowired
    private PoiUtil poiUtil;

    @Autowired
    private StarRepository starRepository;

    @Override
    public GlobalResponseModel searchStarById(Long id) throws StarException {
        log.info(id.toString());
        Optional<Star> star = starRepository.findById(id);
        if(star.isPresent()){
            return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                    .message(ResultStatusEnum.SUCCESS.getMessage())
                    .data(star.get()).build();
        }else {
            throw new StarException(ResultStatusEnum.ID_NOT_EXIST.getMessage());
        }
    }

    @Override
    public GlobalResponseModel deleteStarById(Long id) throws StarException {
        log.info(id.toString());
        Optional<Star> star = starRepository.findById(id);
        if(star.isPresent()){
            starRepository.deleteById(id);
            return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                    .message(ResultStatusEnum.SUCCESS.getMessage())
                    .build();
        }else{
            throw new StarException(ResultStatusEnum.ID_NOT_EXIST.getMessage());
        }
    }

    @Override
    public GlobalResponseModel queryAllStar() {
        Iterable<Star> result = starRepository.findAll();
        return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                .message(ResultStatusEnum.SUCCESS.getMessage())
                .data(result).build();
    }

    @Override
    public GlobalResponseModel deleteAllStar() {
        starRepository.deleteAll();
        return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                .message(ResultStatusEnum.SUCCESS.getMessage())
                .build();
    }

    @Override
    public GlobalResponseModel saveStarList(MultipartFile file) {
        try {
            ExcelModel<Star> excelModel = poiUtil.importExcel(file.getInputStream(), Star.class, 0, fields);
            log.info("save star...");
            for (Star star:excelModel.getDataList()){
                star.setId(snowFlakeUtil.nextId());
                starRepository.save(star);
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

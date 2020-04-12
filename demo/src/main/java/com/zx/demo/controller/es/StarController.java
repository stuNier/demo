package com.zx.demo.controller.es;

import com.zx.demo.enums.ResultStatusEnum;
import com.zx.demo.exception.StarException;
import com.zx.demo.model.GlobalResponseModel;
import com.zx.demo.service.IStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



/**
 * Title: StarController
 * Description: StarController
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 11:18
 */
@RestController
@RequestMapping("/star")
public class StarController {

    @Autowired
    private IStarService starService;

    /**
     * 查询star
     * @param id 查询id
     * @return 结果集
     * @author: zhengxin-3@thunisoft.com
     * date: 20-03-23 11:21
     * @version 1.0
     */
    @GetMapping("/query/{id}")
    public GlobalResponseModel queryStarById(@PathVariable("id") Long id){
        try {
            return starService.searchStarById(id);
        } catch (StarException e) {
            return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                    .message(e.getMessage())
                    .build();
        }
    }

    /**
     * 通过id删除star
     * @param id 需要删除的id
     * @return 全局model
     * @author: zhengxin-3@thunisoft.com
     * date: 20-04-01 16:35
     * @version 1.0
     */
    @GetMapping("delete/{id}")
    public GlobalResponseModel deleteStarById(@PathVariable("id") Long id){
        try {
            return starService.deleteStarById(id);
        } catch (StarException e) {
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
    public GlobalResponseModel queryAllStar(){
        return starService.queryAllStar();
    }

    /**
     * 删除所有
     * @return 操作结果
     */
    @GetMapping("/delete/all")
    public GlobalResponseModel deleteAllStar(){
        return starService.deleteAllStar();
    }

    @PostMapping("/save/all")
    public GlobalResponseModel readExcel(MultipartFile file){
        if(file.isEmpty()){
            return GlobalResponseModel.builder().code(ResultStatusEnum.SUCCESS.getCode())
                    .message(ResultStatusEnum.FILE_IS_NULL.getMessage())
                    .data(ResponseEntity.ok()).build();
        }
        return starService.saveStarList(file);
    }

}

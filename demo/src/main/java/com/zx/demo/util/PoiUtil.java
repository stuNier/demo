package com.zx.demo.util;

import com.zx.demo.model.ExcelModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;

import java.io.InputStream;
import java.util.List;

/**
 * Title: PoiUtil
 * Description: PoiUtil
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 14:30
 */
@Component
@Slf4j
public class PoiUtil {

    /**
     * 导入excel
     * @param inputStream inputStream
     * @param objectClass model类型
     * @param sheetNum sheet页码
     * @param fields 字段映射
     * @return 结果集
     * @author: zhengxin-3@thunisoft.com
     * date: 20-03-23 14:57
     * @version 1.0
     */
    public<T> ExcelModel<T> importExcel(InputStream inputStream, Class<T> objectClass, int sheetNum, String[] fields){
        ExcelModel<T> excelModel = new ExcelModel<>();
        ExcelImportResult<T> resultExcel;
        try {
            ImportParams params = new ImportParams();
            params.setImportFields(fields);
            params.setNeedVerfiy(true);
            params.setStartSheetIndex(sheetNum);
            resultExcel = ExcelImportUtil.importExcelMore(
                    inputStream, objectClass, params);
            /** 获取excel数据*/
            List<T> list = resultExcel.getList();
            /** 设置结果*/
            excelModel.setDataList(list);
            /** 错误数据列表*/
            List<T> failList = resultExcel.getFailList();
            if (!failList.isEmpty()) {
                log.warn("错误数据列表\n{}", failList.toString());
            }
        } catch (Exception e) {
            log.error("错误信息{}",e);
            return null;
        }
        return excelModel;
    }
}

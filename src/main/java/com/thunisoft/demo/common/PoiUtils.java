package com.thunisoft.demo.common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
public class PoiUtils{

    /**
     * 戒毒规则sql
     * @param path 文件路径
     * @param index 列位置
     * @return 列数据
     * @throws IOException 读取文件异常
     */
    public List<String> readExcelForJdSql(String path, String sheetName, int index) throws IOException {
        File excelFile = new File(path);
        FileInputStream excelStream = new FileInputStream(excelFile);
        Workbook wb = new XSSFWorkbook(excelStream);
        Sheet sheet = wb.getSheet(sheetName);

        int i = 0;
        Row row = sheet.getRow(i);
        List<String> result = new LinkedList<>();
        while (row!=null && row.getCell(index)!=null){
            row.getCell(index).setCellType(Cell.CELL_TYPE_STRING);
            result.add(row.getCell(index).getStringCellValue());
            i++;
            row = sheet.getRow(i);
        }
        return result;
    }
}
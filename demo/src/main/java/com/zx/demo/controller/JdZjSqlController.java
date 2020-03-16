package com.zx.demo.controller;

import com.zx.demo.common.FileUtils;
import com.zx.demo.common.PoiUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;

/**
 * Title: TestController
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/9/16 11:03
 */
@RestController
@Api(tags = "读取excel生成sql")
public class JdZjSqlController {

    @Autowired
    private PoiUtils poiUtils;

    @Autowired
    private FileUtils fileUtils;

    @RequestMapping("/jd")
    public Object test() throws IOException {
        String path = "C:\\Users\\lenovo\\Desktop\\法律援助\\法律援助 - 融合.xlsx";
        List<String> codeTypeName =  poiUtils.readExcelForJdSql(path, "T_ATY_CODE",0);
        List<String> codeTypeName1 =  poiUtils.readExcelForJdSql(path, "T_ATY_CODETYPE",1);
        List<String> codeType =  poiUtils.readExcelForJdSql(path, "T_ATY_CODETYPE",0);
        List<String> code =  poiUtils.readExcelForJdSql(path, "T_ATY_CODE",1);
        List<String> codeName =  poiUtils.readExcelForJdSql(path, "T_ATY_CODE",2);

        String str;
        for(int i=0, j=0; i<codeTypeName1.size(); ){
            str = codeTypeName1.get(i);
            System.out.println("----"+"\t"+codeTypeName1.get(i));
            int order = 1;
            while (j<code.size() && codeTypeName1.get(i).equals( codeTypeName.get(j))){
                System.out.println(codeType.get(i)+"\t"+code.get(j)+"\t"+codeName.get(j)+"\t"+"2"+"\t"+"\t"+"1"+"\t"+order);
                order++;
                j++;
            }
            i++;
        }

        return "success";
    }

    @RequestMapping("/flyz")
    public void flyzSMD() throws IOException {
        String path = "C:\\Users\\lenovo\\Desktop\\法律援助文件\\法律援助 - 融合.xlsx";
        List<String> 表中文名 =  poiUtils.readExcelForJdSql(path, "单值校验",0);
        List<String> 表名 =  poiUtils.readExcelForJdSql(path, "单值校验",1);
        List<String> 字段名 =  poiUtils.readExcelForJdSql(path, "单值校验",2);
        List<String> 字段中文名 =  poiUtils.readExcelForJdSql(path, "单值校验",3);
        List<String> 单值代码 =  poiUtils.readExcelForJdSql(path, "单值校验",4);
        for(int i = 0; i<单值代码.size(); i++){
            if(单值代码.get(i).compareTo("020011") > 0 && !单值代码.get(i).equals("单值代码") && !单值代码.get(i).startsWith("GB")){
                System.out.println((i+1)+"\t"+表中文名.get(i)+"\t"+表名.get(i)+"\t"+字段名.get(i)+"\t"+字段中文名.get(i)+"\t"+(Integer.parseInt(单值代码.get(i))-2));
            }
        }
    }

    @RequestMapping("/dzjy")
    public void dzjy() throws IOException {
        String path = "C:\\Users\\lenovo\\Desktop\\法律援助文件\\法律援助 - 融合.xlsx";
        List<String> 表中文名 =  poiUtils.readExcelForJdSql(path, "单值校验",0);
        List<String> 表名 =  poiUtils.readExcelForJdSql(path, "单值校验",1);
        List<String> 字段名 =  poiUtils.readExcelForJdSql(path, "单值校验",2);
        List<String> 字段中文名 =  poiUtils.readExcelForJdSql(path, "单值校验",3);
        List<String> 单值代码 =  poiUtils.readExcelForJdSql(path, "单值校验",4);
        List<String> 存储空间 =  poiUtils.readExcelForJdSql(path, "单值校验",5);
        for(int i = 1; i<单值代码.size(); i++){
            String str = "";
            if(字段名.get(i).startsWith("N_"))
                str = "::VARCHAR";
            /**
             * 规则名称
             */
//            System.out.println(表中文名.get(i) + "中“" + 字段中文名.get(i) + "”须符合规范");
            /**
             * 规则主体
             */
            System.out.println("SELECT a." + 字段名.get(i) + str  + ", b.c_name" + " FROM " + 存储空间.get(i) + "." + 表名.get(i) +
                    " AS a LEFT JOIN PUBLIC.T_ATY_CODE AS b ON a."+ 字段名.get(i) + str + " = b.c_code AND b.c_pid = '" + 单值代码.get(i) +"'" );
            /**
             * 规则SQL
             */
//            System.out.println("a." + 字段名.get(i) + " IS NOT NULL AND b.c_name IS NULL");
            /**
             * 验证SQL
             */
//            System.out.println("SELECT a." + 字段名.get(i) + str  + ", b.c_name" + " FROM " + 存储空间.get(i) + "." + 表名.get(i) +
//                    " AS a LEFT JOIN PUBLIC.T_ATY_CODE AS b ON a."+ 字段名.get(i) + str + " = b.c_code AND b.c_pid = '" + 单值代码.get(i) +"' WHERE " + "a." + 字段名.get(i) + " IS NOT NULL AND b.c_name IS NULL union all" );
        }
    }


    /**
     * 跑数SQL导出
     * @throws IOException
     */
    @RequestMapping("/exportsql")
    public void exportSQL() throws IOException {
        String path = "C:\\Users\\lenovo\\Desktop\\法律援助文件\\法律援助SMD.xlsx";
        List<String> 表名 =  poiUtils.readExcelForJdSql(path, "COL",0);
        List<String> 字段名 =  poiUtils.readExcelForJdSql(path, "COL",1);
        StringBuilder importSb = new StringBuilder();
        importSb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                " <!--source_table：参数配置的是源数据导出后生成的.dat文件名称-->\n" +
                "  <!--target_table：参数配置的是目标库的表名称-->\n" +
                "  <!--truncate：参数配置的是是否要清空目标数据库的表的数据，1是，0否-->\n" +
                " <!--compute：参数配置的是是否刷新表的统计信息，1是，0否-->\n" +
                "<connect>\n");
        for(int i = 1, j; i<表名.size()-1; ){
            if(表名.get(i).equals("----")){
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT\n");
            for(j = i; j<表名.size()-1 && !表名.get(j).equals("----"); j++){
                sb.append("\t"+字段名.get(j)+",\n");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            sb.append("\nFROM\n");
            sb.append("\tDB_FLYZ."+表名.get(i));
            System.out.println(sb.toString());
            String outPath = "C:\\Users\\lenovo\\Desktop\\法律援助文件\\sfxz_flyz\\import\\sql\\"+表名.get(i).toLowerCase()+".sql";
            fileUtils.write(outPath,sb.toString());
            importSb.append("<table>\n" +
                    "        <source_table>"+ 表名.get(i).toLowerCase() +".sql</source_table>\n" +
                    "        <target_table>db_flyz."+ 表名.get(i).toLowerCase() +"</target_table>\n" +
                    "        <truncate>1</truncate>\n" +
                    "        <compute>0</compute>\n" +
                    "</table>\n");
            i = j;
        }
        importSb.append("</connect>");
        fileUtils.write("C:\\Users\\lenovo\\Desktop\\法律援助文件\\sfxz_flyz\\import\\import.xml", importSb.toString());
    }


    @RequestMapping("/scsql")
    public void cfjlsqlyz() throws IOException {
        String path = "C:\\Users\\lenovo\\Desktop\\SMD程序\\社区矫正库SMD.xlsx";
        List<String> 表 =  poiUtils.readExcelForJdSql(path, "COL",0);
        List<String> 字段 =  poiUtils.readExcelForJdSql(path, "COL",1);
        for(int i=1, j; i<表.size()-1;){
            if(表.get(i).equals("----")){
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ");
            StringBuilder 字段集 = new StringBuilder();
            for(j = i; j<表.size()-1 && !表.get(j).equals("----"); j++){
                字段集.append(字段.get(j)+",");
            }
            字段集.deleteCharAt(字段集.length()-1);
            //sb.append(字段集.toString());
            sb.append("'"+表.get(i)+"' as sjb,");
            sb.append("count(*) as wtsl");
            sb.append(" FROM (SELECT row_number() over(partition by ");
            sb.append(字段集.toString());
            sb.append(") as no,");
            sb.append(字段集);
            sb.append(" FROM\n");
            sb.append("db_sqjz."+表.get(i) + " ) a where no > 1 union all");
            System.out.println(sb.toString());
            i = j;
        }
    }

}

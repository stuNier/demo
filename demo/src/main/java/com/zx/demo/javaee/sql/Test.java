package com.zx.demo.javaee.sql;

import com.zx.demo.util.FileUtils;
import com.zx.demo.util.PingYinUtil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title: Test
 * Description: sql
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/16 14:12
 */
public class Test {

    public static final String[] ZDLX = {
            "char","c_",
            "text","c_",
            "timestamp","dt_",
            "date","d_",
            "int","n_",
            "numeric","n_",
            "bool","c_"
    };

    @org.junit.Test
    public void createSqlFile(){
        String[] fileNames = {"sft_sqjz_shzyz","sft_sqjz_sfbry","sft_sqjz_shgzz","sft_sqjz_sfbjg"};
        for(String name : fileNames){
            String content = "select * from database_1395_kamsum."+name;
            FileUtils.write("C:\\Users\\lenovo\\Desktop\\sql\\"+name+".sql", content);
        }
    }

    /**
     * 表中文名重复 TODO
     */
    @org.junit.Test
    public void biaozhushi(){
        String[] names = {"附件信息表(行政复议)","系统机构信息表(行政复议)","案件信息表(行政复议)","申请人信息表(行政复议)","被申请人信息表(行政复议)","律师信息表","律所信息","司法厅_贵州法网_律师信息表","司法厅_贵州法网_律师专业领域信息表","司法厅_贵州法网_律师奖励信息表","司法厅_贵州法网_律师服务项目信息表","司法厅_贵州法网_律师委托信息表","司法厅_贵州法网_人民调解机构表","司法厅_贵州法网_基层法律服务委托表","司法厅_贵州法网_律所惩罚信息表","司法厅_贵州法网_律所奖励信息表","司法厅_贵州法网_律所服务项目信息表","司法厅_贵州法网_司法确认信息表","司法厅_贵州法网_律所信息","司法厅_贵州法网_层法律工作者信息表","司法厅_贵州法网_基层法律服务服务项目表","司法厅_贵州法网_基层法律服务所信息表","司法厅_贵州法网_基层法律服务年度考核表","司法厅_贵州法网_满意度评价二级指标信息表","司法厅_贵州法网_满意度评价信息表","司法厅_贵州法网_咨询信息表","司法厅_贵州法网_在线咨询登录记录表","司法厅_贵州法网_鉴定人员表","司法厅_贵州法网_鉴定机构表","司法厅_贵州法网_鉴定业务表","司法厅_贵州法网_法律援助工作者信息表","司法厅_贵州法网_法律援助机构信息表","司法厅_贵州法网_法律援助预申请信息表","司法厅_贵州法网_人民调解网上申请信息表","司法厅_贵州法网_村居顾问登记表","司法厅_贵州法网_咨询抢答回复信息表","司法厅_贵州法网_咨询问题信息表","司法厅_贵州法网_工单日志信息表","司法厅_贵州法网_工单信息表","司法厅_贵州法网_法宣视频信息表","司法厅_贵州法网_办理单位表","司法厅_贵州法网_法宣活动信息表","司法厅_贵州法网_公证人员信息表","司法厅_贵州法网_公证机构信息表","司法厅_贵州法网_公证业务信息表","司法厅_贵州法网_新闻资讯信息表","司法厅_贵州法网_律师惩罚信息表","司法厅_贵州法网_律所专业领域信息表","司法厅_贵州法网_人民调解员信息表","司法厅_贵州法网_在线咨询信息表"};
        for(int i=0; i<names.length ; i++){
            names[i] = replace(names[i]);
        }
        for (String s:names){
            System.out.println(PingYinUtil.getFirstSpell(s));
        }
    }

    /**
     * 合并sql文件
     */
    @org.junit.Test
    public void hebingsql(){
        String folderPath = "C:\\Users\\lenovo\\Desktop\\b北京华宇\\06_贵州大数据\\04数据\\现场表结构\\新增社区矫正_修改为中文简拼";
        List<String> fileNames = FileUtils.fileFolder(folderPath,".*");
        Iterator<String> iterator = fileNames.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()){
            stringBuilder.append(FileUtils.readFile(iterator.next()));
            stringBuilder.append("\n");
        }
        FileUtils.write("C:\\Users\\lenovo\\Desktop\\中文_社区矫正.sql", stringBuilder.toString());
    }


    /**
     * 修改中软云上的表注释为简拼
     */
    @org.junit.Test
    public void test(){
        String folderPath = "C:\\Users\\lenovo\\Desktop\\b北京华宇\\06_贵州大数据\\04数据\\现场表结构\\新增社区矫正_修改为中文简拼";
        List<String> fileNames = FileUtils.fileFolder(folderPath,".*");
        Iterator<String> iterator = fileNames.iterator();
        while (iterator.hasNext()){
            String filename = iterator.next();
            String content = FileUtils.readFile(filename);
            String targ = getRow(content);
            FileUtils.coverWrite(filename, targ);

        }
    }


    public String getRow(String content){
        List<Row> rowList = new LinkedList<>();
        String patternStr = "COMMENT ON COLUMN ?((.*?) IS (.*?))(;+)";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(content);
        HashMap<String, String> repalce = new HashMap<>(16);
        while (matcher.find()) {
            repalce.put(matcher.group(2).split("\\.")[2].replaceAll("\"",""),
                    replace(matcher.group(3).replace("\'","")));

        }
        Iterator<Map.Entry<String,String>> iterator = repalce.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            Row row = new Row();
            row.setOldStr(entry.getKey());
            row.setComment(entry.getValue());
            StringBuilder targStr = new StringBuilder();
            for (int i=0; i<ZDLX.length; i+=2){
                int index = content.indexOf(("\""+entry.getKey())+"\"");
                if(content.substring(index,
                        index+entry.getKey()
                                .length()+12)
                        .indexOf(ZDLX[i])>=0){
                    targStr.append(ZDLX[i+1]);
                    break;
                }
            }
            if(entry.getValue()==null || "".equals(entry.getValue())){
                targStr.append(PingYinUtil.getFirstSpell(entry.getKey()));
            }else {
                targStr.append(PingYinUtil.getFirstSpell(entry.getValue()));
            }
            row.setTarStr(targStr.toString());
            rowList.add(row);
        }
        for(int i=0; i<rowList.size()-1; i++){
            for(int j=i+1; j<rowList.size(); j++){
                if(rowList.get(i).getTarStr().equals(rowList.get(j).getTarStr())||
                        rowList.get(i).getTarStr() == rowList.get(j).getTarStr()){
                    rowList.get(j).setTarStr(rowList.get(j).getTarStr()+"1");
                }
            }
        }
        for (Row row:rowList){
            content = content.replaceAll("\""+row.getOldStr()+"\"", "\""+row.getTarStr()+"\"");
        }
        return content;
    }

    /**
     * 替换括号字符
     * @param src 源文本
     * @return 目标文本
     */
    public String replace(String src){
        StringBuilder stringBuilder = new StringBuilder(src);
        String patternStr = "(\\([^\\)]*\\))";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(stringBuilder.toString());
        while (matcher.find()) {
            int start = stringBuilder.indexOf(matcher.group(1));
            int length = matcher.group(1).length();
            stringBuilder.replace(start,
                    start+length,"");
        }
        String tszfPattern = "[0-9]|：|，|（|；";
        pattern = Pattern.compile(tszfPattern);
        matcher = pattern.matcher(stringBuilder.toString());
        while (matcher.find()) {
            int start = stringBuilder.indexOf(matcher.group(0));
            stringBuilder.delete(start, stringBuilder.length());
            break;
        }
        return stringBuilder.toString();
    }
}

package com.zx.demo.util.reptile;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title: Reptile
 * Description: 爬虫
 * @author 2957145040@qq.com
 * @version 1.0
 * date 2020/4/4 12:05
 */
@Slf4j
@Data
public class Reptile {

    private String html;

    private List<String> resultList;

    /**
     * 构造
     */
    public Reptile() {
        resultList = new LinkedList<>();
    }

    /**
     * 请求网页
     * @param url url
     */
    private void sendGet(String url) {
        // 定义一个字符串用来存储网页内容
        StringBuilder result = new StringBuilder();
        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        try {
            // 将string转成url对象
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
            // 开始实际的连接
            connection.connect();
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // 用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null) {
                // 遍历抓取到的每一行并将其存储到result里面
                result.append(line);
            }
        } catch (Exception e) {
            log.error("错误信息：{}" + e.getMessage());
        }
        // 使用finally来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                log.error("错误信息2：{}" + e2.getMessage());
            }
        }
        setHtml(result.toString());
    }

    /**
     * 匹配结果
     * @param url url
     * @param patternStr 正则表达式
     */
    public void regexString(String url, String patternStr) {
        this.sendGet(url);
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
    }

    /**
     * 转换编码
     */
    public void toUtf(){
        List<String> list = new LinkedList<>();
        for(String str: resultList){
            list.add(StringEscapeUtils.unescapeJava(str).replace(" ", "%20"));
        }
        this.resultList = list;
    }
}

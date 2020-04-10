package com.zx.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Title: FileUtils
 * Description: FileUtils
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/10/16 11:14
 */
@Component
@Slf4j
public final class FileUtils {

    private FileUtils(){

    }

    /**
     * 读取文件
     * @param path path
     * @return 结果
     * @throws IOException IOException
     */
    public static String readFile(String path) {
        File filename = new File(path);
        InputStream in = null;
        InputStreamReader reader = null;
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            in = new FileInputStream(filename);
            reader = new InputStreamReader(in);
            br = new BufferedReader(reader);
            String line = br.readLine();
            while (null != line) {
                result.append(line);
                result.append("\n");
                line = br.readLine();
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            try{
                if(null!=in){
                    in.close();
                }
            }catch (Exception e){
                log.error("错误信息{}",e);
            }
            try{
                if(null!=reader){
                    reader.close();
                }
            }catch (Exception e){
                log.error("错误信息{}",e);
            }
            try{
                if(null!=br){
                    br.close();
                }
            }catch (Exception e){
                log.error("错误信息{}",e);
            }
        }
        return result.toString();
    }

    /**
     * 写文件
     * @param path 文件路径
     * @param data 数据
     * @throws IOException 文件读写异常
     */
    public static void write(String path, String data) {
        File file = createFile(path);
        if(file == null){
            log.info("文件路径为空");
            return;
        }
        Writer out = null;
        try{
            out = new FileWriter(file);
            out.write(data);
        }catch (IOException e){
            log.info(e.getMessage());
        }finally {
            if(null != out){
                try{
                    out.close();
                }catch (IOException e){
                    log.info(e.getMessage());
                }
            }
        }
    }


    /**
     * 创建文件
     * @param fileName 文件名
     * @return 是否成功
     */
    public static File createFile(String fileName){
        File file =new File(fileName);
        //判断文件是否存在 不存在就创建文件
        boolean result = false;
        if (!file.exists()) {
            try {
                //创建
                result = file.createNewFile();
            } catch (IOException e) {
                log.error(e.getMessage());
                return null;
            }
        }
        if(result){
            return file;
        }
        return null;
    }

}

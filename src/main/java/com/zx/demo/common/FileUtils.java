package com.zx.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Title: FileUtils
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/10/16 11:14
 */
@Component
public class FileUtils {

    private Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 写文件
     * @param path 文件路径
     * @param data 数据
     * @return 是否成功
     * @throws IOException 文件读写异常
     */
    public void write(String path, String data) throws IOException {
        File file = createFile(path);
        if(file == null){
            logger.info("文件路径为空");
            return;
        }
        Writer out = null;
        try{
            out = new FileWriter(file);
            out.write(data);
        }catch (IOException e){
            logger.info(e.getMessage());
        }finally {
            if(null != out){
                try{
                    out.close();
                }catch (IOException e){
                    logger.info(e.getMessage());
                }
            }
        }
    }


    /**
     * 创建文件
     * @param fileName 文件名
     * @return 是否成功
     */
    public File createFile(String fileName){
        File file =new File(fileName);
        //判断文件是否存在 不存在就创建文件
        if (!file.exists()) {
            try {
                //创建
                file.createNewFile();
            } catch (IOException e) {
                logger.info(e.getMessage());
                return null;
            }
        }
        return file;
    }

}

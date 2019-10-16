package com.thunisoft.demo.common;

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

    /**
     * 写文件
     * @param path
     * @param data
     * @return
     * @throws IOException
     */
    public boolean write(String path, String data) throws IOException {
        File file = createFile(path);
        if(file == null) return false;
        Writer out =new FileWriter(file);
        out.write(data);
        out.close();
        return true;
    }


    /**
     * 创建文件
     * @param fileName
     * @return
     */
    public File createFile(String fileName){
        File file =new File(fileName);
        //判断文件是否存在 不存在就创建文件
        if (!file.exists()) {
            try {
                //创建
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }

}

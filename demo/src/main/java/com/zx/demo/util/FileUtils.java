package com.zx.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

    private static final String SLASH = "\\";

    private static final String ALL_FILE_SUFFIX = ".*";

    /**
     * 生成压缩文件
     * @param srcPath 原路径
     * @param desPath 目标路径
     */
    public static void createdZipFile(String srcPath, String desPath){
        if(desPath.endsWith(SLASH)){
            desPath = desPath.substring(0,desPath.length() - SLASH.length());
        }
        if(!srcPath.endsWith(SLASH)){
            srcPath = srcPath+SLASH;
        }
        List<String> fileNames = fileFolder(srcPath, ".exe");
        FileOutputStream outputStream = null;
        ZipOutputStream zipOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        FileInputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        int zipRes;

        try {
            outputStream = new FileOutputStream(desPath+SLASH+desPath.substring(desPath.lastIndexOf(SLASH)+1)+".zip");
            zipOutputStream = new ZipOutputStream(outputStream);
            bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
            Iterator<String> iterable = fileNames.iterator();
            while (iterable.hasNext()) {
                String fileName = iterable.next();
                inputStream = new FileInputStream(fileName);
                bufferedInputStream = new BufferedInputStream(inputStream);
                zipOutputStream.putNextEntry(new ZipEntry(fileName.substring(fileName.lastIndexOf(SLASH)+1)));
                while ((zipRes = bufferedInputStream.read()) != -1) {
                    bufferedOutputStream.write(zipRes);
                }
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }finally {
            if(null!=bufferedOutputStream){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
            if(null!=bufferedInputStream){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
            if(null!=inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
            if(null!=zipOutputStream){
                try {
                    zipOutputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
            if(null!=outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }


    /**
     * 复制文件
     * @param src 来源
     * @param des 目标
     */
    public static void fileCopy(String src, String des){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(des);
            //获取文件长度，并创建缓存
            int fileLength = inputStream.available();
            //读取文件，将文件内容放入缓存中
            byte[] buffer = new byte[fileLength];
            inputStream.read(buffer);
            //将缓存的内容写入目标文件
            outputStream.write(buffer);
        } catch (IOException e){
            log.error(e.getMessage());
        }
        finally {
            if(null!=inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
            if(null!=outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    /**
     * 读取文件夹
     * @param folderPath 文件夹路径
     */
    public static List<String> fileFolder(String folderPath, String suffix){
        if(ALL_FILE_SUFFIX.equals(suffix)){
            suffix = "";
        }
        File folder = new File(folderPath);
        File[] fileList = folder.listFiles();
        List<String> result = new LinkedList<>();
        if(null == fileList || fileList.length == 0){
            return result;
        }
        for(File file : fileList){
            if(file.isDirectory()){
                fileFolder(file.getAbsolutePath(), suffix);
            }
            if(null!=suffix && !ALL_FILE_SUFFIX.equals(suffix)){
                if(file.getName().endsWith(suffix)){
                    result.add(file.getAbsolutePath());
                }
            }else{
                result.add(file.getAbsolutePath());
            }

        }
        return result;
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
        } catch (IOException e){
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
     * 写文件
     * @param path 文件路径
     * @param data 数据
     * @throws IOException 文件读写异常
     */
    public static void coverWrite(String path, String data) {
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        write(path, data);
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

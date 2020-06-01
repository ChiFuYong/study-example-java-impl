package com.chifuyong.classloader;

import java.io.*;

/**
 * 自定义 ClassLoader 测试
 *
 * @date： 2020/6/1
 * @author: chify
 */
public class MyClassLoader extends ClassLoader{

    /**
     * class 文件所在   目录
     */
    private String classPath;

    public MyClassLoader( String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        try {
            byte[] bytes = loadClassSource(name);
            Class clazz = null;
            if (null != bytes){
                clazz = defineClass(name,bytes,0,bytes.length);
            }
            return clazz;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] loadClassSource(String name) throws IOException {
        //拼接 class 文件所在目录
        String [] str1 = name.split("\\.");
        name = str1[str1.length-1];
        String fileName = classPath + name + ".class";

        InputStream is = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = null;
        try {
            //读取 class 文件
            is = new FileInputStream(new File(fileName));
            byte[] bytes = new byte[1024];
            int size = 0;
            while ((size = is.read(bytes)) != -1) {
                bos.write(bytes,0,size);
            }
            data = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (bos != null){
                bos.close();
            }
            if (is != null){
                is.close();
            }
        }
        return data;
    }
}

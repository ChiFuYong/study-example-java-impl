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

    /**
     * 重写此方法破不了双亲委派机制，会先去加载 native 方法 defineClass1,然后 jvm 又会去加载 java.lang.Object 类报错。
     */
    /*@Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return findClass(name);
    }*/

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
        name = name.replaceAll("\\.","/") + ".class";
        String fileName = classPath + name;

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

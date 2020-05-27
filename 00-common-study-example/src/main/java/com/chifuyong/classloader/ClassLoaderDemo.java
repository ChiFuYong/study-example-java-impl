package com.chifuyong.classloader;

import sun.misc.VM;

import java.util.Map;
import java.util.Properties;

/**
 * ClassLoader学习
 *
 * @date： 2020/4/21
 * @author: chify
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        vmTest(args);
        classloaderTest();
    }

    private static void classloaderTest() {
        //Bootstrap 启动类加载器（详见sun.misc.Launcher）
        System.out.println("properties.getProperty(\"sun.boot.class.path\") = " + System.getProperty("sun.boot.class.path"));
        System.out.println("------------------");

        //EXtension 扩展类加载器
        System.out.println("properties.getProperty(\"java.ext.dirs\") = " + System.getProperty("java.ext.dirs"));
        System.out.println("------------------");

        //System 系统类加载器
        System.out.println("properties.getProperty(\"java.class.path\") = " + System.getProperty("java.class.path"));
        System.out.println("------------------");
    }

    private static void vmTest(String[] args) {
        //通过 Program argumnet 参数可以进 args 数组里
        for (String arg : args) {
            System.out.println(arg);
        }

        //拿到虚拟机参数（通过 VM options 可以配置虚拟机参数，例如：-Dtest="sdsd"）
        Properties properties = System.getProperties();
        //两种方式获取虚拟机参数
        System.out.println(properties.get("test"));
        System.out.println(VM.getSavedProperty("test"));

        // getenv() 和 getProperty() 用于返回系统相关的变量与属性，getenv方法返回的变量大多于系统相关，getProperty方法返回的变量大多与java程序有关。
        Map<String, String> map = System.getenv();
        for(Map.Entry<String, String> entry:map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

}

package com.chifuyong.a_classloader;

import org.junit.Test;
import sun.misc.VM;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

/**
 * ClassLoader类加载器测试
 *
 * @date： 2020/4/21
 * @author: chify
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        vmTest(args);
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
        String mysql_home = map.get("MYSQL_HOME");
        String maven_home = map.get("MAVEN_HOME");
        String java_home = map.get("JAVA_HOME");
        //系统中添加一个用于测试的环境变量（TEST）
        String test = map.get("TEST");
        for(Map.Entry<String, String> entry:map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    @Test
    public void classloaderTest() {
        //Bootstrap 启动类加载器（详见sun.misc.Launcher）
        String bootDirs = System.getProperty("sun.boot.class.path");
        System.out.println("properties.getProperty(\"sun.boot.class.path\") = " );
        for (String path : bootDirs.split(";")) {
            System.out.println(path);
        }
        System.out.println("------------------");

        //EXtension 扩展类加载器
        String extDirs = System.getProperty("java.ext.dirs");
        System.out.println("properties.getProperty(\"java.ext.dirs\") = ");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        System.out.println("------------------");

        //System 系统类加载器
        String appDirs = System.getProperty("java.class.path");
        System.out.println("properties.getProperty(\"java.class.path\") = " );
        for (String path : appDirs.split(";")) {
            System.out.println(path);
        }
        System.out.println("------------------");
    }

    @Test
    public void testBootstrapClassLoader() throws ClassNotFoundException {
        //加载 Bootstrap 类加载器加载的类
        Class clazz = ClassLoader.getSystemClassLoader().loadClass("java.lang.String");
        // clazz.ClassLoader = null
        System.out.println("clazz.ClassLoader = " + clazz.getClassLoader());
    }

    @Test
    public void testAppClassLoader() throws ClassNotFoundException {
        //加载 classpath 下的类
        Class clazz = ClassLoader.getSystemClassLoader().loadClass("com.chifuyong.classloader.HelloWorld");
        // clazz.ClassLoader = sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("clazz.ClassLoader = " + clazz.getClassLoader());
    }

    @Test
    public void testExtClassLoader() throws ClassNotFoundException {
        //加载 ExtClassLoader 类加载器加载的类
        Class clazz = ClassLoader.getSystemClassLoader().loadClass("com.sun.java.accessibility.AccessBridge");
        // clazz.ClassLoader = sun.misc.Launcher$ExtClassLoader@3f0ee7cb
        System.out.println("clazz.ClassLoader = " + clazz.getClassLoader());
    }

    @Test
    public void resouceTest() {
        String str1 = MyClassLoader.class.getResource("").toString();
        // str1 = file:/D:/idea-project-root/ChiFuYong/study-example-java-impl/00-common-study-example/target/classes/com/chifuyong/classloader/
        System.out.println("str1 = " + str1);

        // str2 = file:/D:/idea-project-root/ChiFuYong/study-example-java-impl/00-common-study-example/target/classes/
        String str2 = MyClassLoader.class.getResource("/").toString();
        System.out.println("str2 = " + str2);
    }

    /**
     * 自定义 classloader
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Test
    public void testClassLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取 class 文件路径
        String str1 = MyClassLoader.class.getResource("/").toString();
        str1 = str1.replace("file:/","");
        str1 = str1.replace("/10-jvm-study-example/target/classes/","");
        str1 = str1 + "/classloader/";
        // str1 = /D:/idea-project-root/ChiFuYong/study-example-java-impl/classloader/hello/
        System.out.println("class 文件所在路径 = " + str1);

        MyClassLoader myClassLoader = new MyClassLoader(str1);
        MyClassLoader myClassLoader2 = new MyClassLoader(str1);
        // HelloWorld 类详见 study-example-java-impl\classloader\hello
        // hello 是 HelloWorld 所在的包
        Class clazz = myClassLoader.loadClass("hello.HelloWorld");
        Class clazz2 = myClassLoader.loadClass("hello.HelloWorld");
        System.out.println(clazz == clazz2);
        System.out.println("clazz 是否等于 clazz2 ？ " + clazz.equals(clazz2));
        //clazz.ClassLoader = com.chifuyong.classloader.MyClassLoader@7d907bac
        System.out.println("clazz.ClassLoader = " + clazz.getClassLoader());
        System.out.println("clazz2.ClassLoader = " + clazz2.getClassLoader());
        //通过反射执行方法
        Method method = clazz.getDeclaredMethod("sayHello");
        Object object = clazz.newInstance();
        method.invoke(object);
    }
}

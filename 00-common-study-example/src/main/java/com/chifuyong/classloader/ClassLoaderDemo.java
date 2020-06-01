package com.chifuyong.classloader;

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
        for(Map.Entry<String, String> entry:map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
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

    @Test
    public void classloaderTest() {
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


    @Test
    public void testClassLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取 class 文件路径
        String str1 = MyClassLoader.class.getResource("/").toString();
        str1 = str1.replace("file:/","");
        str1 = str1.replace("/00-common-study-example/target/classes/","");
        str1 = str1 + "/classloader/hello/";
        // str1 = /D:/idea-project-root/ChiFuYong/study-example-java-impl/classloader/hello/
        System.out.println("class 文件所在路径 = " + str1);

        MyClassLoader myClassLoader = new MyClassLoader(str1);
        // HelloWorld 类详见 study-example-java-impl\classloader\hello
        // hello 是 HelloWorld 所在的包
        Class clazz = myClassLoader.loadClass("hello.HelloWorld");
        //clzz.ClassLoader = sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("clazz.ClassLoader = " + clazz.getClassLoader());
        //通过反射执行方法
        Method method = clazz.getDeclaredMethod("sayHello");
        Object object = clazz.newInstance();
        method.invoke(object);

        //加载 classpath 下的类
        Class clazz2 = myClassLoader.loadClass("com.chifuyong.classloader.HelloWorld");
        // clazz2.ClassLoader = sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("clazz2.ClassLoader = " + clazz2.getClassLoader());
    }

}

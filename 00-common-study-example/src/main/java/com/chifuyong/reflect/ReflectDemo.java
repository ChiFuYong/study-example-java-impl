package com.chifuyong.reflect;

import com.chifuyong.reflect.annotation.FieldAnnotation;
import com.chifuyong.reflect.annotation.MethodAnnotation;
import org.junit.Test;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射测试类
 *
 * @date： 2020/12/15
 * @author: chify
 */
public class ReflectDemo {

    @Test
    public void test1() throws Exception{
        Hello hello = new Hello();
        //三种反射获取方式
        Class<? extends Hello> clzz1 = hello.getClass();
        Class<Hello> clazz2 = Hello.class;
        Class clazz3 = Class.forName("com.chifuyong.reflect.Hello");


        String name = clazz3.getName();
        String s = hello.toString();
        Package packageInfo = clazz3.getPackage();
        String genericString = clazz3.toGenericString();

        if(name instanceof String){
            System.out.println("是字符串类型！");
        }

        //注：这个获取的是 java.lang.Class 类的描述
        Class<? extends Class> clazz4 = clazz3.getClass();

        Method method = clazz3.getMethod("sayHello",String.class);
        MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
        System.out.println(methodAnnotation.value());
        final AnnotatedType annotatedReturnType = method.getAnnotatedReturnType();

        //获取公有属性
        Field publicField = clazz3.getField("sex");
        FieldAnnotation fieldAnnotation1 = publicField.getAnnotation(FieldAnnotation.class);
        System.out.println(fieldAnnotation1.value());

        //反射获取属性，无论公有、私有
        Field privateField = clazz3.getDeclaredField("name");
        FieldAnnotation fieldAnnotation2 = privateField.getAnnotation(FieldAnnotation.class);
        System.out.println(fieldAnnotation2.value());

        Object instanceByClass = clazz3.newInstance();
        Object result1 = method.invoke(instanceByClass, "guang");
        //获取到 method 对象后，也可以自己 new 对象实例，执行 invoke 方法调用
        Object result2 = method.invoke(hello,"guang");

        Constructor ctor = clazz3.getConstructor();
        Object instanceByConstructor = ctor.newInstance();

        int [] ints = new int[2];
        Class<? extends int[]> intsClass = ints.getClass();
        String intRefenceType = intsClass.getTypeName();

    }

    /**
     *
     * 测试反射入参为 Map 时， Map value 里有 null 值，反射调用会不会有空指针异常。
     * 结果：无异常，依然能 debug 进入所反射调用的方法里
     * */
    @Test
    public void test2() throws Exception{
        Class clazz = Class.forName("com.chifuyong.reflect.Hello");
        Object instance = clazz.newInstance();
        Method method = clazz.getMethod("sayHello", Map.class);
        Map<Object,Object> map = new HashMap<>(4);
        map.put("name","guang");
        map.put("passwd",null);
        map.put(null,"test");
        map.put(null,null);
        Object result = method.invoke(instance, map);
    }

}

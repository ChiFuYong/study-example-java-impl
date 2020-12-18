package com.chifuyong.reflect;

import com.chifuyong.reflect.annotation.ClassAnnotation;
import com.chifuyong.reflect.annotation.ConstructorMethodAnnotation;
import com.chifuyong.reflect.annotation.FieldAnnotation;
import com.chifuyong.reflect.annotation.MethodAnnotation;

import java.util.Map;
import java.util.Objects;

/**
 * 被反射类
 *
 * @date： 2020/12/15
 * @author: chify
 */
@ClassAnnotation
public class Hello {

    @ConstructorMethodAnnotation
    public Hello(){
    }

    @FieldAnnotation()
    private String name;

    @FieldAnnotation("public")
    public String sex;

    @MethodAnnotation("sayHello")
    public String sayHello(String myName){
        System.out.println("Hello，My name is " + myName);
        return "成功";
    }

    @MethodAnnotation
    public String sayHello(Map<Object,Object> map){
        System.out.println("这个入参是 Map !");
        for (Object str : map.keySet()){
            System.out.println(str + ": " + map.get(str));
        }
        Object nullResult = map.get(null);
        return "成功";
    }

}

package com.chifuyong.reflect.annotation;

import jdk.nashorn.internal.ir.annotations.Reference;

import java.lang.annotation.*;

/**
 * 构造方法注解测试
 *
 * @date： 2020/12/15
 * @author: chify
 */
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ConstructorMethodAnnotation {

    String value() default "默认构造注解值";

}

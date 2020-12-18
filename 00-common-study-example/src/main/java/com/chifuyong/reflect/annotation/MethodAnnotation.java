package com.chifuyong.reflect.annotation;

import java.lang.annotation.*;

/**
 * 方法注解测试
 *
 * @date： 2020/12/15
 * @author: chify
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MethodAnnotation {

    String value() default "默认方法值！";

}

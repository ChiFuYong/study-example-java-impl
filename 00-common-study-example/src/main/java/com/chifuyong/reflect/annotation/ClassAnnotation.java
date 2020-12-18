package com.chifuyong.reflect.annotation;

import java.lang.annotation.*;

/**
 * 类注解测试
 *
 * @date： 2020/12/15
 * @author: chify
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ClassAnnotation {

    String value() default "默认注解类值";

}

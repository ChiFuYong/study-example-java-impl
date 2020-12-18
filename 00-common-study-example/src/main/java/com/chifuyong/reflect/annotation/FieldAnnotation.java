package com.chifuyong.reflect.annotation;

import java.lang.annotation.*;

/**
 * 字段注解测试
 *
 * @date： 2020/12/15
 * @author: chify
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FieldAnnotation {

    String value() default "默认字段值";

}

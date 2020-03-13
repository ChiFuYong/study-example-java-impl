package com.chifuyong.b_aop.b_spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Auther: chify
 * @Date: 01/03/2020 11:18
 * @Description: Spring AOP 切面类
 */
public class SpringAspect implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before......");

        Object obj = invocation.proceed();

        System.out.println("after......");
        return obj;
    }
}

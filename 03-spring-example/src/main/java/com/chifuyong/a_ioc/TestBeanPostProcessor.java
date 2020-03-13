package com.chifuyong.a_ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: chify
 * @Date: 29/02/2020 09:08
 * @Description:
 */
public class TestBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化前（TestBeanPostProcessor）...."+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        System.out.println("初始化后（TestBeanPostProcessor）...."+beanName);
        //动态代理
        return Proxy.newProxyInstance(
                TestBeanPostProcessor.class.getClassLoader(),
                bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("切面前...");
                        Object obj = method.invoke(bean,args);
                        System.out.println("切面后...");
                        return null;
                    }
                });
    }
}

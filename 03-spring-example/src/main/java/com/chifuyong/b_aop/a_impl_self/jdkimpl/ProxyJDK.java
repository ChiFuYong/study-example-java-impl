package com.chifuyong.b_aop.a_impl_self.jdkimpl;

import com.chifuyong.b_aop.a_impl_self.Aspect;
import com.chifuyong.b_aop.TestService;
import com.chifuyong.b_aop.TestServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: chify
 * @Date: 01/03/2020 10:02
 * @Description: 动态代理 JDK 实现(前提必须要有接口)
 */
public class ProxyJDK {

    //切面类
    final static Aspect aspect = new Aspect();
    //目标类
    final static TestService testService = new TestServiceImpl();

    public static TestService createService(){
        //代理类：将目标类（切入点）和切面类（通知）结合
        TestService proxyService = (TestService) Proxy.newProxyInstance(ProxyJDK.class.getClassLoader(), testService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //切面before
                        aspect.before();
                        //执行目标方法
                        Object obj = method.invoke(testService,args);
                        //切面after
                        aspect.after();
                        return obj;
                    }
                }
        );
        return proxyService;
    }


}

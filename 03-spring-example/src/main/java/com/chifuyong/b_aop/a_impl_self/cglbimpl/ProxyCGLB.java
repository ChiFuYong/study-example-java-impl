package com.chifuyong.b_aop.a_impl_self.cglbimpl;

import com.chifuyong.b_aop.a_impl_self.Aspect;
import com.chifuyong.b_aop.TestServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: chify
 * @Date: 01/03/2020 10:32
 * @Description: CGLB实现动态代理（不需要接口）
 */
public class ProxyCGLB {

    //目标类
    final static TestServiceImpl testServiceImpl = new TestServiceImpl();

    //切面类
    final static Aspect aspect = new Aspect();

    public static TestServiceImpl createService(){
        // 1.cglb核心类
        Enhancer enhancer = new Enhancer();
        // 2.确定父类
        enhancer.setSuperclass(testServiceImpl.getClass());
        // 3.设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //切面before
                aspect.before();
                //执行目标方法
                Object obj = method.invoke(testServiceImpl,args);
                //执行代理类的父类:目标类（代理类和目标类为父子关系）
                methodProxy.invokeSuper(proxy,args);
                //切面after
                aspect.after();
                return obj;
            }
        });
        // 4.创建代理
        TestServiceImpl testServiceProxy = (TestServiceImpl) enhancer.create();
        return testServiceProxy;
    }

}

package com.chifuyong.b_aop;

import com.chifuyong.b_aop.a_impl_self.cglbimpl.ProxyCGLB;
import com.chifuyong.b_aop.a_impl_self.jdkimpl.ProxyJDK;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chify
 * @Date: 03/03/2020 16:30
 * @Description:
 */
public class TestAopDemo {

    /*
     * JDK 动态代理测试
     * */
    @Test
    public void proxyJDK(){
        TestService testService = ProxyJDK.createService();
        System.out.println("jdk 动态代理实现......");
        testService.add();
        testService.edit();
        testService.commit();
    }

    /*
     * CGLB 动态代理测试
     * */
    @Test
    public void proxyCGLB(){
        System.out.println("CGLB 动态代理实现......");
        TestService testService = ProxyCGLB.createService();
        testService.add();
        testService.edit();
        testService.commit();
    }

    /*
     * Spring AOP半自动
     * */
    @Test
    public void springAOP1(){
        String xmlPath = "b_aop/a_spring.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        TestService testService = (TestService) applicationContext.getBean("proxyService");
        testService.add();
        testService.edit();
        testService.commit();
    }

    /*
     * Spring AOP全自动
     * */
    @Test
    public void springAOP2(){
        String xmlPath = "b_aop/a_spring.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        TestService testService = (TestService) applicationContext.getBean("testService");
        testService.add();
        testService.edit();
        testService.commit();
    }

    /*
     * AspectJ AOP xml版
     * */
    @Test
    public void aspectJ(){
        String xmlPath = "b_aop/b_aspectj.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        TestService testService = (TestService) applicationContext.getBean("testService");
        testService.add();
        testService.edit();
        testService.commit();
    }

    /*
     * AspectJ AOP 注解版
     * */
    @Test
    public void aspectJAnnotation(){
        String xmlPath = "b_aop/c_annotation.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        TestService testService = (TestService) applicationContext.getBean("testService");
        testService.add();
        testService.edit();
        testService.commit();
    }
}

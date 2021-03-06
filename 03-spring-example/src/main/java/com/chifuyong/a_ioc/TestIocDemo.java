package com.chifuyong.a_ioc;

import com.chifuyong.a_ioc.a_di.UserService;
import com.chifuyong.a_ioc.c_properties.Person;
import com.chifuyong.a_ioc.c_properties.Student;
import com.chifuyong.a_ioc.c_properties.Teacher;
import com.chifuyong.a_ioc.d_annotation.DemoController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Properties;

/**
 * @Auther: chify
 * @Date: 28/02/2020 10:59
 * @Description: Test Demo类
 */
public class TestIocDemo {

    /*
    * IOC 示例
    * */
    @Test
    public void test1(){
        String xmlPath = "a_ioc/a_iocdi.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Service service = (Service) applicationContext.getBean("service");
        service.helloWorld();
    }

    /*
    * DI 示例
    * */
    @Test
    public void test2(){
        String xmlPath = "a_ioc/a_iocdi.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.helloWorld();
    }

    /*
    * 静态工厂方式获取对象
    * */
    @Test
    public void test3(){
        String xmlPath = "a_ioc/b_factory.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Service Service = (Service) applicationContext.getBean("staticFactory",Service.class);
        Service.staticFactory();
    }

    /*
     * 实例工厂方式获取对象
     * */
    @Test
    public void test4(){
        String xmlPath = "a_ioc/b_factory.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Service Service = (Service) applicationContext.getBean("intanceFactory",Service.class);
        Service.instanceFactory();
    }

    /**
     * 测试 FactoryBean
     */
    @Test
    public void test5(){
        String xmlPath = "a_ioc/b_factory.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Properties properties = System.getProperties();
        Properties properties1 = applicationContext.getBean("env", Properties.class);
        Properties properties2 = applicationContext.getBean("env", Properties.class);
        System.out.println(properties == properties1);
        //判断是否为单例
        System.out.println(properties1 == properties2);
        // 测试 env 注入的效果，详细看配置文件
        ServiceImpl service = applicationContext.getBean("testEnvBean",ServiceImpl.class);
        System.out.println("service. = " + service.getTestEnv());
    }


    /*
    * BeanPostProcesser 示例
    * */
    @Test
    public void beanPostProcesser(){
        String xmlPath = "a_ioc/c_beanpostprocessor.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Service Service = (Service) applicationContext.getBean("service",Service.class);
        Service.helloWorld();
        //关闭容器后，bean 会调用 destroy-method 方法
        applicationContext.close();
    }

    /*
    * 构造方法注入properties
    * */
    @Test
    public void constructor(){
        String xmlPath = "a_ioc/d_properties.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }

    /*
     * set方法注入properties
     * */
    @Test
    public void set(){
        String xmlPath = "a_ioc/d_properties.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    /*
     * 集合注入
     * */
    @Test
    public void collect(){
        String xmlPath = "a_ioc/d_properties.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Teacher teacher = (Teacher) applicationContext.getBean("teacher");
        System.out.println(teacher);
    }

    /*
     * p命名空间
     * */
    @Test
    public void p(){
        String xmlPath = "a_ioc/d_properties.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Person person = (Person) applicationContext.getBean("person2");
        System.out.println(person);
    }

    /*
     * spel表达式
     * */
    @Test
    public void spel(){
        String xmlPath = "a_ioc/d_properties.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Person person = (Person) applicationContext.getBean("person3");
        Person person2 = (Person) applicationContext.getBean("person4");
        System.out.println(person);
        System.out.println(person2);
    }

    /*
    * 注解开发
    * */
    @Test
    public void annotation(){
        String xmlPath = "a_ioc/e_annotation.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        DemoController demoController = (DemoController) applicationContext.getBean("demoController");
        demoController.controller();
    }


}



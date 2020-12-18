package com.chifuyong.a_ioc.d_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Auther: chify
 * @Date: 29/02/2020 21:33
 * @Description:
 */
@Service
public class DemoServiceImpl implements DemoService{

    /*
    * 按名称注入方式一
    * */
    @Autowired
    @Qualifier("demoDaoImpl1")
    private DemoDao demoDao1;

    /*
    * 按名称注入方式二
    * */
    @Resource(name = "demoDaoImpl2")
    private DemoDao demoDao2;

    /*
    * 给普通数据注入值,这里也可以使用 spel 表达式
    * */
    @Value("test")
    private String name;

    @Resource(name = "demoDaoImpl1")
    private DemoDao demoDao3;

    @Override
    public void service() {
        System.out.println("进入 DemoServiceImpl...");
        System.out.println("name : "+this.name);
        demoDao1.dao();
        demoDao2.dao();
        demoDao3.dao();
    }
}

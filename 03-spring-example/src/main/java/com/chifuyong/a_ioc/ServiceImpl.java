package com.chifuyong.a_ioc;

/**
 * @Auther: chify
 * @Date: 28/02/2020 10:56
 * @Description:
 */
public class ServiceImpl implements Service {

    public void helloWorld() {
        System.out.println("Hello World!!!");
    }

    public void staticFactory(){
        System.out.println("StaticFactory Success !");
    }

    public void instanceFactory(){
        System.out.println("InstanceFactory Success !");
    }

    public void init(){
        System.out.println("Service Bean 初始化。。。");
    }

    public void destory(){
        System.out.println("Service Bean 销毁。。。");
    }

}

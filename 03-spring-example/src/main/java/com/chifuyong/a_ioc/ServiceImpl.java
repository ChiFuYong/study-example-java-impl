package com.chifuyong.a_ioc;

/**
 * @Auther: chify
 * @Date: 28/02/2020 10:56
 * @Description:
 */
public class ServiceImpl implements Service {

    private String testEnv;

    public void setTestEnv(String testEnv) {
        this.testEnv = testEnv;
    }

    public String getTestEnv() {
        return testEnv;
    }

    public ServiceImpl() {
        System.out.println("ServiceImpl 构造方法。。。");
    }

    public void helloWorld() {
        System.out.println("Hello World!!!");
    }

    public void staticFactory(){
        System.out.println("StaticFactory Success !");
    }

    public void instanceFactory(){
        System.out.println("InstanceFactory Success !");
    }

    /**
     * BeanPostProcessor 类对象的 before 方法之后执行，after 方法之后执行
     * （配置文件中配的 init-method）
     */
    public void init(){
        System.out.println("Service Bean 初始化方法（init-method）。。。");
    }

    /**
     * Spring 容器 close() 之后会调用（配置文件中配的 destroy-method）
     */
    public void destory(){
        System.out.println("Service Bean 销毁方法(destroy-method)。。。");
    }

}

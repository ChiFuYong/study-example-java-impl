package com.chifuyong.web.example.springmvc;

/**
 * SpringMVC客户端模拟
 *
 * @date： 2020/4/19
 * @author: chify
 */
public class SpringMvcConsumer {

    public static void main(String[] args) {
        // SpringMVC 单例 Controller 线程不安全示例
        threadNoSafeDemo();
        // SpringMVC 单例 Controller 线程安全示例
//        threadNafeDemo();
    }

    /**
     * 线程安全示例
     */
    private static void threadNafeDemo() {
        Thread t1 = new ThreadSafeDemo();
        Thread t2 = new ThreadSafeDemo();
        Thread t3 = new ThreadSafeDemo();
        Thread t4 = new ThreadSafeDemo();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    /**
     * 线程不安全示例
     */
    public static void threadNoSafeDemo(){
        Thread t1 = new Thread(new ThreadNoSafeDemo());
        Thread t2 = new Thread(new ThreadNoSafeDemo());
        Thread t3 = new Thread(new ThreadNoSafeDemo());
        Thread t4 = new Thread(new ThreadNoSafeDemo());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

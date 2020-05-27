package com.chifuyong.web.example.servlet;

/**
 * 模拟客户端
 *
 * @date： 2020/4/15
 * @author: chify
 */
public class ServlectThreadConsumer {

    public static void main(String[] args) {
        //Servlet 单实例线程不安全示例
//        threadNoSafeDemo();
        threadNoSafeDemo2();
        //Servlet 单实例线程安全示例
//        threadSafeDemo();
    }

    /**
     * 线程安全示例（实现 Runnable 接口）
     */
    private static void threadSafeDemo() {
        Thread t1 = new Thread(new ThreadSafeDemo());
        Thread t2 = new Thread(new ThreadSafeDemo());
        Thread t3 = new Thread(new ThreadSafeDemo());
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 线程不安全示例（继承 Thread 类）
     */
    private static void threadNoSafeDemo() {
        Thread t1 = new ThreadNoSafeDemo();
        Thread t2 = new ThreadNoSafeDemo();
        Thread t3 = new ThreadNoSafeDemo();
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 线程不安全示例2（继承 Thread 类）
     */
    private static void threadNoSafeDemo2() {
        Thread t1 = new ThreadNoSafeDemo2();
        Thread t2 = new ThreadNoSafeDemo2();
        Thread t3 = new ThreadNoSafeDemo2();
        t1.start();
        t2.start();
        t3.start();
    }
}

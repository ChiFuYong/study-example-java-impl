package com.chifuyong.web.example.servlet;

/**
 * 线程安全 Demo(实现 Runnable)
 *
 * @date： 2020/4/15
 * @author: chify
 */
public class ThreadSafeDemo implements Runnable{

    /**
     * 获得一个 Servlet 单例对象，所有的多线程实例对象，使用的 servlet 对象都将是同一个
     * 此时，servlet 下的 visitNumber 状态即使不是静态的，也是被多个 ThreadSafeDemo 线程实例共享了！
     */
    private Servlet servlet = Servlet.getInstance();

    /*
    * 锁对象(显示定义 "lock" 字符串为锁时，因为字符串在常量池里，是不可变的，所以可以不使用 static 修饰符)
    * */
    private String lock = "lock";

    /*
    * 无效锁，每个 ThreadSafeDemo 对象都会有一个单独锁，所以无效
    * */
    private String lock2 = new String("lock");

    /*
    * 有效锁，每个 ThreadSafeDemo 对象都会有一个单独锁，所以无效
    * */
    private static String lock3 = new String("lock");

    public void run() {
        while (true){
            synchronized (lock){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int visitNumber =  servlet.addVisitNumber();
                System.out.println("线程 " + Thread.currentThread().getName() + " 访问一次 Servlet，访问总次数为：" + visitNumber);
            }
        }
    }
}

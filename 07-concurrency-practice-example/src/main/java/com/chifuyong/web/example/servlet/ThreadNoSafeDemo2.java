package com.chifuyong.web.example.servlet;

/**
 * 线程不安全 Demo2（实现 Thread 类）
 *
 * @date： 2020/4/15
 * @author: chify
 */
public class ThreadNoSafeDemo2 extends Thread{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread 的 run 方法里如果创建一个单例的局部变量，也是线程不安全的
            Servlet servlet = Servlet.getInstance();
            int visitNumber =  servlet.addVisitNumber();
            System.out.println("线程 " + getName() + " 访问一次 Servlet，访问总次数为：" + visitNumber);
        }
    }
}

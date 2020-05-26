package com.chifuyong.web.example.servlet;

/**
 * 线程不安全 Demo（实现 Thread 类）
 *
 * @date： 2020/4/15
 * @author: chify
 */
public class ThreadNoSafeDemo extends Thread{

    /**
     * 获得一个 Servlet 单例对象，所有的多线程实例对象，使用的 servlet 对象都将是同一个
     * 此时，servlet 下的 visitNumber 状态即使不是静态的，也是被多个 ThreadNoSafeDemo 线程实例共享了！
     */
    private Servlet servlet = Servlet.getInstance();


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int visitNumber =  servlet.addVisitNumber();
            System.out.println("线程 " + getName() + " 访问一次 Servlet，访问总次数为：" + visitNumber);
        }
    }
}

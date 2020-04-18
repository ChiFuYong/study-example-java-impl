package com.chifuyong.trainticket.thread;

/**
 * 火车站买票线程安全 Demo（实现 Runnable 接口）
 *
 * @date： 2020/4/15
 * @author: chify
 */
public class TrainTicketThreadSafe implements Runnable{

    /**
     * 静态资源，当有多个 TrainTicketThreadSafe 对象时，会被共享
     */
    private static int ticketNumber = 1000;

    /**
     * 静态锁对象，可以把任意对象当做锁对象，
     * 如果不是静态的，创建多个线程实例时，各个线程都有自己的锁对象，就会失效
     */
    private static Object lock = new Object();

    public void run(){
        //使用 synchronized 对代码块进行上锁，没有拿到锁的线程将会被阻塞，直到线程对象拿到了锁对象，才可执行
        while (true){
            synchronized (lock){
                if (ticketNumber > 0){
                    ticketNumber--;
                    if(ticketNumber == 0){
                        System.out.println("售票窗口：" + Thread.currentThread().getName() + " 售出最后一张车牌，窗口关闭！");
                        break;
                    }else {
                        System.out.println("售票窗口：" + Thread.currentThread().getName() + " 出售一张火车票，火车票还剩 " + ticketNumber );
                    }
                }else {
                    System.out.println("票已售完，售票窗口：" + Thread.currentThread().getName()  + " 关闭！");
                    break;
                }
            }
        }
    }


}

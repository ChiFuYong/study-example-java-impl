package com.chifuyong.trainticket;

import com.chifuyong.trainticket.thread.TrainTicketThreadNoSafe;
import com.chifuyong.trainticket.thread.TrainTicketThreadSafe;

/**
 * 客户端调用类
 *
 * @date： 2020/4/15
 * @author: chify
 */
public class TicketConsumer {


    public static void main(String[] args) {
        //火车站买票线程不安全示例
        testTrainTicketThreadNoSafe();
        //火车站买票线程安全示例
//        testTrainTicketThreadSafe();
    }


    /**
     * 火车站线程安全示例（实现 runnable 的方式实现多线程）
     */
    private static void testTrainTicketThreadSafe() {
        Thread t1 = new Thread(new TrainTicketThreadSafe());
        Thread t2 = new Thread(new TrainTicketThreadSafe());
        Thread t3 = new Thread(new TrainTicketThreadSafe());
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 火车站线程不安全示例（继承 Thread 类）
     */
    private static void testTrainTicketThreadNoSafe() {
        Thread t1 = new TrainTicketThreadNoSafe();
        Thread t2 = new TrainTicketThreadNoSafe();
        Thread t3 = new TrainTicketThreadNoSafe();
        t1.start();
        t2.start();
        t3.start();
    }


}

package com.chifuyong.trainticket.thread;

/**
 * 火车站买票线程安全 Demo（继承 Thread 类）
 *
 * @date： 2020/4/15
 * @author: chify
 */
public class TrainTicketThreadNoSafe extends Thread{

    /**
     * 静态资源，当有多个 TrainTicketThreadNoSafe 对象时，会被共享
     */
    private static int ticketNumber = 1000;

    @Override
    public void run() {
        //多线程访问 ticketNumber 状态时，会因为执行顺序出现并发问题
        while (true){
            if (ticketNumber > 0){
                ticketNumber--;
                if(ticketNumber == 0){
                    System.out.println("售票窗口：" + getName() + "售出最后一张车牌，窗口关闭！");
                    break;
                }else {
                    System.out.println("售票窗口：" + getName() + " 出售一张火车票，火车票还剩 " + ticketNumber );
                }
            }else {
                System.out.println("票已售完，售票窗口：" + getName() + "关闭！");
                break;
            }
        }
    }

}

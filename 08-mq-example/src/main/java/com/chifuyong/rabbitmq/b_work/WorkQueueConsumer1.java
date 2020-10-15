package com.chifuyong.rabbitmq.b_work;

import com.chifuyong.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 工作队列消费者1 demo
 * 注：默认以轮询的方式消费消息
 *
 * @Date: 2020/10/15
 * @author: chify
 */
public class WorkQueueConsumer1 {

    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建频道
        Channel channel = connection.createChannel();
        //创建队列：并设置消息处理
        channel.queueDeclare(WorkQueueProducter.QUEUE_NAME,true,false,false,null);
        //监听消息
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            /*
             * consumerTag ：消息者标签，在channel.basicConsume时候可以指定
             * envelope: 消息包内容，可从中获取消息id、消息routingkey、交换机、消息、重转标记（收到消息失败后是否需要重新发送）
             * properties: 消息属性
             * body： 消息
             * */
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("");
                System.out.println("=====================消费者1开始===========================================");
                System.out.println("");
                //路由key
                System.out.println("路由 key 为：" + envelope.getRoutingKey());
                //交换机
                System.out.println("交换机为：" + envelope.getExchange());
                //消息id
                System.out.println("消息 id 为：" + envelope.getDeliveryTag());
                //收到的消息
                System.out.println("接收到的消息：" + new String(body, "UTF-8"));
                System.out.println("");
                System.out.println("======================消费者1结束==========================================");
                System.out.println("");
                try {
                    //休眠一秒钟
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        /*
         * 监听消息
         * 参数一：队列名称
         * 参数二：是否自动确认，设置为 true 表示消息接收到自动向 mq 回复接收到了，mq 接收到回复后会删除消息；设置为 false 则需要手动确认
         * */
        channel.basicConsume(WorkQueueProducter.QUEUE_NAME, true, consumer);

        //不关闭资源，应该一直监听消息
//        channel.close();
//        connection.close();
    }

}

package com.chifuyong.rabbitmq.b_work;

import com.chifuyong.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 工作队列消息生产者 Demo
 *
 * @Date: 2020/10/15
 * @author: chify
 */
public class WorkQueueProducter {

    static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws Exception{
        //创建连接
        Connection connection = ConnectionUtil.getConnection();
        //创建频道
        Channel channel = connection.createChannel();
        /*
         * 声明（创建）队列
         * 参数一：队列名称
         * 参数二：是否定义持久化队列
         * 参数三：是否独占本次连接
         * 参数四：是否在不使用的时候自动删除队列
         * 参数五：队列其他参数
         * */
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        //发布50条消息
        for( int i = 1 ; i <= 50 ; i++ ){
            String message = "你好，工作队列" + i;
            channel.basicPublish("",QUEUE_NAME,null, message.getBytes());
            System.out.println("消息已发送：" + message);
        }
        //释放资源
        channel.close();
        connection.close();
    }

}

package com.chifuyong.rabbitmq.a_simple;

import com.chifuyong.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;

/**
 * 单端队列生产者 Demo
 *
 * @Date: 2020/9/18
 * @author: chify
 */
public class SimpleQueueProducter {

    static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws Exception {
        //获取连接
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

        //发布消息
        String message = "你好，单端队列！";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("已发送消息：" + message);

        //释放资源
        channel.close();
        connection.close();
    }

}

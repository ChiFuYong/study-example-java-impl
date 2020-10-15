package com.chifuyong.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * RabbitMQ 工具类
 *
 * @Date: 2020/10/15
 * @author: chify
 */
public class ConnectionUtil {

    private static final String RABBITMQ_HOST = "192.168.179.3";

    private static final Integer RABBITMQ_PORT = 5672;

    private static final String RABBITMQ_VHOST = "/";

    private static final String RABBITMQ_USERNAME = "guest";

    private static final String RABBITMQ_PASSWORD = "guest";

    /** 工厂类 */
    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    static{
        //主机地址;默认为 localhost
        connectionFactory.setHost(RABBITMQ_HOST);
        //连接端口;默认为 5672
        connectionFactory.setPort(RABBITMQ_PORT);
        //虚拟主机名称;默认为 /
        connectionFactory.setVirtualHost(RABBITMQ_VHOST);
        //连接用户名；默认为guest
        connectionFactory.setUsername(RABBITMQ_USERNAME);
        //连接密码；默认为guest
        connectionFactory.setPassword(RABBITMQ_PASSWORD);
    }

    public static Connection getConnection() throws Exception {
        //创建连接
        return connectionFactory.newConnection();
    }
}

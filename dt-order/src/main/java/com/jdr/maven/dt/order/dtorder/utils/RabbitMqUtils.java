package com.jdr.maven.dt.order.dtorder.utils;

import com.jdr.maven.dt.order.dtorder.config.rabbitmq.RabbitMqConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhoude
 * @date 2019/11/5 11:21
 */
@Component
@AllArgsConstructor
public class RabbitMqUtils {

    private final RabbitMqConfig rabbitMQConfig;

    public Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitMQConfig.getHost());
        factory.setPort(rabbitMQConfig.getPort());
        factory.setUsername(rabbitMQConfig.getUsername());
        factory.setPassword(rabbitMQConfig.getPassword());
        return factory.newConnection();
    }

    public void close(Connection connection, Channel channel) throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
}

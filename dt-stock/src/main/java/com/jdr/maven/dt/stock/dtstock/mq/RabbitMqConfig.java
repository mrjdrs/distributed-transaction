package com.jdr.maven.dt.stock.dtstock.mq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhoude
 * @date 2019/11/26 14:47
 */
@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
@Data
public class RabbitMqConfig {

    private String host;
    private int port;
    private String username;
    private String password;
}

package com.jdr.maven.dt.stock.dtstock.mq.queue;

import com.jdr.maven.dt.common.mq.QueueConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhoude
 * @date 2019/11/26 15:05
 */
@Configuration
public class QueueConfig {

    @Bean
    public Queue initTxOrderQueue() {
        return new Queue(QueueConstant.TX_ORDER_QUEUE);
    }

    @Bean
    public Queue initTxOrderReturnFailQueue() {
        return new Queue(QueueConstant.TX_ORDER_QUEUE_RETURN_FAIL);
    }

    @Bean
    public Queue initTxOrderReturnSuccessQueue() {
        return new Queue(QueueConstant.TX_ORDER_QUEUE_RETURN_SUCCESS);
    }
}

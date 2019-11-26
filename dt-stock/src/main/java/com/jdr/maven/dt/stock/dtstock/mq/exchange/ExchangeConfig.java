package com.jdr.maven.dt.stock.dtstock.mq.exchange;

import com.jdr.maven.dt.common.mq.ExchangeConstant;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhoude
 * @date 2019/11/26 15:05
 */
@Configuration
public class ExchangeConfig {

    @Bean
    public DirectExchange initTxOrderExchange() {
        return new DirectExchange(ExchangeConstant.TX_ORDER_EXCHANGE);
    }

    @Bean
    public DirectExchange initTxOrderReturnExchange() {
        return new DirectExchange(ExchangeConstant.TX_RETURN_EXCHANGE);
    }
}

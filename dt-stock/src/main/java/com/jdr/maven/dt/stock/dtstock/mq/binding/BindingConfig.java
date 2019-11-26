package com.jdr.maven.dt.stock.dtstock.mq.binding;

import com.jdr.maven.dt.common.mq.RoutingKeyConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhoude
 * @date 2019/11/26 15:30
 */
@Configuration
public class BindingConfig {

    @Bean
    public Binding bindingExchangeMessageTx(@Qualifier("initTxOrderQueue") Queue queueMessage,
                                            @Qualifier("initTxOrderExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with(RoutingKeyConstant.TX_ORDER_ROUTING_KEY);
    }

    @Bean
    public Binding bindingExchangeMessageFailTx(@Qualifier("initTxOrderReturnFailQueue") Queue queueMessage,
                                            @Qualifier("initTxOrderReturnExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with(RoutingKeyConstant.TX_ORDER_FAIL_ROUTING_KEY);
    }

    @Bean
    public Binding bindingExchangeMessageSuccessTx(@Qualifier("initTxOrderReturnSuccessQueue") Queue queueMessage,
                                            @Qualifier("initTxOrderReturnExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with(RoutingKeyConstant.TX_ORDER_SUCCESS_ROUTING_KEY);
    }
}

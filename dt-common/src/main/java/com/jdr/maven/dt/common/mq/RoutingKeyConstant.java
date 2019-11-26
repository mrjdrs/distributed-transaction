package com.jdr.maven.dt.common.mq;

/**
 * @author zhoude
 * @date 2019/11/26 14:57
 */
public interface RoutingKeyConstant {

    String TX_ORDER_ROUTING_KEY = "tx_order_routingKey";

    String TX_ORDER_FAIL_ROUTING_KEY = "tx_order_fail_routingKey";

    String TX_ORDER_SUCCESS_ROUTING_KEY = "tx_order_success_routingKey";
}

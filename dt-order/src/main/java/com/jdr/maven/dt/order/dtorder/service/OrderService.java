package com.jdr.maven.dt.order.dtorder.service;

import com.alibaba.fastjson.JSONObject;
import com.jdr.maven.dt.common.enums.OrderStatusEnum;
import com.jdr.maven.dt.common.mq.ExchangeConstant;
import com.jdr.maven.dt.common.mq.RoutingKeyConstant;
import com.jdr.maven.dt.order.dtorder.entity.OrderEntity;
import com.jdr.maven.dt.order.dtorder.repository.OrderRepository;
import com.jdr.maven.dt.order.dtorder.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhoude
 * @date 2019/11/25 17:06
 */
@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RabbitMqUtils rabbitMqUtils;

    @Transactional(rollbackFor = Exception.class)
    public void submitOrder(int stockId, int number) throws IOException, TimeoutException {
        // 插入订单
        OrderEntity order = saveOrder(stockId, number);
        // 修改库存
        updateStock(order);
    }

    private OrderEntity saveOrder(int stockId, int number) throws IOException, TimeoutException {
        OrderEntity order = new OrderEntity();
        order.setStockId(stockId);
        order.setCustomer("JDR");
        order.setNumber(number);
        order.setStatus(OrderStatusEnum.INIT.toString());
        orderRepository.save(order);
        return order;
    }

    private void sendUpdateStockMq(OrderEntity order) throws IOException, TimeoutException {
        // 提交订单成功后
        Channel channel = rabbitMqUtils.getConnection().createChannel();
        try {
            // 使用事务，使mq顺利到达broker
            channel.txSelect();
            //下单成功后，将订单信息保存至RabbitMQ中，由库存系统从MQ中获取数据，修改库存。
            channel.basicPublish(ExchangeConstant.TX_ORDER_EXCHANGE, RoutingKeyConstant.TX_ORDER_ROUTING_KEY,
                    MessageProperties.PERSISTENT_TEXT_PLAIN, JSONObject.toJSONString(order).getBytes());
            channel.txCommit();
        } catch (IOException e) {
            channel.txRollback();
            // 异常继续抛，回滚本地事务
            throw e;
        }
    }

    private void updateStock(OrderEntity order) throws IOException, TimeoutException {
        sendUpdateStockMq(order);
    }
}

package com.jdr.maven.dt.stock.dtstock.service;

import com.jdr.maven.dt.common.mq.ExchangeConstant;
import com.jdr.maven.dt.common.mq.RoutingKeyConstant;
import com.jdr.maven.dt.stock.dtstock.entity.OrderEntity;
import com.jdr.maven.dt.stock.dtstock.entity.StockEntity;
import com.jdr.maven.dt.stock.dtstock.repository.StockRepository;
import com.rabbitmq.client.Channel;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author zhoude
 * @date 2019/11/25 17:06
 */
@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final AmqpTemplate amqpTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void updateStock(OrderEntity order, Channel channel, Message message) throws IOException {
        try {
            StockEntity stock = stockRepository.findOne(order.getStockId());
            stock.setCount(stock.getCount() - order.getNumber());
            stockRepository.save(stock);
        } catch (Exception e) {
            // 消费失败，根据实际业务情况选择是否重新入队
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            throw e;
        }

        // 模拟失败情况的标识字段
        boolean sendFail = false;

        // jpa save函数无法判断更新条数，故用假的判断是否成功
        if (sendFail) {
            // 库存系统修改库存失败，则向MQ中发送成功失败ID
            amqpTemplate.convertAndSend(ExchangeConstant.TX_RETURN_EXCHANGE, RoutingKeyConstant.TX_ORDER_FAIL_ROUTING_KEY,
                    order.getId());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            throw new RuntimeException("============修改库存失败");
        } else {
            // 库存系统修改库存成功，则向MQ中发送成功订单ID
            amqpTemplate.convertAndSend(ExchangeConstant.TX_RETURN_EXCHANGE, RoutingKeyConstant.TX_ORDER_SUCCESS_ROUTING_KEY,
                    order.getId());
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}

package com.jdr.maven.dt.stock.dtstock.listener.rabbitmq;

import com.jdr.maven.dt.common.mq.QueueConstant;
import com.jdr.maven.dt.stock.dtstock.entity.OrderEntity;
import com.jdr.maven.dt.stock.dtstock.service.StockService;
import com.rabbitmq.client.Channel;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhoude
 * @date 2019/11/26 15:11
 */
@Component
@RabbitListener(queues = QueueConstant.TX_ORDER_QUEUE)
@AllArgsConstructor
public class TxListener {

    private final StockService stockService;

    @RabbitHandler
    public void process(String body, Channel channel, Message message) throws Exception {
        JSONObject obj = new JSONObject(body);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(obj.getInt("id"));
        orderEntity.setStockId(obj.getInt("stockId"));
        orderEntity.setCustomer(obj.getString("customer"));
        orderEntity.setNumber(obj.getInt("number"));
        orderEntity.setStatus(obj.getString("status"));
        stockService.updateStock(orderEntity, channel, message);
    }
}

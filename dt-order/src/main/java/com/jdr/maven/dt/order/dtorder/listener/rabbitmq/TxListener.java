package com.jdr.maven.dt.order.dtorder.listener.rabbitmq;

import com.jdr.maven.dt.common.mq.QueueConstant;
import com.jdr.maven.dt.order.dtorder.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhoude
 * @date 2019/11/26 15:11
 */
@Component
@AllArgsConstructor
public class TxListener {

    private final OrderService orderService;

    /**
     * 处理业务处理失败，回滚业务
     */
    @RabbitListener(queues = QueueConstant.TX_ORDER_QUEUE_RETURN_FAIL)
    public void process1(String orderId, Channel channel, Message message) throws Exception {
        try {
            orderService.shoppingRollback(Integer.valueOf(orderId));
        } catch (Exception e) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            e.printStackTrace();
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    /**
     * 处理业务处理成功，修改订单状态
     */
    @RabbitListener(queues = QueueConstant.TX_ORDER_QUEUE_RETURN_SUCCESS)
    public void process2(String orderId, Channel channel, Message message) throws Exception {
        try {
            orderService.shoppingCommit(Integer.valueOf(orderId));
        } catch (Exception e) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            e.printStackTrace();
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}

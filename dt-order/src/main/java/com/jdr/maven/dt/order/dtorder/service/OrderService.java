package com.jdr.maven.dt.order.dtorder.service;

import com.jdr.maven.dt.common.enums.OrderStatusEnum;
import com.jdr.maven.dt.order.dtorder.entity.OrderEntity;
import com.jdr.maven.dt.order.dtorder.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

/**
 * @author zhoude
 * @date 2019/11/25 17:06
 */
@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void submitOrder(int stockId, int number) {
        // 插入订单
        saveOrder(stockId, number);
        // 修改库存
        updateStock(stockId, number);
    }

    private void saveOrder(int stockId, int number) {
        OrderEntity order = new OrderEntity();
        order.setStockId(stockId);
        order.setCustomer("JDR");
        order.setNumber(number);
        order.setStatus(OrderStatusEnum.INIT.toString());
        orderRepository.save(order);
    }

    private void updateStock(int stockId, int number) {
        String url = "http://localhost:8081/stock/updateStock?stockId=" + stockId + "&number=" + number;
        restTemplate.getForObject(url, Integer.class);
    }
}

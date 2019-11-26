package com.jdr.maven.dt.order.dtorder.controller;

import com.jdr.maven.dt.order.dtorder.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhoude
 * @date 2019/11/25 17:01
 */
@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/submitOrder")
    public void submitOrder(@RequestParam("stockId") int stockId, @RequestParam("number") int number) throws IOException, TimeoutException {
        orderService.submitOrder(stockId, number);
    }
}

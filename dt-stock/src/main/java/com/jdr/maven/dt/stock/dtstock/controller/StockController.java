package com.jdr.maven.dt.stock.dtstock.controller;

import com.jdr.maven.dt.stock.dtstock.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoude
 * @date 2019/11/25 17:01
 */
@RestController
@RequestMapping("/stock")
@AllArgsConstructor
public class StockController {

    private final StockService stockService;

    @RequestMapping("/updateStock")
    public void updateStock(@RequestParam("stockId") int stockId, @RequestParam("number") int number) {
        try {
            stockService.updateStock(stockId, number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

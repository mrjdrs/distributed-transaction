package com.jdr.maven.dt.stock.dtstock.service;

import com.jdr.maven.dt.stock.dtstock.entity.StockEntity;
import com.jdr.maven.dt.stock.dtstock.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhoude
 * @date 2019/11/25 17:06
 */
@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    @Transactional(rollbackFor = Exception.class)
    public void updateStock(int stockId, int number) {
        StockEntity stock = stockRepository.findOne(stockId);
        stock.setCount(stock.getCount() - number);
        stockRepository.save(stock);
    }
}

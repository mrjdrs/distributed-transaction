package com.jdr.maven.dt.stock.dtstock.repository;

import com.jdr.maven.dt.stock.dtstock.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhoude
 * @date 2019/11/25 16:43
 */
@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer> {
}

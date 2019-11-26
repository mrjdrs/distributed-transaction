package com.jdr.maven.dt.order.dtorder.repository;

import com.jdr.maven.dt.order.dtorder.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhoude
 * @date 2019/11/25 16:43
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}

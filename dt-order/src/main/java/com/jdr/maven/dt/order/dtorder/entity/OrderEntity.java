package com.jdr.maven.dt.order.dtorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhoude
 * @date 2019/11/25 16:31
 */
@Entity(name = "t_order")
@Table(name = "t_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "stock_id")
    private Integer stockId;

    @Column(name = "customer")
    private String customer;

    @Column(name = "number")
    private Integer number;

    @Column(name = "status")
    private String status;
}

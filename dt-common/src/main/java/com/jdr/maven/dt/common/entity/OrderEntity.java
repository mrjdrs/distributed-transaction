package com.jdr.maven.dt.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Column(name = "id")
    private Integer id;

    @Column(name = "stoke_id")
    private Integer stokeId;

    @Column(name = "customer")
    private String customer;

    @Column(name = "number")
    private Integer number;

    @Column(name = "status")
    private Integer status;
}

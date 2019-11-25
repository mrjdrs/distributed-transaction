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
@Entity(name = "t_stoke")
@Table(name = "t_stoke")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockEntity {

    @Column(name = "id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "count")
    private Integer count;
}

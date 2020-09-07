package com.bamboo.pro.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Data
public class Order {

    private Integer orderId;

    private String orderName;

    private String orderNo;

    private LocalDateTime createDate;

    public static Order newInstance() {
        return new Order();
    }
}

package com.bamboo.pro.service;

import com.bamboo.pro.entity.Order;

import java.util.List;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
public interface OrderService {
    /**
     * 根据 id 查找客户
     * @param userId
     * @return
     */
    Order selectOrderById(Integer userId);

    /**
     *
     * @return
     */
    List<Order> selectAllOrders();
}

package com.bamboo.pro.service.impl;

import com.bamboo.pro.client.UserFeignClient;
import com.bamboo.pro.client.dto.User;
import com.bamboo.pro.entity.Order;
import com.bamboo.pro.service.OrderService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private UserFeignClient userFeignClient;

    private List<Order> orderList;

    @PostConstruct
    public void initAllUsers() {
        if (CollectionUtils.isEmpty(orderList)) {
            orderList = Lists.newArrayList();
        }

        for (int i = 0; i < 10; i++) {
            Order order = Order.newInstance();
            order.setCreateDate(LocalDateTime.now().plusDays(i));
            order.setOrderNo(LocalDateTime.now().plusDays(i).toString() + "0000" + i);
            order.setOrderName("order" + i);
            order.setOrderId(i);
            orderList.add(order);
        }
    }

    @Override
    public Order selectOrderById(Integer orderId) {
        User user = userFeignClient.selectUserById(orderId);
        log.info("user:{}", user);
        if (CollectionUtils.isEmpty(orderList)) {
            return null;
        }
        return orderList.get(orderId);
    }

    @Override
    public List<Order> selectAllOrders() {
        return orderList;
    }
}

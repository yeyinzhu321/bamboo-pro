package com.bamboo.pro.controller;

import com.bamboo.pro.entity.Order;
import com.bamboo.pro.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@RestController
@RequestMapping("/order/")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("selectOrderById")
    public Order selectOrderById (@RequestParam Integer orderId){
        return orderService.selectOrderById(orderId);
    }

    @GetMapping("selectAllOrders")
    public List<Order> selectAllOrders (){
        return orderService.selectAllOrders();
    }
}

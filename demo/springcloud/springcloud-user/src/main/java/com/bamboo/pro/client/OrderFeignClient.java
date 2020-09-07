package com.bamboo.pro.client;

import com.bamboo.pro.client.dto.Order;
import com.bamboo.pro.client.hystrix.OrderFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Component
@FeignClient(value = "BAMBOO-ORDER", fallbackFactory = OrderFallBackFactory.class,
        configuration = SpringEncoder.class)
public interface OrderFeignClient {

    /**
     * @return
     */
    @GetMapping(value = "/order/selectAllOrders", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Order> selectAllOrders();

}

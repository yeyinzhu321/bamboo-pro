package com.bamboo.pro.client.hystrix;

import com.bamboo.pro.client.OrderFeignClient;
import com.bamboo.pro.client.dto.Order;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Slf4j
@Component
public class OrderFallBackFactory implements FallbackFactory<OrderFeignClient> {

    @Override
    public OrderFeignClient create(Throwable throwable) {
        log.error("调用 order 查询失败,", throwable);
        return null;
    }
}

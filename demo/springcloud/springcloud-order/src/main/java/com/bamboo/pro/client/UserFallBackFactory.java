package com.bamboo.pro.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Slf4j
@Component
public class UserFallBackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        log.error("调用 UserFeignClient 接口异常,", throwable);
        return null;
    }
}

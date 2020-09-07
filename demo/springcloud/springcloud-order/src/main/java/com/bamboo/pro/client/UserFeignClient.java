package com.bamboo.pro.client;

import com.bamboo.pro.client.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Component
@FeignClient(value = "BAMBOO-USER", fallbackFactory = UserFallBackFactory.class,
        configuration = SpringEncoder.class)
public interface UserFeignClient {

    /**
     * @param userId
     * @return
     */
    @GetMapping("/user/selectUserById")
    User selectUserById(@RequestParam("userId") Integer userId);
}

package com.bamboo.pro.service.impl;

import com.bamboo.base.utils.JsonUtil;
import com.bamboo.pro.client.OrderFeignClient;
import com.bamboo.pro.client.dto.Order;
import com.bamboo.pro.entity.User;
import com.bamboo.pro.service.UserService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private OrderFeignClient orderFeignClient;

    private List<User> userList;

    @PostConstruct
    public void initAllUsers() {
        if (CollectionUtils.isEmpty(userList)) {
            userList = Lists.newArrayList();
        }

        for (int i = 0; i < 10; i++) {
            User user = User.newInstance();
            user.setAddress("上海" + i);
            user.setGender(i % 2);
            user.setUserName("bamboo" + i);
            user.setUserId(i);
            userList.add(user);
        }
    }


    @Override
    public User selectUserById(Integer userId) {
        List<Order> orderList = orderFeignClient.selectAllOrders();
        log.info("orderList:{}", JsonUtil.toString(orderList));
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(userId);
    }
}

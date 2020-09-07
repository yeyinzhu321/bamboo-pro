package com.bamboo.pro.service.impl;

import com.bamboo.pro.service.UserService;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Map<String, String> sayHello() {

        Map<String, String> map = Maps.newHashMap();
        map.put("userName", "Bamboo");
        map.put("gender", "男");
        map.put("userName", "Bamboo");
        map.put("address", "上海市");

        return map;
    }
}

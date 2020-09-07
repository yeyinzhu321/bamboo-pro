package com.bamboo.pro.service.impl;

import com.bamboo.pro.service.TestService;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public Map<String,String> testHello (){
        Map<String, String> map = Maps.newHashMap();
        map.put("userName", "Bamboo");
        map.put("gender", "男");
        map.put("age", "20");
        map.put("address", "上海市");
        return map;
    }

}

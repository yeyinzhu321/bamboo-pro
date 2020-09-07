package com.bamboo.pro.controller;

import com.bamboo.pro.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserService userService;

    @GetMapping("/hello/springboot")
    public Map<String, String> hello() {
        return userService.sayHello();
    }
}

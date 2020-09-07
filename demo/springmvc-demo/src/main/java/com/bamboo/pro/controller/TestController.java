package com.bamboo.pro.controller;

import com.bamboo.pro.service.TestService;
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
@RequestMapping("/test/")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("hello")
    public Map<String, String> testHello(){
        return testService.testHello();
    }
}

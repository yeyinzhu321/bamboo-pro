package com.bamboo.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("index")
    public String index(){
        return "index";
    }
}

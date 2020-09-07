package com.bamboo.pro.controller;

import com.bamboo.pro.entity.User;
import com.bamboo.pro.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("selectUserById")
    public User selectUserById (@RequestParam Integer userId){
        return userService.selectUserById(userId);
    }
}

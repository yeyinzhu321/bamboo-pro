package com.bamboo.pro.service;

import com.bamboo.pro.entity.User;

import java.util.Map;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
public interface UserService {
    /**
     * 根据 id 查找客户
     * @param userId
     * @return
     */
    User selectUserById(Integer userId);
}

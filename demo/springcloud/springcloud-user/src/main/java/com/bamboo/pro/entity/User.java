package com.bamboo.pro.entity;

import lombok.Data;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@Data
public class User {

    private Integer userId;

    private String userName;

    private Integer gender;

    private String address;

    public static User newInstance() {
        return new User();
    }
}

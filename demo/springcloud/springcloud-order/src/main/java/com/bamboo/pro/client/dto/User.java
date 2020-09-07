package com.bamboo.pro.client.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author : bamboo
 * @date : 2020-07-14
 */
@ToString
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

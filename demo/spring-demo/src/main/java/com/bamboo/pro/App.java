package com.bamboo.pro;

import com.bamboo.pro.entity.User;
import com.bamboo.pro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 */

@Slf4j
@Configuration
@ComponentScan("com.bamboo.pro")
public class App {

    @Bean
    public User user() {
        return new User();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
        log.info("user:", ac.getBean("user"));
        log.info("userService:", ac.getBean(UserService.class));
    }
}

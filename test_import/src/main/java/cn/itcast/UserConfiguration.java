package cn.itcast;

import org.springframework.context.annotation.Bean;

/**
 * 没有Spring 注解
 */
public class UserConfiguration {

    @Bean
    public User getUser(){
        User user = new User();
        user.setUserName("司鹏飞");
        user.setAge(30);
        return user;
    }
}

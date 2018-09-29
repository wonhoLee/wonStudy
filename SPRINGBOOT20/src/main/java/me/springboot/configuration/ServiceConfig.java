package me.springboot.configuration;

import me.springboot.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public UserService userService(){
        return new UserService();
    }
}

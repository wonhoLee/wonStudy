package me.springboot.me.springboot.service;

import org.springframework.stereotype.Service;

/*
 *  @author wonho
 */
@Service
public class HelloService {
    public String getMessage(){
        return "hello Spring Boot!!";
    }
}

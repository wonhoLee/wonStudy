package me.springboot.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/*
 *  @author wonho
 */
@Service
public class HelloService {
    public String getMessage(){
        return "Hello Spring Boot!!";
    }

    /*@PostConstruct
    public void init(){
        throw new RuntimeException("Intended Exception");
    }*/
}

package me.springboot.me.springboot.controller;

import me.springboot.me.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *  @author wonho
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/h1")
    public String hello(){
        return helloService.getMessage();
    }

    @RequestMapping("")
    public String home(){
        return "Hello World!! IntelliJ";
    }

}

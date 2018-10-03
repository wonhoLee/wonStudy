package me.springboot.controller;

import me.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/h")
    public String hello(){
        return helloService.getMessage();
    }

    @RequestMapping("")
    public String home() {
        return "Hello World! IntelliJ";
    }
}

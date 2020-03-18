package main.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Helloworld";
    }
}
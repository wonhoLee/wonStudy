package main.controller;

import main.service.Ch5Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ch5")
public class Ch5Controller {
    private final Ch5Service ch5Service;

    public Ch5Controller(Ch5Service ch5Service) {
        this.ch5Service = ch5Service;
    }

    @GetMapping("/run")
    public void run(){
        ch5Service.ch5run();
    }

    @GetMapping("/save")
    public void save(){
        ch5Service.testSave();
    }
}

package home.study.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/api")
public class SamController {

    @GetMapping
    public String test() {
        return "get";
    }

    @PostMapping
    public String pos() {
        return "post";
    }
}

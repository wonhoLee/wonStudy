package main.webservice.web;

import lombok.AllArgsConstructor;
import main.webservice.dto.posts.PostsSaveRequestDto;
import main.webservice.service.PostsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class webRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "Helloworld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
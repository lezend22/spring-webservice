package com.project1.webservice.web;

import com.project1.webservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    //data를 클라이언트로 부터 받아오는곳 ,@PostMapping으로 대체가능
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}

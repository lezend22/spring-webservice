package com.project1.webservice.web;

import com.project1.webservice.domain.posts.Posts;
import com.project1.webservice.repository.SpringDataJpaPostsRepository;
import com.project1.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class WebRestController {

    private SpringDataJpaPostsRepository postsRepository;

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "If this is REST API, the data has been send to server!";
    }

    //API로오는정보 받아서 dto를통해 저장!
    @PostMapping("/order-sheet")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsService.save(dto);
    }

    //get으로 받아올려면 쿼리스트링으로 받아야함
    @GetMapping(path = "inquiry/{customerName}")
    public Optional<Posts> inquiry(@PathVariable(name = "customerName") String customerName){
        return postsService.findOrder(customerName);
    }
}

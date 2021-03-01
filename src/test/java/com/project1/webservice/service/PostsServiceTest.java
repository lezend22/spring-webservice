package com.project1.webservice.service;

import com.project1.webservice.domain.posts.Posts;
import com.project1.webservice.domain.posts.PostsRepository;
import com.project1.webservice.web.PostsSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("서비스 로직 반환값확인")
    void serviceLogicTest(){

        PostsSaveRequestDto dto = PostsSaveRequestDto.builder().title("test1").content("tictoc").author("tony").build();

        postsService.save(dto);

        Posts post = postsRepository.findAll().get(0);

        System.out.println("post.getTitle() = " + post.getTitle());
        Assertions.assertThat(post.getTitle()).isEqualTo(dto.getTitle());

    }
}
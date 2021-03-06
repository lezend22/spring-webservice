package com.project1.webservice.service;

import com.project1.webservice.domain.posts.Posts;
import com.project1.webservice.repository.SpringDataJpaPostsRepository;
import com.project1.webservice.web.PostsSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private SpringDataJpaPostsRepository postsRepository;

    @AfterEach
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("서비스 로직 반환값확인")
    void serviceLogicTest() {

        PostsSaveRequestDto dto = PostsSaveRequestDto.builder().product("test1").price("10000").name("tony").build();

        postsService.save(dto);

        Posts post = postsRepository.findAll().get(0);

        System.out.println("post.getProduct() = " + post.getProduct());
        Assertions.assertThat(post.getProduct()).isEqualTo(dto.getProduct());

    }

    @Test
    @DisplayName("findByName에따른 API반환 확인")
    void serviceApiReturn(){

        PostsSaveRequestDto dto = PostsSaveRequestDto.builder().product("코코볼바").price("10000").name("tony").build();
        postsService.save(dto);

        Posts post = postsService.findOrder("tony").get();

        System.out.println("post.getProduct() = " + post.getProduct());
        Assertions.assertThat(dto.getProduct()).isEqualTo(post.getProduct());
    }
}
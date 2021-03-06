package com.project1.webservice.domain;

import com.project1.webservice.domain.posts.Posts;
import com.project1.webservice.repository.SpringDataJpaPostsRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    SpringDataJpaPostsRepository postsRepository;

    @AfterEach
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("저장된 게시물 확인")
    public void jpaRepoTest() {
        postsRepository.save(Posts.builder().product("제목").price("본문").name("작성자").build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);

        System.out.println("getProduct = " + posts.getProduct());
        System.out.println("getPrice = " + posts.getPrice());

        assertThat(posts.getProduct()).isEqualTo("제목");
        assertThat(posts.getPrice()).isEqualTo("본문");
    }

    @Test
    @DisplayName("BaseTimeEntity등록 확인")
    public void baseTimeTest(){

        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .product("test1")
                .price("10000")
                .name("광광맨")
                .build());

        List<Posts> postsList = postsRepository.findAll();
        Posts post = postsList.get(0);

        System.out.println("post.getCreatedDate() = " + post.getCreatedDate());
        System.out.println("post.getModifiedDate() = " + post.getModifiedDate());

        assertTrue(post.getCreatedDate().isAfter(now));
        assertTrue(post.getModifiedDate().isAfter(now));
        //??왜되는거지??
    }
}

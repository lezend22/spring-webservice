package com.project1.webservice.domain;

import com.project1.webservice.domain.posts.Posts;
import com.project1.webservice.domain.posts.PostsRepository;
import org.assertj.core.api.Assertions;
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
    PostsRepository postsRepository;

    @AfterEach
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("저장된 게시물 확인")
    public void jpaRepoTest() {
        postsRepository.save(Posts.builder().title("제목").content("본문").author("작성자").build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);

        System.out.println("postsTitle = " + posts.getTitle());
        System.out.println("postsContent = " + posts.getContent());

        assertThat(posts.getTitle()).isEqualTo("제목");
        assertThat(posts.getContent()).isEqualTo("본문");
    }

    @Test
    @DisplayName("BaseTimeEntity등록 확인")
    public void baseTimeTest(){

        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("지금몇신교?")
                .content("몇시인지확인해보자")
                .author("광광맨")
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

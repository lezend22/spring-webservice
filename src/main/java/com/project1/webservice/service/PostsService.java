package com.project1.webservice.service;

import com.project1.webservice.domain.posts.Posts;
import com.project1.webservice.repository.SpringDataJpaPostsRepository;
import com.project1.webservice.web.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostsService {

    private SpringDataJpaPostsRepository postsRepository;

    @Transactional
    public void save(PostsSaveRequestDto dto) {

        postsRepository.save(dto.toEntity());
    }

    public Optional<Posts> findOrder(String customerName){

        Optional<Posts> post = postsRepository.findByName(customerName);
        return post;
    }
}

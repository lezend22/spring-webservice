package com.project1.webservice.service;

import com.project1.webservice.domain.posts.PostsRepository;
import com.project1.webservice.web.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public void save(PostsSaveRequestDto dto) {

        postsRepository.save(dto.toEntity());
    }
}

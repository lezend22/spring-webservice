package com.project1.webservice.repository;

import com.project1.webservice.domain.posts.Posts;

import java.util.Optional;

public interface PostsRepository {

    Optional<Posts> findByName(String name);
}

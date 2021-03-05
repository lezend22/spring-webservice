package com.project1.webservice.repository;


import com.project1.webservice.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaPostsRepository extends JpaRepository<Posts, Long>, PostsRepository{

    @Override
    Optional<Posts> findByName(String name);
}

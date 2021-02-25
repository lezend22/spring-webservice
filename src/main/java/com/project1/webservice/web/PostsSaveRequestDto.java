package com.project1.webservice.web;

import com.project1.webservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//View역할을 위한 클래스 dto
@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Posts toEntity(){
        return Posts.builder().title(title).content(content).author(author).build();
    }

}

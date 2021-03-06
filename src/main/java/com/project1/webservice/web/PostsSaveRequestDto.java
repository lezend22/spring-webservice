package com.project1.webservice.web;

import com.project1.webservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//View역할을 위한 클래스 dto
//save역할을 맡아서함
@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String product;
    private String price;
    private String name;

    public Posts toEntity(){
        return Posts.builder().product(product).price(price).name(name).build();
    }

    @Builder
    public PostsSaveRequestDto(String product, String price, String name) {
        this.product = product;
        this.price = price;
        this.name = name;
    }
}

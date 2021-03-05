package com.project1.webservice.domain.posts;

import com.project1.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //column은 굳이 안써도됨 다만,기본값을 변경하고싶을때 사용
    @Column(length = 500, nullable = false)
    private String product;

    @Column(columnDefinition = "TEXT", nullable = false)
    private  String price;

    private String customerName;

    //생성자, build()형식의 인스턴스 생성가능, 파라미터가 많을때 사용
    @Builder
    public Posts(String product, String price, String customerName) {
        this.product = product;
        this.price = price;
        this.customerName = customerName;
    }
}

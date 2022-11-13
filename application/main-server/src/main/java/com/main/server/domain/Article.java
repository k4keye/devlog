package com.main.server.domain;

import com.main.server.domain.base.BaseStateEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "tb_article")
@Getter
public class Article extends BaseStateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Member author;


    @Column
    private String title;

    @Column
    private String content; //나중에 테이블로 분리(파일)

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "like_count")
    private Long likeCount;


    public void setAuthor(Member author) {
        this.author = author;
    }
}

package com.main.server.controller.dto.response;


import com.main.server.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleDto {
     private Long articleId;


     public ArticleDto(Article article) {

     }
}

package com.main.server.service;

import com.main.server.domain.Article;
import com.main.server.domain.Member;
import com.main.server.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article save(Member member,String title,String context) {

        Article article = new Article(title, context);
        member.appendArticle(article);
        return articleRepository.save(article);
    }

    public Article fetch(Long articleId){

        return articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalStateException("not exist product"));
    }

    public Page<Article> fetchPage(Pageable page){
        Page<Article> all = articleRepository.findAll(page);
        return all;
    }

}

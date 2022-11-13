package com.main.server.dummy;


import com.main.server.domain.Article;
import com.main.server.domain.repository.ArticleRepository;
import com.main.server.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class DummyArticle extends DummyMember{

    @Autowired
    private ArticleService articleService;


    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    EntityManager em;

    @BeforeEach
    public void createDummyArticle(){

        String articleName = "articleName";
        Article article ;

    }
}

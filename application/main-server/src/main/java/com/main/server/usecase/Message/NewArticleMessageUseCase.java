package com.main.server.usecase.Message;

import com.main.server.domain.Article;
import com.main.server.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewArticleMessageUseCase {
    private final KafkaTemplate<String,String> kafkaTemplate;

    private static final String TOPIC = "new-article";

    public void execute(Article article){
        this.kafkaTemplate.send(TOPIC, article.getTitle());
    }




}

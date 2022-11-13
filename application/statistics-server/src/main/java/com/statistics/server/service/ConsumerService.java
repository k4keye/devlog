package com.statistics.server.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final RedisTemplate<String, Integer> redisTemplate;

    private final RedisTemplate<String, String> redisRankTemplate;

    String key = "productRank";

    private static final String TOPIC = "new-article";

    @KafkaListener(topics = TOPIC)
    public void consume(String message) throws IOException {

        productOrderRankRedis(message);
    }


    public void productOrderRedis(String productName){

        ValueOperations<String, Integer> valueOperations = redisTemplate.opsForValue();

        Integer findRedis = valueOperations.get(productName);
        int oldCount = findRedis == null ? 0 : findRedis;
        valueOperations.set(productName, ++oldCount);
    }
    public void productOrderRankRedis(String productName){

        ZSetOperations<String, String> stringIntegerZSetOperations = redisRankTemplate.opsForZSet();
        stringIntegerZSetOperations.incrementScore(key,productName, 1);
    }

    public List<String> best5Rank(){

        ZSetOperations<String, String> stringIntegerZSetOperations = redisRankTemplate.opsForZSet();
        Set<String> range = stringIntegerZSetOperations.reverseRange(key, 0, 4);

        return range.stream().collect(Collectors.toList());
    }

}

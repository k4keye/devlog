package com.main.server.redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * author         : k4keye
 * date           : 2022/09/15
 * description    :
 */
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    void testStrings() {

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String key = "stringKey";

        valueOperations.set(key, "hello");

        String value = valueOperations.get(key);
        System.out.println("value = " + value);
        Assertions.assertEquals("hello",value);
    }
    @Test
    void testSet() {
        // given
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        String key = "setKey";

        // when
        setOperations.add(key, "h", "e", "l", "l", "o");

        // then
        Set<String> members = setOperations.members(key);
        Long size = setOperations.size(key);


        Assertions.assertEquals(4,size);

    }

    @Test
    void testHash() {
        // given
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        String key = "hashKey";

        // when
        hashOperations.put(key, "hello", "world");

        // then
        Object value = hashOperations.get(key, "hello");
        Assertions.assertEquals("world",value);


        Map<Object, Object> entries = hashOperations.entries(key);

        Optional<Object> hello = entries.keySet().stream().filter(o -> o.equals("hello"))
                .findFirst();

        Assertions.assertTrue(hello.isPresent());

        Optional<Object> world = entries.values().stream().filter(o -> o.equals("world"))
                .findFirst();

        Assertions.assertTrue(world.isPresent());

        Long size = hashOperations.size(key);
        Assertions.assertEquals(entries.size(),size);

    }
}

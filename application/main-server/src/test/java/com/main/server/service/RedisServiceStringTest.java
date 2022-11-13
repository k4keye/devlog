package com.main.server.service;

import com.main.server.service.outside.RedisService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisServiceStringTest {

    @Autowired
    RedisService redisService;

    @Test
    @DisplayName("redis string 저장")
    public void redisStringSave() throws InterruptedException {

        String key = "string-redis-key";
        String value = "string-redis-value";
        redisService.setStringOps(key,value,1, TimeUnit.SECONDS);

        String getValue = redisService.getStringOps(key);
        System.out.println("value = " + value);
        System.out.println("getValue = " + getValue);

        Assertions.assertEquals(value,getValue);

        String getValue2 = redisService.getStringOps(key);
        Assertions.assertNotNull(getValue2);

        //1초뒤에 다시 조회하면 없는 value.
        TimeUnit.SECONDS.sleep(1);
        String getNullValue = redisService.getStringOps(key);
        Assertions.assertNull(getNullValue);


    }

}
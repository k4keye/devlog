package com.main.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("[성공] 패스워드 암복호")
    void enDeCoder(){

        String pwd = "user";
        String encode = passwordEncoder.encode(pwd);
        System.out.println("encode = " + encode);
        Assertions.assertTrue(passwordEncoder.matches(pwd,encode));
    }
}

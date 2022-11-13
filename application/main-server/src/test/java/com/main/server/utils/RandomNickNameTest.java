package com.main.server.utils;


import org.junit.jupiter.api.Test;

public class RandomNickNameTest {

    @Test
    public void nickNameTest(){

        for(int i = 0 ; i< 100 ; i ++){
            String randomNickName = NickNameUtils.getInstance().getRandomNickName();

            System.out.println("randomNickName = " + randomNickName);
        }

    }
}

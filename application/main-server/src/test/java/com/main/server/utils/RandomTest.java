package com.main.server.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomTest {

    @Test
    public void randomNumberTest(){


        for(int i =0; i <100; i++){
            int number = RandomUtils.getSingleNumber(80, 100);

            Assertions.assertTrue(number <=100);
            Assertions.assertTrue(number >= 80);
        }
    }
}

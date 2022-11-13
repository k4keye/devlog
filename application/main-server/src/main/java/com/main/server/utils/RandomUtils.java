package com.main.server.utils;

import java.util.Random;

public class RandomUtils {

    public static String getString(boolean isNumber, int length){

        if(length < 10) length = 10;
        Random rnd =new Random();
        StringBuffer buf = new StringBuffer();

        for(int i = 0; i<length; i++) {
            //true 문자 , false 숫자
            if(isNumber == false || rnd.nextBoolean()){
                buf.append((char)((int)(rnd.nextInt(26))+97));
            }else{
                buf.append((rnd.nextInt(10)));
            }
        }
        return buf.toString();
    }

    public static String getNumber(int length){

        if(length < 10) length = 10;
        Random rnd =new Random();
        StringBuffer buf =new StringBuffer();

        for(int i = 0; i<length; i++) {
            buf.append((rnd.nextInt(10)));
        }
        return buf.toString();
    }

    public static int getSingleNumber(int minNumber, int maxNumber){

        Random rnd =new Random();

        int rang = maxNumber+1 - minNumber;
        return rnd.nextInt(rang) + minNumber;
    }

}
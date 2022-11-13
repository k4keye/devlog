package com.main.server.utils;

import java.util.List;


public class ProductNameUtils {

    private static ProductNameUtils instance ;

    public static ProductNameUtils getInstance(){
        if(instance == null) instance = new ProductNameUtils();

        return instance;
    }
    private  List<String> head;
    private  List<String> body;


    public ProductNameUtils() {

        this.head =  List.of("몸에좋은", "맛이 좋은", "쓴", "건강에 좋은", "키가 쑥쑥", "살이 빠지는", "아름 다운", "사고 싶은", "할인 하는");
        this.body = List.of("영양제", "양념장", "아몬드", "치킨", "팝콘", "유자차", "쑥","소세지","물건");

    }


    public String getRandomNickName(){


        String randomHead = this.head.get(RandomUtils.getSingleNumber(0, this.head.size()-1));
        String randomBody = this.body.get(RandomUtils.getSingleNumber(0, this.body.size()-1));

        return randomHead + "_" + randomBody + "_" + RandomUtils.getSingleNumber(1,100);
    }
}

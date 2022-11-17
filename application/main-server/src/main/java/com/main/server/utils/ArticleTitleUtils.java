package com.main.server.utils;

import java.util.List;


public class ArticleTitleUtils {

    private static ArticleTitleUtils instance ;

    public static ArticleTitleUtils getInstance(){
        if(instance == null) instance = new ArticleTitleUtils();

        return instance;
    }
    private  List<String> head;
    private  List<String> body;


    public ArticleTitleUtils() {

        this.head =  List.of("몸에좋은", "맛이 좋은", "쓴", "건강에 좋은", "키가 쑥쑥",
                            "살이 빠지는", "아름 다운", "사고 싶은", "할인 하는","에쁜",
                            "굉장한","눈부신","종이","필름","진짜","인기 있는", "핫한",
                            "차가운", "달콤한", "길거리");

        this.body = List.of("영양제", "양념장", "아몬드", "치킨", "팝콘", "유자차",
                            "쑥","소세지","물건","이름표","기차","자동차","약통",
                            "박스","상자","테이프","커터칼","가위","도마" ,"그릇",
                            "수저","포크","나이프","달력","책","치약","볼펜","연필",
                            "핸드폰","충전기","케이블","콘센트","레미콘","콘치즈","스티커");

    }


    public String getRandom(){


        String randomHead = this.head.get(RandomUtils.getSingleNumber(0, this.head.size()-1));
        String randomBody = this.body.get(RandomUtils.getSingleNumber(0, this.body.size()-1));

        return randomHead + "_" + randomBody + "_" + RandomUtils.getSingleNumber(1,100);
    }
}

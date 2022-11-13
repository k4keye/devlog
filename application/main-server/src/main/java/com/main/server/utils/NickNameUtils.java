package com.main.server.utils;

import java.util.List;


public class NickNameUtils {

    private static NickNameUtils instance ;

    public static NickNameUtils getInstance(){
        if(instance == null) instance = new NickNameUtils();

        return instance;
    }
    private  List<String> head;
    private  List<String> body;


    public NickNameUtils() {

        this.head =  List.of("열정적인", "따듯한", "차가운", "적극적인", "지나가던", "움직이던", "하늘을 보던","창의적인","흥미 있어 하는","매력적인","음악적인","유명한","단정한","시각적인");
        this.body = List.of("딸기", "포도", "레몬", "귤", "어묵", "사과", "바나나","키위","코코넛","자몽");

    }


    public String getRandomNickName(){


        String randomHead = this.head.get(RandomUtils.getSingleNumber(0, this.head.size()-1));
        String randomBody = this.body.get(RandomUtils.getSingleNumber(0, this.body.size()-1));

        return randomHead + "_" + randomBody + "_" + RandomUtils.getSingleNumber(1,100);
    }
}

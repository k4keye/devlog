package com.main.server.response;

import com.main.server.common.response.ResponseService;
import com.main.server.common.response.result.CollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;


public class CollectionResultTest {

    private ResponseService responseService = new ResponseService();
    @Test
    @DisplayName("collection list test")
    public void listTest(){

        List test = new ArrayList();
        test.add("a");
        test.add("b");
        test.add("c");
        CollectionResult collectionResult = responseService.getResult(test);
        System.out.println("collectionResult = " + collectionResult);
    }

    @Test
    @DisplayName("collection set test")
    public void setTest(){

        HashSet test = new LinkedHashSet();
        test.add("a");
        test.add("b");
        test.add("c");
        CollectionResult collectionResult = responseService.getResult(test);
        System.out.println("collectionResult = " + collectionResult);
    }
}

package com.main.server.controller;

import com.main.server.common.response.ResponseService;
import com.main.server.service.ExceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ResponseService responseService;
    private final ExceptionService exceptionService;

    @GetMapping("/publish")
    public String publish(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        this.kafkaTemplate.send("message-topic", generatedString);

        return "success";
    }

    @GetMapping("/exception1")
    public ResponseEntity exception1() throws Exception {

        exceptionService.BasicException();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseService.getSuccessResult());
    }
    @GetMapping("/exception2")
    public ResponseEntity exception2()  {

        exceptionService.BasicRuntimeException();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseService.getSuccessResult());
    }
    @GetMapping("/exception3")
    public ResponseEntity exception3()  {

        exceptionService.BasicIllegalStateException();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseService.getSuccessResult());
    }
    @GetMapping("/exception4")
    public ResponseEntity exception4() throws IllegalAccessException {

        exceptionService.BasicIllegalAccessException();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseService.getSuccessResult());
    }


}

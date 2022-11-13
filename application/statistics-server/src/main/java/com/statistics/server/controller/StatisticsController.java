package com.statistics.server.controller;

import com.statistics.server.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {

    private final ConsumerService consumerService;

    @GetMapping("/best")
    public ResponseEntity bast5Product(){

        List<String> strings = consumerService.best5Rank();
        return ResponseEntity.status(HttpStatus.OK).body(strings);
    }
}

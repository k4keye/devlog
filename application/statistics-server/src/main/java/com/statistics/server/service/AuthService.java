package com.statistics.server.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${spring.main-server.url}")
    private String authServerUrl;


    public Long getAuthMemberId(String token) throws IllegalAccessException {

        if(token == null || token == "" || ! token.startsWith("Bearer"))  throw new IllegalAccessException("not valid access token");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",token);

        HttpEntity<String> entity = new HttpEntity<String>("", headers);

        ResponseEntity<Long> exchange = restTemplate.exchange(authServerUrl+"/auth", HttpMethod.GET, entity, Long.class);

        Long memberId = exchange.getBody();
        System.out.println("member id = " + memberId);

        return memberId;
    }


}

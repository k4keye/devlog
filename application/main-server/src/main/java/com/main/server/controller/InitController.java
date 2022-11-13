package com.main.server.controller;

import com.main.server.domain.value.Address;
import com.main.server.service.member.LoginService;
import com.main.server.utils.RandomUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/init")
public class InitController {

    private final LoginService loginService;

    @GetMapping("/first")
    public ResponseEntity initFirst(){

        initMembers(100L);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/member/{count}")
    public ResponseEntity initMembers(@PathVariable Long count){

        for(int i = 0 ; i <count ; i ++){
            String id = RandomUtils.getString(true, 5);
            String pwd = RandomUtils.getString(true, 10);
            String email = RandomUtils.getString(true, 5) + "@random.com";
            String city = RandomUtils.getString(false, 7);
            String street = RandomUtils.getString(false, 7);
            String zipcode = RandomUtils.getNumber(5);

            Address address = new Address(city,street,zipcode);
            loginService.join(id, pwd, email, address);
        }


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}

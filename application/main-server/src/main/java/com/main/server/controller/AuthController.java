package com.main.server.controller;


import com.main.server.domain.Member;
import com.main.server.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity getTokenUserId(){
        Member authMember = memberService.getAuthMember();
        System.out.println("authMember = " + authMember);

        return ResponseEntity.status(HttpStatus.OK).body(authMember.getId());
    }
}

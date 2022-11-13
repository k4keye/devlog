package com.main.server.controller;

import com.main.server.common.response.ResponseService;
import com.main.server.common.response.result.LinksResult;
import com.main.server.common.response.result.SingleResult;
import com.main.server.controller.dto.request.JoinRequest;
import com.main.server.controller.dto.response.MemberDto;
import com.main.server.domain.Member;
import com.main.server.domain.value.Address;
import com.main.server.service.member.LoginService;
import com.main.server.usecase.login.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    private final ResponseService responseService;
    @GetMapping
    public ResponseEntity login(@RequestParam("id") String id, @RequestParam("pwd") String pwd){

        String token = loginService.login(id, pwd);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("token", "Bearer "+token);

        SingleResult<HashMap<String, String>> responseBody = responseService.getResult(map);

        List<LinksResult> links = new ArrayList<>();
        links.add(new LinksResult("echo","/echo"));

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @PostMapping("/join")
    public ResponseEntity join(@Valid @RequestBody JoinRequest joinRequest){

        Address address = new Address(joinRequest.getCity(), joinRequest.getStreet(), joinRequest.getZipcode());
        Member member = loginService.join(joinRequest.getId(), joinRequest.getPwd(),  joinRequest.getEmail(),address);
        MemberDto memberDto = new MemberDto(member);

        List<LinksResult> links = new ArrayList<>();
        links.add(new LinksResult("login","/login"));

        SingleResult<MemberDto> responseBody = responseService.getResult(memberDto,links);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }
}

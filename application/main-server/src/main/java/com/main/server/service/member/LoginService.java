package com.main.server.service.member;

import com.main.server.domain.Member;
import com.main.server.domain.value.Address;
import com.main.server.usecase.login.JoinUseCase;
import com.main.server.usecase.login.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {


    private final LoginUseCase loginUseCase;
    private final JoinUseCase joinUseCase;
    public String login(String id, String pwd){

        return loginUseCase.execute(id,pwd);
    }


    public Member join(String id, String pwd, String email, Address address){

        return joinUseCase.execute(id,pwd,email,address);
    }
}

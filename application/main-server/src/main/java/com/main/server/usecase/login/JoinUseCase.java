package com.main.server.usecase.login;

import com.main.server.domain.Member;
import com.main.server.domain.value.Address;
import com.main.server.service.member.MemberService;
import com.main.server.utils.NickNameUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinUseCase {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;



    public Member execute(String id, String pwd, String email, Address address){

        if(memberService.existLoginId(id))
            throw new IllegalStateException("exist member login id");

        String nickName = NickNameUtils.getInstance().getRandomNickName();
        if(memberService.existNickName(nickName))
            throw new IllegalStateException("exist member nickName");

        String encodePwd = passwordEncoder.encode(pwd);
        return memberService.saveMember(id,encodePwd,nickName,email,address);
    }
}

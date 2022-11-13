package com.main.server.dummy;

import com.main.server.domain.Member;
import com.main.server.domain.value.Address;
import com.main.server.service.member.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class DummyMember {

    @Autowired
    private LoginService loginService;
    public static String loginId = "loginTest";

    private String loginPwd = "loginPwd";
    private String nickName = "nickname";
    private String email = "email@naver.com";

    @BeforeEach
    public void createDummyMember(){
        Address address = new Address("city", "street", "zipcode");
        Member saveMember = loginService.join(loginId, loginPwd, email,address);
        Assertions.assertNotNull(saveMember);
    }
}

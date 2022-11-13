package com.main.server.controller.dto.response;


import com.main.server.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberDto {

    private String id;
    private String nickName;
    private String email;

    public MemberDto(Member member) {
        this.id = member.getLoginID();
        this.nickName = member.getNickName();
        this.email = member.getEmail();
    }
}

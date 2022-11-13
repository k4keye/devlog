package com.main.server.service.member;

import com.main.server.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberPatchService {
    private final MemberService memberService;

    @Transactional
    @CachePut(value = "Member", key = "#member.loginID")
    public Member patch(Member member, String op, String path, String value){

        if(op.equals("replace")){
            return replaceOp(member,path,value);
        }
        if(op.equals("add")){
            return addOp(member,path,value);
        }
        if(op.equals("remove")){
            return removeOp(member,path,value);
        }

        throw new IllegalArgumentException();
    }

    private Member replaceOp(Member member,String path, String value){

        if(path.equals("email")){
            member.changeEmail(value);
            return member;
        }

        if(path.equals("nickName")){
            member.changeNickName(value);
            return member;
        }
        return member;
    }
    private Member addOp(Member member,String path, String value){
        return member;
    }
    private Member removeOp(Member member,String path, String value){
        return member;
    }
}

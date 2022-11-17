package com.main.server.redis;

import com.main.server.domain.Member;
import com.main.server.domain.repository.MemberRepository;
import com.main.server.service.member.MemberService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@SpringBootTest
@Transactional
public class RedisCacheTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void createDummyMember(){
        System.out.println("init member ");

        int createMemberCount = 10;

        for ( int i = 0 ; i <createMemberCount ; i ++){
            //memberRepository.save(new Member(new LoginID("id"+i),"pwd"+i,new NickName("nick"+i),new Email("email"+i)));
        }

        em.flush();
        em.clear();
    }

    @Test
    public void findTest(){

        // db test
        long startTimeOrigin = System.currentTimeMillis();
        System.out.println(findMemberOrigin("id1"));
        System.out.println(findMemberOrigin("id2"));
        System.out.println(findMemberOrigin("id3"));
        System.out.println(findMemberOrigin("id4"));
        System.out.println(findMemberOrigin("id5"));

        long endTimeOrigin = System.currentTimeMillis();

        System.out.println("end db find  = " + (endTimeOrigin - startTimeOrigin));

        //redis one test
        long startTime = System.currentTimeMillis();
        System.out.println(memberService.fetchMember("id1"));
        System.out.println(memberService.fetchMember("id2"));
        System.out.println(memberService.fetchMember("id3"));
        System.out.println(memberService.fetchMember("id4"));
        System.out.println(memberService.fetchMember("id5"));

        long endTime = System.currentTimeMillis();

        System.out.println("end cache find  = " + (endTime - startTime));


        //redis two test
        long startTime2 = System.currentTimeMillis();
        System.out.println(memberService.fetchMember("id1"));
        System.out.println(memberService.fetchMember("id2"));
        System.out.println(memberService.fetchMember("id3"));
        System.out.println(memberService.fetchMember("id4"));
        System.out.println(memberService.fetchMember("id5"));

        long endTime2 = System.currentTimeMillis();

        System.out.println("end cache find2  = " + (endTime2 - startTime2));

        Assertions.assertTrue((endTime2 - startTime2) < (endTimeOrigin - startTimeOrigin));
    }


    private Member findMemberOrigin(String loginId){
        return memberRepository
                .findByLoginID(loginId)
                .orElseThrow(() -> new IllegalStateException("not exist member"));
    }
}

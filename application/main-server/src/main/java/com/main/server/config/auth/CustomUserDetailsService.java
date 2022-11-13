package com.main.server.config.auth;

import com.main.server.domain.repository.MemberRepository;
import com.main.server.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String loginId) {

        User user = memberRepository.findOneWithAuthoritiesByLoginID(loginId)
                .map(member -> createMember(member))
                .orElseThrow(() -> new UsernameNotFoundException(loginId + " 에 해당하는 member 이 없다"));

        System.out.println("loadUserByUsername user = " + user.getUsername());

        return user;
    }

    private User createMember(Member member) {

        List<GrantedAuthority> grantedAuthorities = member.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());


        User user = new User(member.getLoginID(),
                member.getLoginPWD(),
                grantedAuthorities);

        return user;
    }
}
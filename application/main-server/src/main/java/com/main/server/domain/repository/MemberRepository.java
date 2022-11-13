package com.main.server.domain.repository;

import com.main.server.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<Member> findOneWithAuthoritiesByLoginID(String loginID);


    boolean existsByLoginID(String loginId);
    boolean existsByNickName(String nickName);

    Optional<Member> findByLoginID(String loginId);
}

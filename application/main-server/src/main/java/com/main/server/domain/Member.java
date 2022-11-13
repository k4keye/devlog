package com.main.server.domain;


import com.main.server.domain.base.BaseTimeEntity;
import com.main.server.domain.value.Address;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Getter
@ToString(exclude = {"authorities"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_MEMBER")
public class Member extends BaseTimeEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "login_id")
    private String loginID;

    @Column(name = "login_pwd")
    private String loginPWD;

    @Column
    private String nickName;

    @Column
    private String email;

    @Embedded
    private Address address;



    @OneToMany(mappedBy = "author")
    private List<Article> articles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "tb_member_authority",
            joinColumns = {@JoinColumn(name = "login_id", referencedColumnName = "login_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")}
    )
    private Set<Authority> authorities = new HashSet<>();


    public Member(String loginID, String loginPWD, String nickName, String email,  Address address) {
        this.loginID = loginID;
        this.loginPWD = loginPWD;
        this.nickName = nickName;
        this.email = email;
        this.address = address;

        Authority authority = Authority.userAuth();
        this.authorities.add(authority);
    }



    public String getEmail() {
        return email;
    }

    public String getLoginID() {
        return loginID;
    }

    public String getNickName(){
        return nickName;
    }



    public boolean isAdmin(){

        Optional<Authority> first = this.authorities.stream()
                .filter(Authority::isAdmin)
                .findFirst();

        return first.isPresent();
    }

    public void appendArticle(Article article){
        this.getArticles().add(article);
        article.setAuthor(this);
    }
    public void changeEmail(String newEmail){
        this.email = newEmail;
    }

    public void changeNickName(String newNickName){
        this.nickName = newNickName;
    }

    public void changeAddress(Address address){
        this.address = address;
    }

}

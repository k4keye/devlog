package com.main.server.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TB_AUTHORITY")
@NoArgsConstructor
@Getter
@ToString
public class Authority implements Serializable {
    @Id
    @Column(name = "authority_name", length = 50)
    private String authorityName;


    public Authority(String authorityName) {
        this.authorityName = authorityName;
    }

    public static Authority userAuth(){

        Authority authority = new Authority("ROLE_USER");
        return authority;
    }

    public static Authority adminAuth(){

        Authority authority = new Authority("ROLE_ADMIN");
        return authority;
    }

    public boolean isAdmin(){
        return this.authorityName.equals("ROLE_ADMIN");
    }

}
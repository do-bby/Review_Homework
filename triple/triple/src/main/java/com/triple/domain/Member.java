package com.triple.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "member")
@Getter
@Setter

public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private Long point;

    @NotBlank(message = "아이디를 입력하세요")
    //@Pattern(regexp = "^[a-zA-Z0-9]{3,12}&", message="3~12자로 입력해주세요")
    private String username;

    @NotBlank(message = "비밀번호를 입력하세요")
    //@Pattern(regexp = "^[a-zA-Z0-9]{3,12}&", message="3~12자로 입력해주세요")
    private String password;
    //@JsonBackReference
    //@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //private List<Review> review;


    @Builder
    public Member(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Member(){}
}

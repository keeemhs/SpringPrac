package com.example.member.memberManage.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id;
    private String username;
    private String password;
    private String email;
}

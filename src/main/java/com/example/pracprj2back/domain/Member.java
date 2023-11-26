package com.example.pracprj2back.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private String id;
    private String password;
    private String nickName;
    private String email;
    private LocalDateTime inserted;
}






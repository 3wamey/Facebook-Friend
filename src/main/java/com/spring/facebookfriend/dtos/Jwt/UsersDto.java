package com.spring.facebookfriend.dtos.Jwt;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsersDto {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private List<Long> roleIds;
}

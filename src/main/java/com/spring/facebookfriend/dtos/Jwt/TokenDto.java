package com.spring.facebookfriend.dtos.Jwt;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    private String token;
    private List<String> roles;


}

package com.spring.facebookfriend.dtos.Jwt;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RolesDto {
    private Long id;
    private String code;
    private List<Long> userIds;
}

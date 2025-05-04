package com.spring.facebookfriend.service.Jwt;

import com.spring.facebookfriend.dtos.Jwt.TokenDto;
import com.spring.facebookfriend.dtos.Jwt.UserLoginDto;
import jakarta.transaction.SystemException;

public interface AuthService {
    TokenDto login(UserLoginDto userLoginDto) throws SystemException;
}

package com.spring.facebookfriend.service.Jwt;

import com.spring.facebookfriend.dtos.Jwt.UsersDto;
import com.spring.facebookfriend.model.jwt.Users;
import jakarta.transaction.SystemException;

public interface UserService {

    Users getUserByEmail(String email) throws SystemException;

    Users checkUserExistByToken(String token) throws SystemException;

    void createUser(UsersDto usersDto) throws SystemException;

    UsersDto getUserById(Long id) throws SystemException;
}

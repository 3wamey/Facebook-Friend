package com.spring.facebookfriend.mapper.Jwt;

import com.spring.facebookfriend.dtos.Jwt.UsersDto;
import com.spring.facebookfriend.model.jwt.Users;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
        UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

//        @Mapping(target = "roles", ignore = true)
//        Users toEntity(UsersDto dto);

        UsersDto toDto(Users user);

//        @InheritInverseConfiguration
        @Mapping(target = "roles", ignore = true) // Set manually if needed
        Users toEntity(UsersDto userDto);

        List<UsersDto> toDtoList(List<Users> users);


        }


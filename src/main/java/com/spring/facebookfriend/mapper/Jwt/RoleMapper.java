package com.spring.facebookfriend.mapper.Jwt;

import com.spring.facebookfriend.dtos.Jwt.RolesDto;
import com.spring.facebookfriend.model.jwt.Roles;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper ROLE_MAPPER= Mappers.getMapper(RoleMapper.class);


    RolesDto toDto(Roles role);

    @InheritInverseConfiguration
    @Mapping(target = "users", ignore = true) // Set manually if needed
    Roles toEntity(RolesDto roleDto);

    List<RolesDto> toDtoList(List<Roles> roles);

}

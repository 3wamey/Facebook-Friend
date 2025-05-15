package com.spring.facebookfriend.mapper;

import com.spring.facebookfriend.dtos.ReactDto;
import com.spring.facebookfriend.model.React;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface ReactMapper {

    ReactMapper INSTANCE = Mappers.getMapper(ReactMapper.class);

    ReactDto toDto(React react);

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)    // set manually in service if needed
    @Mapping(target = "comments", ignore = true) // set manually in service if needed
    React toEntity(ReactDto dto);

    List<ReactDto> toDtoList(List<React> reactList);

    List<React> toEntityList(List<ReactDto> dtoList);
}

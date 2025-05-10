package com.spring.facebookfriend.mapper;

import com.spring.facebookfriend.dtos.ContactUsDto;
import com.spring.facebookfriend.model.ContactUs;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactUsMapper {


        ContactUsMapper INSTANCE = Mappers.getMapper(ContactUsMapper.class);

        @Mapping(source = "user.id", target = "clientId")
        ContactUsDto toDto(ContactUs contactUs);

        @InheritInverseConfiguration
        @Mapping(target = "user", ignore = true) // manually set it if needed later
        ContactUs toEntity(ContactUsDto dto);

        List<ContactUsDto> toDtoList(List<ContactUs> contactUsList);

        List<ContactUs> toEntityList(List<ContactUsDto> dtoList);
    }




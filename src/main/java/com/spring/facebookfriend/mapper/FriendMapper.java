package com.spring.facebookfriend.mapper;

import com.spring.facebookfriend.dtos.FriendsDto;
import com.spring.facebookfriend.model.Friends;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FriendMapper {
    FriendMapper INSTANCE = Mappers.getMapper(FriendMapper.class);

    @Mapping(source = "user.id", target = "userId")
    FriendsDto toDto(Friends friend);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true) // Set manually in service
    Friends toEntity(FriendsDto dto);

    List<FriendsDto> toDtoList(List<Friends> friendsList);

    List<Friends> toEntityList(List<FriendsDto> dtoList);
}

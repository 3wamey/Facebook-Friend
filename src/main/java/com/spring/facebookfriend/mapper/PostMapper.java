package com.spring.facebookfriend.mapper;

import com.spring.facebookfriend.dtos.PostDto;
import com.spring.facebookfriend.model.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);


    PostDto toDto(Post post);

   // handled separately
    Post toEntity(PostDto dto);

    List<PostDto> toDtoList(List<Post> posts);

    List<Post> toEntityList(List<PostDto> postDtos);
}

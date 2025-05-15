package com.spring.facebookfriend.mapper;

import com.spring.facebookfriend.dtos.CommentDto;
import com.spring.facebookfriend.model.Comment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);


    CommentDto toDto(Comment comment);


    Comment toEntity(CommentDto dto);

    List<CommentDto> toDtoList(List<Comment> comments);

    List<Comment> toEntityList(List<CommentDto> commentDtos);
}

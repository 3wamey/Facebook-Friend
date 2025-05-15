package com.spring.facebookfriend.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String text;
    private Long postId;                // Reference to the parent post
    private List<Long> reactionIds;     // List of react IDs
}
package com.spring.facebookfriend.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostDto {
    private Long id;
    private String text;
    private String image;
    private Long friendId;                // FK to Friends
    private List<Long> reactionIds;       // List of reaction IDs
}

package com.spring.facebookfriend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class React {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @ManyToMany(mappedBy = "reactions")
    private List<Post> posts = new ArrayList<>();

    @ManyToMany(mappedBy = "reactions")
    private List<Comment> comments = new ArrayList<>();


}

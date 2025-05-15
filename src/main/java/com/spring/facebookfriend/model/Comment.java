package com.spring.facebookfriend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;


    @ManyToOne
    @JoinColumn(name = "post_id") // foreign key in Comment table
    private Post post;



    @ManyToMany
    @JoinTable(
            name = "comment_react",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "react_id")
    )
    private List<React> reactions = new ArrayList<>();

}

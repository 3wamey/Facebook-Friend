package com.spring.facebookfriend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String Image;

    @ManyToOne
    @JoinColumn(name = "friend_id") // foreign key column in `post` table
    private Friends friend;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "post_react",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "react_id")
    )
    private List<React> reactions = new ArrayList<>();


}

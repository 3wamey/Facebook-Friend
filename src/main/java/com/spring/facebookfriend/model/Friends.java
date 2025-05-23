package com.spring.facebookfriend.model;

import com.spring.facebookfriend.model.jwt.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
   private String email;
   private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

}

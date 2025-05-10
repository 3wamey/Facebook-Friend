package com.spring.facebookfriend.model;

import com.spring.facebookfriend.model.jwt.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContactUs {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String subject;
    @Column(length = 1000)
    private String message;

    @ManyToOne()
    @JoinColumn(name ="User_id")
    private Users user;
}

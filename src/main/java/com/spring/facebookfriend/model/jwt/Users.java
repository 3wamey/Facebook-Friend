package com.spring.facebookfriend.model.jwt;


import com.spring.facebookfriend.model.ContactUs;
import com.spring.facebookfriend.model.Friends;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Users extends UsersBaseEntity {

    private String name;
    private String email;
    private String phoneNumber;
    private String password;


    @ManyToMany
    @JoinTable(
            name = "user_roles", // name of the join table
            joinColumns = @JoinColumn(name = "user_id"), // FK to Users
            inverseJoinColumns = @JoinColumn(name = "role_id") // FK to Roles
    )
    private List<Roles> roles = new ArrayList<>();




    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ContactUs> contactus = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Friends> friends = new ArrayList<>();

}

package com.spring.facebookfriend.model.jwt;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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


}

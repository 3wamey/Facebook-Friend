package com.spring.facebookfriend.model.jwt;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Roles  extends UsersBaseEntity {

    private String code;


    @ManyToMany(mappedBy = "roles")
    private List<Users> users = new ArrayList<>();
}

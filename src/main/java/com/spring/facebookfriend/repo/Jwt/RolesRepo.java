package com.spring.facebookfriend.repo.Jwt;

import com.spring.facebookfriend.model.jwt.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Long> {
  Roles findByCode(String code);
}

package com.spring.facebookfriend.repo.Jwt;

import com.spring.facebookfriend.model.jwt.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users,Long> {
  Users findByEmail (String email);

  @Query("SELECT u FROM Users u LEFT JOIN FETCH u.roles WHERE u.email = :email")
  Users findByEmailWithRoles(@Param("email") String email);

}

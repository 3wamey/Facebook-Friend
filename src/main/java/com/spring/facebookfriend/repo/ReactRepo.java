package com.spring.facebookfriend.repo;

import com.spring.facebookfriend.model.React;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactRepo extends JpaRepository<React,Long> {

}

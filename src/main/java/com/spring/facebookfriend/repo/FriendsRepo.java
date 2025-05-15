package com.spring.facebookfriend.repo;

import com.spring.facebookfriend.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepo extends JpaRepository<Friends,Long> {

}

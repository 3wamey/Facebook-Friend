package com.spring.facebookfriend.repo;

import com.spring.facebookfriend.model.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo  extends JpaRepository<ContactUs,Long> {


}

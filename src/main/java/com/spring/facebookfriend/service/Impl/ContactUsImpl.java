package com.spring.facebookfriend.service.Impl;

import com.spring.facebookfriend.dtos.ContactUsDto;
import com.spring.facebookfriend.mapper.ContactUsMapper;
import com.spring.facebookfriend.model.ContactUs;
import com.spring.facebookfriend.model.jwt.Users;
import com.spring.facebookfriend.repo.ContactRepo;
import com.spring.facebookfriend.repo.Jwt.UsersRepo;
import com.spring.facebookfriend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactUsImpl implements ContactService {


    @Autowired
    private ContactRepo contactRepo;
    @Autowired
    private UsersRepo usersRepo;

    @Override
    public void sendMessage(ContactUsDto contactUsDto) {
        ContactUs contactUs = ContactUsMapper.INSTANCE.toEntity(contactUsDto);
        if (contactUsDto.getUserId() != null) {
            Optional<Users> usersOptional = usersRepo.findById(contactUsDto.getUserId());
            usersOptional.ifPresent(contactUs::setUser); // set client in the entity
        }
        contactRepo.save(contactUs);
    }




}

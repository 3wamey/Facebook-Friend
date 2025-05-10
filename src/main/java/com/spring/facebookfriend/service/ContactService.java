package com.spring.facebookfriend.service;

import com.spring.facebookfriend.dtos.ContactUsDto;

public interface ContactService {

    void sendMessage(ContactUsDto contactUsDto);

}

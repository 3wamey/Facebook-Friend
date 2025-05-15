package com.spring.facebookfriend.controller;

import com.spring.facebookfriend.dtos.ContactUsDto;
import com.spring.facebookfriend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactUsController {


    @Autowired
    private ContactService contactService;

    @PostMapping("/send")
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> sendMessage(@RequestBody ContactUsDto contactUsDto) {
        contactService.sendMessage(contactUsDto);
        return ResponseEntity.ok("Message sent successfully.");
    }
}

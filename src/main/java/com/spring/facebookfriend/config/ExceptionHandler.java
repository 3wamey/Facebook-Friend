package com.spring.facebookfriend.config;


import com.spring.facebookfriend.dtos.Bundelmessage.ExceptionResponseDto;
import com.spring.facebookfriend.service.BundelMessages.BundleTranslatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.ok(new ExceptionResponseDto(HttpStatus.NO_CONTENT, BundleTranslatorService.getBundleMessageinEnglishAndArabic(ex.getMessage())));

    }

}

package com.spring.facebookfriend.util;


import java.util.UUID;

public class UserCode {



    public static String extractCode(){
        return UUID.randomUUID().toString();
    }

    public static String generateCode(Integer count, String userName){
        return userName + " - " + count;
    }
}

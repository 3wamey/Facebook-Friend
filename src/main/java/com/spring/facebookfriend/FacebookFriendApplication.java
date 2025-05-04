package com.spring.facebookfriend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties
public class FacebookFriendApplication {

    public static void main(String[] args) {

        SpringApplication.run(FacebookFriendApplication.class, args);
    }

}

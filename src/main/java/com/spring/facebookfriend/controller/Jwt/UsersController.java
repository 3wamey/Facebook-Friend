package com.spring.facebookfriend.controller.Jwt;


import com.spring.facebookfriend.dtos.Jwt.TokenDto;
import com.spring.facebookfriend.dtos.Jwt.UserLoginDto;
import com.spring.facebookfriend.dtos.Jwt.UsersDto;
import com.spring.facebookfriend.service.Jwt.AuthService;
import com.spring.facebookfriend.service.Jwt.UserService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody  UserLoginDto userLoginDto) throws SystemException {
        TokenDto token = authService.login(userLoginDto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody  UsersDto usersDto) throws SystemException {
        userService.createUser(usersDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

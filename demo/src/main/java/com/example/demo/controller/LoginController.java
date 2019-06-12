package com.example.demo.controller;

import com.example.demo.entity.UserLogin;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value="/login")
    public ResponseEntity<UserLogin> register(@RequestBody UserLogin userLogin){
        if(loginService.existsUser(userLogin) ) {
            return ResponseEntity.ok().build();
        }else
            return (ResponseEntity<UserLogin>) ResponseEntity.badRequest();
    }
}

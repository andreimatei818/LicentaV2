package com.example.demo.controller;


import com.example.demo.entity.UserRegister;
import com.example.demo.service.RegisterService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.jws.soap.SOAPBinding;


@CrossOrigin(origins = "*")
@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(value="/register")
    public ResponseEntity<UserRegister> register(@RequestBody UserRegister userRegister){
        if(registerService.registerUser(userRegister) ) {
            return ResponseEntity.ok().build();
        }else
            return (ResponseEntity<UserRegister>) ResponseEntity.badRequest();
    }


}

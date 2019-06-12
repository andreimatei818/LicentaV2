package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRegister;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.utile.RowMapperUserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private UserRepository userRepository;


    public boolean registerUser(UserRegister userRegister) {
        if ( registerRepository.verifyIfExists(userRegister).isEmpty()) {
            userRegister.generatePassword(userRegister.getPassword());
            User user= RowMapperUserRegister.convertToModel(userRegister);
            userRepository.save(user);
            return true;
        }

        return false;
    }


}


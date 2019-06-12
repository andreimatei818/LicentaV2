package com.example.demo.service;

import com.example.demo.entity.UserLogin;
import com.example.demo.entity.UserRegister;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    public boolean existsUser(UserLogin userLogin) {
        UserRegister userRegister = new UserRegister();
        userRegister.setUsername(userLogin.getUsername());
        userRegister.generatePassword(userLogin.getPassword());

        if ( loginRepository.verifyIfExistsAndReturn(userRegister).isEmpty() ) {
            return false;
        }else {
            return true;
        }
    }
}

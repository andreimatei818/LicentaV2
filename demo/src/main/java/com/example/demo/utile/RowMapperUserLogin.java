package com.example.demo.utile;

import com.example.demo.entity.UserLogin;
import com.example.demo.entity.UserRegister;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperUserLogin implements RowMapper<UserLogin> {
    @Override
    public UserLogin mapRow(ResultSet resultSet, int i) throws SQLException {
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(resultSet.getString("username"));
        userLogin.setPassword(resultSet.getString("password"));
        return userLogin;
    }
}

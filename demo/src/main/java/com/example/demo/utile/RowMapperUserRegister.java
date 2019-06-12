package com.example.demo.utile;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRegister;
import org.springframework.jdbc.core.RowMapper;

import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperUserRegister implements RowMapper<UserRegister> {
    @Override
    public UserRegister mapRow(ResultSet resultSet, int i) throws SQLException {
        UserRegister userRegister = new UserRegister();
        userRegister.setUsername(resultSet.getString("username"));
        userRegister.setFirstName(resultSet.getString("firstName"));
        userRegister.setLastName(resultSet.getString("lastName"));
        userRegister.setPassword(resultSet.getString("password"));
        userRegister.setEmail(resultSet.getString("email"));
        userRegister.setCarNumber(resultSet.getString("carNumber"));
        userRegister.setPhone(resultSet.getString("phone"));
        return userRegister;
    }
    public static User convertToModel(UserRegister userRegister)  {
        User user= new User();
        user.setCarNumber(userRegister.getCarNumber());
        user.setEmail(userRegister.getEmail());
        user.setFirstName(userRegister.getFirstName());
        user.setPhone(userRegister.getPhone());
        user.setLastName(userRegister.getLastName());
        user.setUsername(userRegister.getUsername());
        user.setPassword(userRegister.getPassword());

        return user;
    }
}

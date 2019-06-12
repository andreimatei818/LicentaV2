package com.example.demo.repository;

import com.example.demo.entity.UserRegister;
import com.example.demo.utile.RowMapperUserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LoginRepository {
    @Autowired
    JdbcTemplate jdbcTemplate ;

    public List<UserRegister> verifyIfExistsAndReturn(UserRegister userRegister) {
        return jdbcTemplate.query("select * from users where username=? and password=?",
                new BeanPropertyRowMapper(UserRegister.class),userRegister.getUsername(),
                                                              userRegister.getPassword());
    }


}

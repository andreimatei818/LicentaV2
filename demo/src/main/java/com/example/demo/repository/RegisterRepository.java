package com.example.demo.repository;


import com.example.demo.entity.ReservedParking;
import com.example.demo.entity.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RegisterRepository {

    @Autowired
    JdbcTemplate jdbcTemplate ;


    public void addUser(UserRegister userRegister) {
            jdbcTemplate.update("insert into users(id,username,firstName,lastName,email,password,phone,carNumber)" +
                            " values (?,?,?,?,?,?,?,?)",
                    null,
                    userRegister.getUsername(),
                    userRegister.getFirstName(),
                    userRegister.getLastName(),
                    userRegister.getEmail(),
                    userRegister.getPassword(),
                    userRegister.getPhone(),
                    userRegister.getCarNumber()

            );

    }


    public List<UserRegister> verifyIfExists(UserRegister userRegister) {
        return jdbcTemplate.query("select * from users where username=? or carNumber=?",
                new BeanPropertyRowMapper(UserRegister.class),userRegister.getUsername(),userRegister.getCarNumber());
    }

    public List<ReservedParking> getReservedParking(int id){
        return  jdbcTemplate.query("select p.address,r.start_date,r.end_date from users u join parking p on u.id=? \n" +
                "join reservation r on r.id_parking=p.id",new BeanPropertyRowMapper(ReservedParking.class),id);
    }


}

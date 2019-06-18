package com.example.demo.service;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRegister;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.utile.RowMapperUserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {


    @Autowired
    private ReservationRepository reservationRepository;


    public Reservation  reservation(Reservation reservation) {
        return reservationRepository.save(reservation);

    }
}

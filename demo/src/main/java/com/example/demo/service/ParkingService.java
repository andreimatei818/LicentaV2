package com.example.demo.service;

import com.example.demo.entity.Parking;
import com.example.demo.entity.User;
import com.example.demo.repository.ParkingRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParkingRepository parkingRepository;

    public Parking add(Parking parking) {
            User user = userRepository.findByUsername(parking.getUsername());
            parking.setUser(user);
            return parkingRepository.save(parking);
    }

    public Optional<List<Parking>> getListParkingByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return parkingRepository.getAllParkingByUserId(user.getId());
    }
}

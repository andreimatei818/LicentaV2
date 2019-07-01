package com.example.demo.service;

import com.example.demo.entity.Parking;
import com.example.demo.entity.ParkingTwoDate;
import com.example.demo.entity.User;
import com.example.demo.repository.ParkingRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

  public Parking add(ParkingTwoDate parking) {
            User user = userRepository.findByUsername(parking.getParking().getUsername());
                parking.getParking().setUser(user);
                if(
                        parking.getInitialStartDate().isBefore(parking.getParking().getStartDate()) &&
                        parking.getInitialEndDate().isAfter(parking.getParking().getEndDate())
                  ){

                }
            return parkingRepository.save(parking.getParking());
    }

    public Optional<List<Parking>> getListParkingByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return parkingRepository.getAllParkingByUserId(user.getId());
    }

//    public Optional<Parking> deleteParkingRegistred(String address, String username) {
//        User user = userRepository.findByUsername(username);
//         Parking parking=parkingRepository.getParkingByAddress(address,user.getId(),);
//         parkingRepository.delete(parking);
//         return Optional.ofNullable(parking);
//    }

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

        public Optional<Parking> deleteParkingRegistred(String address, String username,String startDate, String endDate) {
            User user = userRepository.findByUsername(username);

             Parking parking=parkingRepository.getParkingByAddress(address,user.getId(),
                 LocalDateTime.parse(startDate, DateTimeFormatter.ISO_DATE_TIME),LocalDateTime.parse(endDate, DateTimeFormatter.ISO_DATE_TIME));
         parkingRepository.delete(parking);
         return Optional.ofNullable(parking);
    }

    public Optional<List<Parking>> getListAllParkingAvailable() {
        return parkingRepository.getAllParking();
    }

//    public void update(Parking parking) {
//      parkingRepository.updateParking(parking.getId(),parking.getStartDate(),parking.getEndDate()) ;
//    }
}

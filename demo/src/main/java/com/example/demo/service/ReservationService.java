package com.example.demo.service;

import com.example.demo.entity.Parking;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRegister;
import com.example.demo.repository.ParkingRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.utile.RowMapperUserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {


    @Autowired
    private ReservationRepository reservationRepository;


    @Autowired
    private ParkingRepository parkingRepository;



    public Reservation  reservation(Reservation reservation) {
     reservation.setParking(parkingRepository.save(reservation.getParking()));

        return reservationRepository.save(reservation);

    }

    public List<Parking> getListParkingReservedByUsername(String username) {
        Optional<List<Reservation>> listReservation = reservationRepository.getReservation();
        List<Parking> parkings = new ArrayList<>();
        for (int i = 0; i < listReservation.get().size(); i++) {
            Parking parking = new Parking();
            parking.setAddress(listReservation.get().get(i).getParking().getAddress());
            parking.setStartDate(listReservation.get().get(i).getStartDate());
            parking.setEndDate(listReservation.get().get(i).getEndDate());
            parkings.add(parking);
        }
        return parkings;
    }

    public Optional<Reservation> deleteParkingReservation(String address) {
        Reservation reservation=reservationRepository.getParkingByAddress(address);
        reservationRepository.delete(reservation);
        return Optional.ofNullable(reservation);
    }
}

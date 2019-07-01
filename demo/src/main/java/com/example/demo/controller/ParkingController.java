package com.example.demo.controller;

import com.example.demo.entity.Parking;
import com.example.demo.entity.ParkingTwoDate;
import com.example.demo.entity.Reservation;
import com.example.demo.service.ParkingService;
import com.example.demo.service.ReservationService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class ParkingController {


    @Autowired
    private ParkingService parkingService;

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "/parking")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyyThh:mm")
    public ResponseEntity<Parking> register(@RequestBody Parking parking) {
        parkingService.add(parking);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Parking> register(@RequestBody ParkingTwoDate parking) {
        parkingService.add(parking);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/reserveParking")
    public ResponseEntity<Parking> update(@RequestBody Parking parking) {
        Reservation reservation = new Reservation();
        reservation.setParking(parking);
        reservation.setStartDate(parking.getStartDate());
        reservation.setEndDate(parking.getEndDate());
        reservationService.reservation(reservation);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/reserveParkingForTwoDate")
    public ResponseEntity<ParkingTwoDate> update(@RequestBody ParkingTwoDate parking) {
        Parking parkingSimple = parking.getParking();

        Reservation reservation = new Reservation();
        reservation.setParking(parking.getParking());
        reservation.setStartDate(parking.getParking().getStartDate());
        reservation.setEndDate(parking.getParking().getEndDate());
        reservationService.reservation(reservation);
        parkingService.deleteParkingRegistred(parkingSimple.getAddress(), parkingSimple.getUsername()
                , parking.getInitialStartDate().toString(),parking.getInitialEndDate().toString()
        );
        SaveParking(parking);
        return ResponseEntity.ok().build();
    }

    private void SaveParking(ParkingTwoDate parking) {
        LocalDateTime startDate = parking.getParking().getStartDate();
        LocalDateTime endDate = parking.getParking().getEndDate();
        LocalDateTime intialStart = parking.getInitialStartDate();
        LocalDateTime initialEnd = parking.getInitialEndDate();
        Parking parking1 = parking.getParking();
        Parking parking2 = parking.getParking();

        if (startDate.isAfter(intialStart) && endDate.isBefore(initialEnd)) {
            parking1.setStartDate(intialStart);
            parking1.setEndDate(startDate);
            parking2.setStartDate(endDate);
            parking2.setEndDate(initialEnd);
            parkingService.add(parking2);
        } else if (startDate.isAfter(intialStart)) {
            parking1.setStartDate(intialStart);
            parking1.setEndDate(startDate);
        } else if (endDate.isBefore(initialEnd)) {
            parking1.setStartDate(endDate);
            parking1.setEndDate(initialEnd);
        }
        parkingService.add(parking1);
    }

    @GetMapping(value = "/getParkingByUser")
    public Optional<List<Parking>> getParkingByUsername(@PathParam("username") String username) {
        return parkingService.getListParkingByUsername(username);
    }

    @GetMapping(value = "/getParkingReservedByUser")
    public List<Parking> getParkingReservedByUsername(@PathParam("username") String username) {
        return reservationService.getListParkingReservedByUsername(username);
    }

//    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteParking")
//    public Optional<Parking> deleteParking(@PathParam("address") String address,@PathParam("usename") String username){
//        return parkingService.deleteParkingRegistred(address,username);
//    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteParking")
    public Optional<Parking> deleteParking(@PathParam("address") String address, @PathParam("usename") String username,
                                           @PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
        return parkingService.deleteParkingRegistred(address, username, startDate, endDate);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteParkingReserved")
    public Optional<Reservation> deleteParking(@PathParam("address") String address) {
        return reservationService.deleteParkingReservation(address);

    }


    @GetMapping(value = "/getListAllParkingAddress")
    public Optional<List<Parking>> getAllParkingAvailable() {
        return parkingService.getListAllParkingAvailable();
    }
}

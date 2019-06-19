package com.example.demo.controller;

import com.example.demo.entity.Parking;
import com.example.demo.entity.Reservation;
import com.example.demo.service.ParkingService;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value="/parking")
    public ResponseEntity<Parking> register(@RequestBody Parking parking){
           parkingService.add(parking);
            return ResponseEntity.ok().build();
    }

    @PostMapping(value="/reserveParking")
    public ResponseEntity<Parking> update(@RequestBody Parking parking){
        Reservation reservation = new Reservation();
        reservation.setParking(parking);
        reservation.setStartDate(parking.getStartDate());
        reservation.setEndDate(parking.getEndDate());
        reservationService.reservation(reservation);
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "/getParkingByUser" )
    public Optional<List<Parking>> getParkingByUsername(@PathParam("username") String username){
        return parkingService.getListParkingByUsername(username);
    }

    @GetMapping(value = "/getParkingReservedByUser" )
    public List<Parking> getParkingReservedByUsername(@PathParam("username") String username){
        return reservationService.getListParkingReservedByUsername(username);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteParking")
    public Optional<Parking> deleteParking(@PathParam("address") String address,@PathParam("usename") String username){
        return parkingService.deleteParkingRegistred(address,username);
    }
 @RequestMapping(method = RequestMethod.DELETE, value = "/deleteParkingReserved")
    public Optional<Reservation> deleteParking(@PathParam("address") String address){
       return reservationService.deleteParkingReservation(address);

    }


    @GetMapping(value = "/getListAllParkingAddress" )
    public Optional<List<Parking>> getAllParkingAvailable(){
        return parkingService.getListAllParkingAvailable();
    }
}

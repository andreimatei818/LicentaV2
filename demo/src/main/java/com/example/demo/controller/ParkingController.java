package com.example.demo.controller;

import com.example.demo.entity.Parking;
import com.example.demo.service.ParkingService;
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

    @PostMapping(value="/parking")
    public ResponseEntity<Parking> register(@RequestBody Parking parking){
           parkingService.add(parking);
            return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getParkingByUser" )
    public Optional<List<Parking>> getParkingByUsername(@PathParam("username") String username){
        return parkingService.getListParkingByUsername(username);
    }

}

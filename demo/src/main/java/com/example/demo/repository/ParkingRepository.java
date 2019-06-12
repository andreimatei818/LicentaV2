package com.example.demo.repository;

import com.example.demo.entity.Parking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Integer> {

    @Query("SELECT p from Parking p where p.user.id=:id ")
    public Optional<List<Parking>> getAllParkingByUserId(@Param("id") int id);



}

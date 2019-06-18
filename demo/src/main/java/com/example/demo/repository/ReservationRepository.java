package com.example.demo.repository;

import com.example.demo.entity.Parking;
import com.example.demo.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Integer> {


}

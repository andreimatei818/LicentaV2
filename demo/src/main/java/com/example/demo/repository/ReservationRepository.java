package com.example.demo.repository;

import com.example.demo.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    @Query("select p from Reservation p")
    public Optional<List<Reservation>> getReservation();

    @Query("select r from Reservation r where r.parking.address=:address")
     Reservation getParkingByAddress(@Param("address") String address);

}

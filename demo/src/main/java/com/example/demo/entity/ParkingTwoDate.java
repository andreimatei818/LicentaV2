package com.example.demo.entity;

import java.time.LocalDateTime;

public class ParkingTwoDate {
    private Parking parking = new Parking();
    private LocalDateTime intialDateStart;
    private LocalDateTime initialDateEnd;

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public LocalDateTime getIntialDateStart() {
        return intialDateStart;
    }

    public void setIntialDateStart(LocalDateTime intialDateStart) {
        this.intialDateStart = intialDateStart;
    }

    public LocalDateTime getInitialDateEnd() {
        return initialDateEnd;
    }

    public void setInitialDateEnd(LocalDateTime initialDateEnd) {
        this.initialDateEnd = initialDateEnd;
    }
}

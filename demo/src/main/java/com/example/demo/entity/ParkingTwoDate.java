package com.example.demo.entity;

import java.time.LocalDateTime;

public class ParkingTwoDate {
    private Parking parking = new Parking();
    private LocalDateTime initialStartDate;
    private LocalDateTime initialEndDate;

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public LocalDateTime getInitialStartDate() {
        return initialStartDate;
    }

    public void setInitialStartDate(LocalDateTime initialStartDate) {
        this.initialStartDate = initialStartDate;
    }

    public LocalDateTime getInitialEndDate() {
        return initialEndDate;
    }

    public void setInitialEndDate(LocalDateTime initialEndDate) {
        this.initialEndDate = initialEndDate;
    }
}

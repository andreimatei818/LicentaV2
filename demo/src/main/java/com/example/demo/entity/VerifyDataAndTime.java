package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

public class VerifyDataAndTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "id_parking")
    private Parking parking;


    @Column(name = "address")
    private String address;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

}

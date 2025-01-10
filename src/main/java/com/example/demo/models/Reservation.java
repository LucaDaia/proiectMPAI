package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Reservation {
    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence"
    )
    private int idReservation;
    private int idRoom;
    private int idUser;
    private LocalTime startDate;
    private LocalTime endDate;
    private LocalDate date;

    public Reservation(int idRoom, int idUser, LocalTime startDate, LocalTime endDate, LocalDate date) {
        this.idRoom = idRoom;
        this.idUser = idUser;
        this.startDate = startDate;
        this.endDate = endDate;
        this.date = date;
    }

    public Reservation() {
        this.idRoom = 0;
        this.idUser = 0;
        this.startDate = LocalTime.now();
        this.endDate = LocalTime.now();
        this.date = LocalDate.now();
    }
}

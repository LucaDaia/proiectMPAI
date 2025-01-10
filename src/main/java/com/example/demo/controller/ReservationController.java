package com.example.demo.controller;

import com.example.demo.Service.ReservationService;
import com.example.demo.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getReservations() {
       return reservationService.getReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Integer id) {
        return reservationService.getReservationById(id);
    }


    //we need to add request paramters for this to work
    //date format should be YYYY-MM-DD
    @GetMapping("/search")
    public List<Reservation> getReservationByDateAndRoomId(@RequestParam String date, @RequestParam Integer roomId) {
        LocalDate dateUpdated = LocalDate.parse(date);
        return reservationService.getReservationByDateAndRoomId(dateUpdated, roomId);
    }

    @PostMapping
    public void postReservation(@RequestBody Reservation reservation) {
        reservationService.postReservation(reservation);
    }

}

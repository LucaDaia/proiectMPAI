package com.example.demo.Service;

import com.example.demo.models.Reservation;
import com.example.demo.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }


    public Reservation getReservationById(Integer id) {
        return reservationRepository.findByIdReservation(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public List<Reservation> getReservationByDateAndRoomId(LocalDate date, Integer idRoom) {
        return reservationRepository.findReservationsByDateAndRoomId(date, idRoom);
    }

    @Transactional
    public void postReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}

package com.example.demo.repository;

import com.example.demo.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Optional<Reservation> findByIdReservation(Integer id);

    @Query("SELECT r FROM Reservation r WHERE r.date = :reservationDate AND r.idRoom = :idRoom")
    List<Reservation> findReservationsByDateAndRoomId(@Param("date") LocalDate reservationDate, @Param("idRoom") Integer idRoom);

}

package com.example.demo.config;
import com.example.demo.models.Reservation;
import com.example.demo.models.Room;
import com.example.demo.models.User;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class TablesConfig {

    @Bean
    CommandLineRunner commandLineRunner(RoomRepository roomRepository, ReservationRepository reservationRepository, UserRepository userRepository) {
        return args -> {

            User user1 = new User("Luca Daia", "luca.daia@gmail.com");
            User user2 = new User("Ana Maria Din", "Ana.Din@gmail.com");
            User user3 = new User("Gheorghe Gheorghe", "gheorghe.gheorghe@yahoo.com");

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);


            Room room1 = new Room("Conference Room A", "First Floor", 20);
            Room room2 = new Room("Meeting Room B", "Second Floor", 10);
            Room room3 = new Room("Training Room C", "Third Floor", 30);

            roomRepository.save(room1);
            roomRepository.save(room2);
            roomRepository.save(room3);


            Reservation reservation1 = new Reservation(
                    1,
                    1,
                    LocalTime.of(9, 0),
                    LocalTime.of(11, 0),
                    LocalDate.of(2025, 1, 15)
            );

            Reservation reservation2 = new Reservation(
                    2,
                    2,
                    LocalTime.of(13, 0),
                    LocalTime.of(15, 0),
                    LocalDate.of(2025, 1, 16)
            );

            Reservation reservation3 = new Reservation(
                    3,
                    3,
                    LocalTime.of(10, 0),
                    LocalTime.of(12, 0),
                    LocalDate.of(2025, 1, 17)
            );

            reservationRepository.save(reservation1);
            reservationRepository.save(reservation2);
            reservationRepository.save(reservation3);
        };
    }
}

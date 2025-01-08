package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table
public class Room {

    @Id
    @SequenceGenerator(
            name = "room_sequence",
            sequenceName = "room_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_sequence"
    )
    private int id;
    private String roomName;
    private String location;
    private int capacity;


    public Room(String roomName, String location, int capacity) {
        this.roomName = roomName;
        this.location = location;
        this.capacity = capacity;
    }

    public Room() {
        this.roomName = "N/A";
        this.location = "N/A";
        this.capacity = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "roomName='" + roomName + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

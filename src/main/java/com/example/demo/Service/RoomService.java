package com.example.demo.Service;

import com.example.demo.models.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public void postRoom(Room room) {
        roomRepository.save(room);
    }

    public Room getRoomByName(String name) {
       return roomRepository.findByRoomName(name).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    public Room getRoomById(Integer id){
        return roomRepository.findById(id).orElseThrow(()-> new RuntimeException("Room noy found"));
    }
}

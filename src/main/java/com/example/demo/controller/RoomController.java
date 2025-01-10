package com.example.demo.controller;

import com.example.demo.Service.RoomService;
import com.example.demo.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/room")
public class RoomController {
   private final RoomService roomService;

   @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/{name}")
    public Room getRoomByName(@PathVariable String name) {
       return roomService.getRoomByName(name);
    }

    @PostMapping
    public void postRoom(@RequestBody Room room) {
       roomService.postRoom(room);
    }

}

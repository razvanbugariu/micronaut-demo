package com.bug.demo.micronaut.controllers;

import com.bug.demo.micronaut.entities.unidirectional.Room;
import com.bug.demo.micronaut.repositories.RoomRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("room")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Get
    public List<Room> getAll() {
        return roomRepository.getAllRooms();
    }
}

package com.bug.demo.micronaut.repositories;

import com.bug.demo.micronaut.entities.unidirectional.Room;

import java.util.List;

public interface RoomRepository {
    List<Room> getRoomsByHouseId(int houseId);
    List<Room> getAllRooms();
}

package com.bug.demo.micronaut.repositories;

import com.bug.demo.micronaut.entities.unidirectional.Address;
import com.bug.demo.micronaut.entities.unidirectional.House;
import com.bug.demo.micronaut.entities.unidirectional.Room;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface HouseRepository {

    List<House> findAll();
    Optional<House> getbyId(int id);
    Optional<House> saveHouse(House house);

    @Transactional
    void deleteById(int id);

    void addRoomsToHouse(int houseId, List<Room> rooms);

    void removeRoomFromHouse(int houseId, int roomId);

    void addHouseAddress(int houseId, Address address);
}

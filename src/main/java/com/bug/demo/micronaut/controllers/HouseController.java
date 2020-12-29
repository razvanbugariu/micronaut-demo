package com.bug.demo.micronaut.controllers;

import com.bug.demo.micronaut.entities.unidirectional.HouseDTO;
import com.bug.demo.micronaut.entities.unidirectional.Address;
import com.bug.demo.micronaut.entities.unidirectional.House;
import com.bug.demo.micronaut.entities.unidirectional.Room;
import com.bug.demo.micronaut.repositories.HouseRepository;
import com.bug.demo.micronaut.services.HouseService;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller("/house")
public class HouseController {

    private final HouseRepository houseRepository;
    private final HouseService houseService;

    public HouseController(HouseRepository houseRepository, HouseService houseService) {
        this.houseRepository = houseRepository;
        this.houseService = houseService;
    }

    @Get
    public List<HouseDTO> getAll() {
        return houseService.getAllHouses();
    }

    @Post
    public House save(@Body @Valid House house) {
        return houseRepository.saveHouse(house).orElse(null);
    }

    @Post("/{houseId}/room")
    public void addRoomToHouse(int houseId, @Body @Valid List<Room> rooms) {
        houseRepository.addRoomsToHouse(houseId, rooms);
    }

    @Post("/{houseId}/address")
    public void addHouseAddress(int houseId, @Body @Valid Address address) {
        houseRepository.addHouseAddress(houseId, address);
    }

    @Delete("/{houseId}/room/{roomId}")
    public void removeRoomFromHouse(int houseId, int roomId) {
        houseRepository.removeRoomFromHouse(houseId, roomId);
    }

    @Delete("/{id}")
    public void deleteById(int id) {
        houseRepository.deleteById(id);
    }

    @Get("/{id}")
    public House getById(int id) {
        return houseRepository.getbyId(id).orElse(null);
    }

}

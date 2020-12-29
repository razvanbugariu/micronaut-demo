package com.bug.demo.micronaut.entities.unidirectional;

import java.util.List;

public class HouseDTO {
    private int id;
    private String model;
    private List<RoomDTO> rooms;
    private AddressDTO address;

    public HouseDTO(int id, String model, List<RoomDTO> rooms, AddressDTO address) {
        this.id = id;
        this.model = model;
        this.rooms = rooms;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public AddressDTO getAddress() {
        return address;
    }
}

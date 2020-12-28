package com.bug.demo.micronaut.services;

import com.bug.demo.micronaut.entities.AddressDTO;
import com.bug.demo.micronaut.entities.HouseDTO;
import com.bug.demo.micronaut.entities.RoomDTO;
import com.bug.demo.micronaut.entities.unidirectional.Address;
import com.bug.demo.micronaut.entities.unidirectional.House;
import com.bug.demo.micronaut.entities.unidirectional.Room;
import com.bug.demo.micronaut.repositories.AddressRepository;
import com.bug.demo.micronaut.repositories.HouseRepository;
import com.bug.demo.micronaut.repositories.RoomRepository;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class HouseService {

    private final HouseRepository houseRepository;
    private final RoomRepository roomRepository;
    private final AddressRepository addressRepository;

    public HouseService(HouseRepository houseRepository, RoomRepository roomRepository, AddressRepository addressRepository) {
        this.houseRepository = houseRepository;
        this.roomRepository = roomRepository;
        this.addressRepository = addressRepository;
    }

    public List<HouseDTO> getAllHouses() {
        List<House> houses = houseRepository.findAll();
        List<HouseDTO> houseDTOs = new ArrayList<>();

        houses.forEach(house -> {
            List<Room> houseRooms = roomRepository.getRoomsByHouseId(house.getId());
            List<RoomDTO> roomDTOS = houseRooms.stream().map(this::convertToDTO).collect(Collectors.toList());
            Optional<Address> addressOpt = addressRepository.getbyHouseId(house.getId());
            AddressDTO addressDTO = null;
            if (addressOpt.isPresent()) {
                addressDTO = convertToDTO(addressOpt.get());
            }
            HouseDTO houseDTO = new HouseDTO(house.getId(), house.getModel(), roomDTOS, addressDTO);
            houseDTOs.add(houseDTO);
        });
        return houseDTOs;
    }

    private RoomDTO convertToDTO(Room room) {
        return new RoomDTO(room.getId(), room.getM2Squares());
    }

    private AddressDTO convertToDTO(Address address) {
        return new AddressDTO(address.getId(), address.getStreet(), address.getTown(), address.getNumber());
    }
}

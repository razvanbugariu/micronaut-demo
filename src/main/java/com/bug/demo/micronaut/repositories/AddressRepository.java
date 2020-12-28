package com.bug.demo.micronaut.repositories;

import com.bug.demo.micronaut.entities.unidirectional.Address;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    Optional<Address> getbyHouseId(int houseId);

    List<Address> getAll();
}

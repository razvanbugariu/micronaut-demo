package com.bug.demo.micronaut.repositories;

import com.bug.demo.micronaut.entities.unidirectional.Address;
import com.bug.demo.micronaut.entities.unidirectional.House;
import com.bug.demo.micronaut.entities.unidirectional.Room;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class HouseRepositoryImpl implements HouseRepository {

    private final EntityManager entityManager;

    public HouseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public List<House> findAll() {
        String queryString = "Select h from House as h";
        TypedQuery<House> query = entityManager.createQuery(queryString, House.class);
        return query.getResultList();
    }

    @Override
    @ReadOnly
    public Optional<House> getbyId(int id) {
        return Optional.ofNullable(entityManager.find(House.class, id));
    }

    @Override
    @Transactional
    public Optional<House> saveHouse(House house) {
        entityManager.persist(house);
        return Optional.ofNullable(house);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Optional<House> houseOpt = getbyId(id);
        houseOpt.ifPresent(entityManager::remove);
    }

    @Override
    @Transactional
    public void addRoomsToHouse(int houseId, List<Room> rooms) {
        Optional<House> houseOpt = getbyId(houseId);
        houseOpt.ifPresent(house -> {
            rooms.forEach(room -> {
                room.setHouse(house);
                entityManager.persist(room);
            });
        });
    }

    @Override
    @Transactional
    public void removeRoomFromHouse(int houseId, int roomId) {
        String queryStr = "SELECT r FROM Room as r WHERE house_id=:houseId and id=:id";
        TypedQuery<Room> query = entityManager.createQuery(queryStr, Room.class)
                .setParameter("id", roomId)
                .setParameter("houseId", houseId);
        Room toBeDeleted = query.getSingleResult();
        entityManager.remove(toBeDeleted);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void addHouseAddress(int houseId, Address address) {
        Optional<House> houseOptional = getbyId(houseId);
        houseOptional.ifPresent(house -> {
            address.setHouse(house);
            entityManager.persist(address);
        });
    }
}

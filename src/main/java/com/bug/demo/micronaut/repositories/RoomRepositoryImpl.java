package com.bug.demo.micronaut.repositories;

import com.bug.demo.micronaut.entities.unidirectional.Room;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
public class RoomRepositoryImpl implements RoomRepository {

    private final EntityManager entityManager;

    public RoomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public List<Room> getRoomsByHouseId(int houseId) {
        String queryString = "SELECT r FROM Room as r WHERE house_id=" + houseId;
        TypedQuery<Room> query = entityManager.createQuery(queryString, Room.class);
        return query.getResultList();
    }

    @Override
    @ReadOnly
    public List<Room> getAllRooms() {
        String queryString = "SELECT r FROM Room as r";
        TypedQuery<Room> query = entityManager.createQuery(queryString, Room.class);
        return query.getResultList();
    }
}

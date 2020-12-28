package com.bug.demo.micronaut.repositories;

import com.bug.demo.micronaut.entities.unidirectional.Address;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Singleton
public class AddressRepositoryImpl implements AddressRepository {
    private final EntityManager entityManager;

    public AddressRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public Optional<Address> getbyHouseId(int houseId) {
        String queryStr = "SELECT a FROM Address as a where house_id=:houseId";
        TypedQuery<Address> query = entityManager.createQuery(queryStr, Address.class).setParameter("houseId", houseId);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    @ReadOnly
    public List<Address> getAll() {
        String queryStr = "SELECT a FROM Address as a";
        TypedQuery<Address> query = entityManager.createQuery(queryStr, Address.class);
        return query.getResultList();
    }
}

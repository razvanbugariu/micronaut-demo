package com.bug.demo.micronaut.repositories;

import com.bug.demo.micronaut.entities.unidirectional.Address;
import com.bug.demo.micronaut.entities.unidirectional.Fridge;
import com.bug.demo.micronaut.entities.unidirectional.Thing;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class ThingRepositoryImpl implements ThingRepository {

    private final EntityManager entityManager;

    public ThingRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public Optional<Thing> getThingById(int id) {
        String queryStr = "SELECT t FROM Thing as t WHERE id=" + id;
        TypedQuery<Thing> query = entityManager.createQuery(queryStr, Thing.class);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    @ReadOnly
    public List<Thing> getAll() {
        String queryStr = "SELECT t FROM Thing as t";
        TypedQuery<Thing> query = entityManager.createQuery(queryStr, Thing.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Thing saveThing(Thing thing) {
        entityManager.persist(thing);
        entityManager.flush();
        return thing;
    }

    @Override
    @Transactional
    public void addFridge(int thingId, Fridge fridge) {
        Optional<Thing> thingOpt = getThingById(thingId);
        thingOpt.ifPresent(thing -> {
            thing.addAddress(fridge);
            entityManager.persist(thing);
            entityManager.flush();
        });
    }

    @Override
    @Transactional
    public void removeFridge(int thingId, Fridge fridge) {
        Optional<Thing> thingOpt = getThingById(thingId);
        thingOpt.ifPresent(thing -> {
            thing.removeAddress(fridge);
            entityManager.persist(thing);
            entityManager.flush();
        });
    }
}

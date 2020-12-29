package com.bug.demo.micronaut.repositories;

import com.bug.demo.micronaut.entities.unidirectional.Fridge;
import com.bug.demo.micronaut.entities.unidirectional.Thing;

import java.util.List;
import java.util.Optional;

public interface ThingRepository {
    Optional<Thing> getThingById(int id);

    List<Thing> getAll();

    Thing saveThing(Thing thing);

    void addFridge(int thingId, Fridge address);

    void removeFridge(int thingId, Fridge address);
}

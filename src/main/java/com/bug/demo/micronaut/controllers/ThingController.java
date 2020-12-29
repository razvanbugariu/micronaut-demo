package com.bug.demo.micronaut.controllers;

import com.bug.demo.micronaut.entities.unidirectional.Fridge;
import com.bug.demo.micronaut.entities.unidirectional.Thing;
import com.bug.demo.micronaut.repositories.ThingRepository;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller("thing")
public class ThingController {

    private ThingRepository thingRepository;

    public ThingController(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    @Get("/{thingId}")
    public Thing getById(int thingId) {
        return thingRepository.getThingById(thingId).orElse(null);
    }

    @Get
    public List<Thing> getAll() {
        return thingRepository.getAll();
    }

    @Post
    public Thing create(@Body @Valid Thing thing) {
        return thingRepository.saveThing(thing);
    }

    @Post("/{thingId}/fridge")
    public void create(int thingId, @Body @Valid Fridge fridge) {
        thingRepository.addFridge(thingId, fridge);
    }

    @Delete("/{thingId}/fridge")
    public void remove(int thingId, @Body @Valid Fridge fridge) {
        thingRepository.removeFridge(thingId, fridge);
    }
}

package com.bug.demo.micronaut.controllers;

import com.bug.demo.micronaut.entities.composedid.EmbeddedIdEntity;
import com.bug.demo.micronaut.entities.composedid.IdClassEntity;
import com.bug.demo.micronaut.repositories.CompositeIdRepository;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;
import java.util.List;

@Controller("/entities")
public class CompositeIdController {

    private final CompositeIdRepository compositeIdRepository;

    public CompositeIdController(CompositeIdRepository compositeIdRepository) {
        this.compositeIdRepository = compositeIdRepository;
    }

    @Post("/emb")
    public void postEmb(@Body @Valid EmbeddedIdEntity entity) {
        compositeIdRepository.saveEmbIdEntity(entity);
    }

    @Post("/idclass")
    public void postEmb(@Body @Valid IdClassEntity entity) {
        compositeIdRepository.saveIdClassEntity(entity);
    }

    @Get("/emb")
    public List<EmbeddedIdEntity> getAllEmbEntities() {
        return compositeIdRepository.getAllEmbIdEntities();
    }

    @Get("/idclass")
    public List<IdClassEntity> getAllIdClassEntities() {
        return compositeIdRepository.getAllIdClassEntities();
    }
}

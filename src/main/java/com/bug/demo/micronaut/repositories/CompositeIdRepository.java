package com.bug.demo.micronaut.repositories;

import com.bug.demo.micronaut.entities.composedid.EmbeddedIdEntity;
import com.bug.demo.micronaut.entities.composedid.IdClassEntity;

import java.util.List;

public interface CompositeIdRepository {
    List<EmbeddedIdEntity> getAllEmbIdEntities();

    List<IdClassEntity> getAllIdClassEntities();

    void saveEmbIdEntity(EmbeddedIdEntity entity);

    void saveIdClassEntity(IdClassEntity entity);
}

package com.bug.demo.micronaut.repositories;

import com.bug.demo.micronaut.entities.composedid.EmbeddedIdEntity;
import com.bug.demo.micronaut.entities.composedid.IdClassEntity;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class CompositeIdRepositoryImpl implements CompositeIdRepository {

    private EntityManager entityManager;

    public CompositeIdRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public List<EmbeddedIdEntity> getAllEmbIdEntities() {
        String queryStr = "Select e from EmbeddedIdEntity as e";
        TypedQuery<EmbeddedIdEntity> query = entityManager.createQuery(queryStr, EmbeddedIdEntity.class);
        return query.getResultList();
    }

    @Override
    @ReadOnly
    public List<IdClassEntity> getAllIdClassEntities() {
        String queryStr = "Select e from IdClassEntity as e";
        TypedQuery<IdClassEntity> query = entityManager.createQuery(queryStr, IdClassEntity.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveEmbIdEntity(EmbeddedIdEntity entity) {
        entityManager.persist(entity);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void saveIdClassEntity(IdClassEntity entity) {
        entityManager.persist(entity);
        entityManager.flush();
    }
}

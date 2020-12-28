package com.bug.demo.micronaut.entities.composedid;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EmbeddedIdEntity")
public class EmbeddedIdEntity {

    @EmbeddedId
    private EmbId id;

    private String content;

    public EmbeddedIdEntity() {
    }

    public EmbeddedIdEntity(EmbId id, String content) {
        this.id = id;
        this.content = content;
    }

    public EmbId getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "EmbeddedIdEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}

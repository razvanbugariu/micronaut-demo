package com.bug.demo.micronaut.entities.composedid;

import javax.persistence.*;

@Entity
@IdClass(IdClassId.class)
@Table(name = "IdClassEntity")
public class IdClassEntity {

    @Id
    private int intId;

    @Id
    private String stringId;

    @Column
    private String content;

    public IdClassEntity() {
    }

    public IdClassEntity(int intId, String stringId, String content) {
        this.intId = intId;
        this.stringId = stringId;
        this.content = content;
    }

    public int getIntId() {
        return intId;
    }

    public String getStringId() {
        return stringId;
    }

    public String getContent() {
        return content;
    }
}

package com.bug.demo.micronaut.entities.composedid;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmbId implements Serializable {

    @Column(name = "emb_int_id")
    private int intId;

    @Column(name = "emb_string_id")
    private String stringId;

    public EmbId() {
    }

    public EmbId(int intId, String stringId) {
        this.intId = intId;
        this.stringId = stringId;
    }

    public int getIntId() {
        return intId;
    }

    public String getStringId() {
        return stringId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbId embId = (EmbId) o;
        return intId == embId.intId && Objects.equals(stringId, embId.stringId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intId, stringId);
    }
}

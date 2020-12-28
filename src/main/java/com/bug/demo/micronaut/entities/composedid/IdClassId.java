package com.bug.demo.micronaut.entities.composedid;

import java.io.Serializable;
import java.util.Objects;

public class IdClassId implements Serializable {

    private int intId;
    private String stringId;

    public IdClassId() {
    }

    public IdClassId(int intId, String stringId) {
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
        IdClassId idClassId = (IdClassId) o;
        return intId == idClassId.intId && Objects.equals(stringId, idClassId.stringId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intId, stringId);
    }

    @Override
    public String toString() {
        return "IdClassId{" +
                "intId=" + intId +
                ", stringId='" + stringId + '\'' +
                '}';
    }
}

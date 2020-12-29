package com.bug.demo.micronaut.entities.unidirectional;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Fridge")
public class Fridge {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int height;

    public Fridge() {
    }

    public Fridge(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fridge fridge = (Fridge) o;
        return id == fridge.id && height == fridge.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, height);
    }
}

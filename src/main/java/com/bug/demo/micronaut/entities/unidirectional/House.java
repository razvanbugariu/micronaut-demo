package com.bug.demo.micronaut.entities.unidirectional;

import javax.persistence.*;

@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue
    @Column(name = "house_id")
    private int id;

    @Column
    private String model;

    public House() {
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}

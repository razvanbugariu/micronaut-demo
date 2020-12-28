package com.bug.demo.micronaut.entities.unidirectional;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int m2Squares;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    public Room() {
    }

    public Room(int id, int m2Squares) {
        this.id = id;
        this.m2Squares = m2Squares;
    }

    public int getId() {
        return id;
    }

    public int getM2Squares() {
        return m2Squares;
    }

    public void setM2Squares(int m2Squares) {
        this.m2Squares = m2Squares;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

}

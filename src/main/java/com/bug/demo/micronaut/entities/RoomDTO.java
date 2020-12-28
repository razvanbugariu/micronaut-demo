package com.bug.demo.micronaut.entities;

public class RoomDTO {

    private int id;
    private int m2Squares;

    public RoomDTO(int id, int m2Squares) {
        this.id = id;
        this.m2Squares = m2Squares;
    }

    public int getId() {
        return id;
    }

    public int getM2Squares() {
        return m2Squares;
    }
}

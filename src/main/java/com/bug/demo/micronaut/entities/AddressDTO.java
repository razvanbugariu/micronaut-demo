package com.bug.demo.micronaut.entities;

public class AddressDTO {

    private int id;
    private String street;
    private String town;
    private int number;

    public AddressDTO() {
    }

    public AddressDTO(int id, String street, String town, int number) {
        this.id = id;
        this.street = street;
        this.town = town;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public int getNumber() {
        return number;
    }
}

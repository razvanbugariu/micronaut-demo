package com.bug.demo.micronaut.entities.unidirectional;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String street;

    @Column
    private String town;

    @Column(unique = true)
    private int number;

    @OneToOne
    @JoinColumn(name = "house_id")
    private House house;

    public Address() {
    }

    public Address(String street, String town, int number, House house) {
        this.street = street;
        this.town = town;
        this.number = number;
        this.house = house;
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


    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getId() {
        return id;
    }
}

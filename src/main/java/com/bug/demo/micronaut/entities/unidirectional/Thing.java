package com.bug.demo.micronaut.entities.unidirectional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Thing")
public class Thing {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private String content;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "thing_address",
            joinColumns = @JoinColumn(name = "thing_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Fridge> fridges = new ArrayList<>();

    public Thing() {
    }

    public Thing(String content, List<Fridge> addresses) {
        this.content = content;
        this.fridges = addresses;
    }

    public void addAddress(Fridge fridge) {
        this.fridges.add(fridge);
    }

    public void removeAddress(Fridge fridge) {
        this.fridges.remove(fridge);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public List<Fridge> getFridges() {
        return fridges;
    }
}

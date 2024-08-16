package org.as2.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street, city, state, zip;
    // mappedBy="addresses" means that the addresses field in the Owner class is the owning side of the relationship
    // The addresses field is the foreign key in the owner table
    @ManyToMany(mappedBy = "addresses")
    private final Set<Owner> owners = new HashSet<Owner>();

    public Address() {
    }

    public Address(String street, String city, String state, String zip) {
        super();
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Owner> getOwners() {
        return owners;
    }
}

package org.as2.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerid;
    private String firstname, lastname;
    // One owner can have many vehicles
    // mappedBy="owner" means that the owner field in the Vehicle class is the owning side of the relationship
    // The owner field is the foreign key in the vehicle table
    // cascade=CascadeType.ALL means that if the owner is deleted, all the vehicles associated with the owner will be deleted
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Vehicle> vehicles;

    public Owner() {
    }

    // One owner can have many addresses
    //joinTable="address_owner" creates a join table named address_owner with two columns: ownerid and id
    //joinColumns={@JoinColumn(name="ownerid")} specifies the ownerid column in the address_owner table as the foreign key column
    //inverseJoinColumns={@JoinColumn(name="id")} specifies the id column in the address_owner table as the foreign key column
    //cascade=CascadeType.PERSIST means that if the owner is persisted, all the addresses associated with the owner will be persisted
    //Set is used instead of List because the order of the addresses is not important
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "address_owner", joinColumns = {@JoinColumn(name = "ownerid")}, inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<Address> addresses = new HashSet<Address>();

    public Owner(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}

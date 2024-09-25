package org.as2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Vehicle {
    // primary key
    // ? How to create a composite PK
    @Id
    // How keys are generated is defined
    @GeneratedValue(strategy = GenerationType.AUTO)
    //database columns are named according to class field naming conventions by default
    private Long id;
    private String brand, model, color, registrationNumber;
    private int modelYear, price;
    // Many vehicles can have one owner
    // [default] FETchType.LAZY means when the owner is fetched from the database, the vehicles associated with the owner
    //will be fetched when needed
    // FetchType.EAGER means that the owner is fetched automatically
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;
   // @Column(name="description", nullable=false, length=512)
    private String description;

    public Vehicle(String brand, String model, String color, String registrationNumber, int modelYear, int price, String description,Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.description = description;
        this.owner = owner;
    }

    public Vehicle() {

    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Getter and setter
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

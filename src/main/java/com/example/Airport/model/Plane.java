package com.example.Airport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String model;
    private String manufacturer;
    private int capacity;
    private int yearOfManufacture;

    @ManyToMany(mappedBy = "planes", fetch = FetchType.EAGER)
    private List<Airport> airports;

    @ManyToMany(mappedBy = "planes", fetch = FetchType.EAGER)
    private List<Flight> flights;


    public Plane() {
    };

    public Plane(long id, String model, String manufacturer, int capacity, int yearOfManufacture) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.yearOfManufacture = yearOfManufacture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
}
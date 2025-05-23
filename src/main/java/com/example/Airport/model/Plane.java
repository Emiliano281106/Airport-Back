package com.example.Airport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String model;
    private String manufacturer;
    private int capacity;
    private int yearOfManufacture;



    @ManyToMany(mappedBy = "planes", fetch = FetchType.EAGER)
    private List<Airport> airports;


    @ManyToMany(mappedBy = "planes", fetch = FetchType.EAGER)
    private List<Flight> flights;



}
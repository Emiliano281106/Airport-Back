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
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;
    private String country;
    private String city;


    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departingFlights;


    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivingFlights;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Airport-Plane",
    joinColumns = @JoinColumn(name = "Airport_ID"),
    inverseJoinColumns = @JoinColumn(name = "Plane_ID"))
    private List<Plane> planes;



}
package com.example.Airport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String flightNumber;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String status;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Flight-Plane",
    joinColumns = @JoinColumn(name = "Flight_ID"),
    inverseJoinColumns = @JoinColumn(name = "Plane_ID"))
    private List<Plane> planes;

    @ManyToMany(mappedBy = "flights", fetch = FetchType.EAGER)
    private List<Ticket> tickets;


}

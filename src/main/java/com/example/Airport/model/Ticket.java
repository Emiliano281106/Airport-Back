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
public class Ticket {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String airlineName;
    private String seat;
    private String flightClass;
    private String boardingZone;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ticket-flight",
    joinColumns = @JoinColumn(name = "Ticket_ID"),
    inverseJoinColumns = @JoinColumn(name = "Flight_ID"))
    private List<Flight> flights;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passenger_Id")
    private Passenger passenger;


}

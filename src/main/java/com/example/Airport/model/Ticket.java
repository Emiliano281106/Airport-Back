package com.example.Airport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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

    @ManyToOne(fetch = FetchType.EAGER)
    private Passenger passenger;

    public Ticket() {
    }

    public Ticket(long id, String airlineName, String seat, String flightClass, String boardingZone) {
        this.id = id;
        this.airlineName = airlineName;
        this.seat = seat;
        this.flightClass = flightClass;
        this.boardingZone = boardingZone;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getBoardingZone() {
        return boardingZone;
    }

    public void setBoardingZone(String boardingZone) {
        this.boardingZone = boardingZone;
    }
}

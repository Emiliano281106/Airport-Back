package com.example.Airport.repository;

import com.example.Airport.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,String> {

    Flight getFlightByFlightNumber(String flightNumber);
}

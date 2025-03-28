package com.example.Airport.service;

import com.example.Airport.model.Flight;
import com.example.Airport.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights(){

        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(String id){

        return flightRepository.findById(id);
    }

    public Flight createFlight(Flight flight){

        return flightRepository.save(flight);
    }

    public Flight updateFlight(String id, Flight flight) {
        Flight flightToUpdate = flightRepository.findById(id).orElse(null);

        assert flightToUpdate != null;
        flightToUpdate.setFlightNumber(flight.getFlightNumber());
        flightToUpdate.setStatus(flightToUpdate.getStatus());
        flightToUpdate.setDepartureTime(flight.getDepartureTime());
        flightToUpdate.setArrivalTime(flight.getArrivalTime());

        return flightRepository.save(flightToUpdate);
    }


    public void deleteAllFlights(){

        flightRepository.deleteAll();
    }

    public void deleteFlightById(String id){

        flightRepository.deleteById(id);
    }

    public boolean flightExistsById (String id){

        return flightRepository.existsById(id);
    }

    public Flight getFlightByFlightNumber(String flightNumber){

        return flightRepository.getFlightByFlightNumber(flightNumber);
    }

}

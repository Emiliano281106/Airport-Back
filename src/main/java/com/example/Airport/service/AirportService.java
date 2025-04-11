
package com.example.Airport.service;

import com.example.Airport.model.Airport;
import com.example.Airport.model.Ticket;
import com.example.Airport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports(){

        return airportRepository.findAll();
    }

    public Airport createAirport(Airport airport){
        return airportRepository.save(airport);
    }

    public List<Airport> createAirports(List<Airport> airports){
        return airportRepository.saveAll(airports);
    }

    public Airport updateAirport(String id, Airport airport) {
        Airport airportToUpdate = airportRepository.findById(id).orElse(null);

        assert airportToUpdate != null;
        airportToUpdate.setName(airport.getName());
        airportToUpdate.setCode(airport.getCode());
        airportToUpdate.setCity(airport.getCity());
        airportToUpdate.setCountry(airport.getCountry());


       return airportRepository.save(airportToUpdate);

    }


    public Optional <Airport> getAirportById(String Id){

        return airportRepository.findById(Id);
    }

    public void deleteAirportById(String Id){

        airportRepository.deleteById(Id);

    }

    public void deleteAllAirports(){

        airportRepository.deleteAll();
    }
}
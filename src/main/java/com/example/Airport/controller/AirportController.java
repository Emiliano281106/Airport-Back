package com.example.Airport.controller;

import com.example.Airport.model.Airport;
import com.example.Airport.repository.AirportRepository;
import com.example.Airport.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airports")
@CrossOrigin(origins = "http://localhost:5173")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping("/getAirports")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<List<Airport>> getAllAirports() {

        List<Airport> airports = airportService.getAllAirports();

        if(airports.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(airports);


    }


    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable String id){

        Optional<Airport>airport=airportService.getAirportById(id);

        if(airport.isPresent()){

            return ResponseEntity.ok(airport.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping("/createAirport")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        Airport savedAirport = airportService.createAirport(airport);
        return ResponseEntity.ok(savedAirport);
    }

    @PutMapping("/updateAirport/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable String id, @RequestBody Airport airport){

        airportService.updateAirport(id,airport);

        return ResponseEntity.ok(airport);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllAirports(){
        airportService.deleteAllAirports();
        return ResponseEntity.ok("All airports deleted!");
    }

    @DeleteMapping("/deleteAirport/{id}")
    public ResponseEntity<String> deleteAirportById(@PathVariable("id") String idToDelete){
        airportService.deleteAirportById(idToDelete);

        return ResponseEntity.ok("Airport deleted!");
    }
}

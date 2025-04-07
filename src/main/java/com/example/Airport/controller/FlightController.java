package com.example.Airport.controller;

import com.example.Airport.model.Flight;
import com.example.Airport.repository.FlightRepository;
import com.example.Airport.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:5173")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/getFlights")
    public ResponseEntity<List<Flight>> getAllFlights(){

        List <Flight> flights = flightService.getAllFlights();

        if(flights.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable String id){

        Optional<Flight> flight = flightService.getFlightById(id);

        return flight.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/createFlight")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        System.out.println(flight);
        Flight savedFlight = flightService.createFlight(flight);
        return ResponseEntity.ok(savedFlight);
    }

    @PutMapping("/updateFlight/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable String id,@RequestBody Flight flight) {
        Flight updatedFlight = flightService.updateFlight(id,flight);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllFlights(){

        flightService.deleteAllFlights();

        return new ResponseEntity<>("All planes deleted", HttpStatus.OK);
    }

    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity<String> deleteFlightById(@PathVariable("id") String idToDelete){

        if(flightService.flightExistsById(idToDelete)){
            flightService.deleteFlightById(idToDelete);

            return new ResponseEntity<>("Flight deleted",HttpStatus.OK);
        }

        return new ResponseEntity<>("Flight not found", HttpStatus.NOT_FOUND);
    }



}

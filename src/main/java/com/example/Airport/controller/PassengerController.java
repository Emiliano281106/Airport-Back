package com.example.Airport.controller;

import com.example.Airport.model.Passenger;
import com.example.Airport.repository.PassengerRepository;
import com.example.Airport.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @Autowired
    PassengerRepository passengerRepository;

    @GetMapping
    public ResponseEntity<List<Passenger>>getAllPassengers() {

        List<Passenger> passengers = passengerService.getAllPassengers();

        if(passengers.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(passengers);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable String id){

        Optional<Passenger> passenger = passengerService.getPassengerById(id);

        if(passenger.isPresent()){

            return ResponseEntity.ok(passenger.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PostMapping("/createPassenger")
    public ResponseEntity<List<Passenger>> createPassengers(@RequestBody List<Passenger> passengers) {
        List<Passenger> savedPassengers = passengerRepository.saveAll(passengers);
        return ResponseEntity.ok(savedPassengers);
    }

    @PutMapping("/updatePassenger/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable String id,@RequestBody Passenger passenger){

        Passenger createdPassenger = passengerService.updatePassenger(id,passenger);

        return ResponseEntity.ok(passenger);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllPassengers(){

        passengerService.deleteAllPassengers();

        return ResponseEntity.ok("All passenger deleted!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassengerById(@PathVariable String idToDelete){

        if(passengerService.passengerExistsById(idToDelete)){
            passengerService.deleteById(idToDelete);

            return ResponseEntity.ok("Passenger deleted!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}


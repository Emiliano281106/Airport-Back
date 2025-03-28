package com.example.Airport.service;

import com.example.Airport.model.Passenger;
import com.example.Airport.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers(){

        return passengerRepository.findAll();
    }

    public Optional <Passenger> getPassengerById(String Id){

        return passengerRepository.findById(Id);

    }

    public void deleteById(String Id){

        passengerRepository.deleteById(Id);
    }

    public Passenger createPassenger(Passenger passenger){

        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(String id, Passenger passenger) {
        Passenger passengerToUpdate = passengerRepository.findById(id).orElse(null);

        assert passengerToUpdate != null;
        passengerToUpdate.setDNI(passenger.getDNI());
        passengerToUpdate.setAge(passenger.getAge());
        passengerToUpdate.setName(passenger.getName());
        passengerToUpdate.setSurname(passenger.getSurname());
        passengerToUpdate.setEmail(passenger.getEmail());

        return passengerRepository.save(passengerToUpdate);
    }



    public void deleteAllPassengers(){

        passengerRepository.deleteAll();
    }

    public Passenger getPassengerByDNI(String dni){

        return passengerRepository.getPassengerByDNI(dni);
    }

    public boolean passengerExistsById(String id){

        return passengerRepository.existsById(id);
    }
}
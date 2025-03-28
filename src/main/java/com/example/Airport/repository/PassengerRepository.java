package com.example.Airport.repository;

import com.example.Airport.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, String> {

    Passenger getPassengerByDNI(String dni);

}

package com.example.Airport;

import com.example.Airport.model.Airport;
import com.example.Airport.model.Flight;
import com.example.Airport.repository.AirportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AirportApplicationTests {

	@Autowired
	AirportRepository airportRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createFlight() {

		Flight flight001 = new Flight();
		flight001.setFlightNumber("1234g");
		flight001.setStatus("ON-TIME");
		flight001.setDepartureAirport(airportRepository.findById("2").orElse(null));
		flight001.setArrivalAirport(airportRepository.findById("3").orElse(null));
		assertNotNull(flight001.getDepartureAirport());
		assertEquals("1234g", flight001.getFlightNumber());

	}

}

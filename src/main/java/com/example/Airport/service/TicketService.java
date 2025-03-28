package com.example.Airport.service;

import com.example.Airport.model.Ticket;
import com.example.Airport.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets(){

        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(String id){

        return ticketRepository.findById(id);
    }

    public void deleteAllTickets(){

        ticketRepository.deleteAll();
    }

    public void deleteTicketById(String id){

        ticketRepository.deleteById(id);
    }

    public Ticket createTicket (Ticket ticket){

        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(String id,Ticket ticket){

       Ticket ticketToUpdate = ticketRepository.findById(id).orElse(null);

        assert ticketToUpdate != null;
        ticketToUpdate.setAirlineName(ticket.getAirlineName());
        ticketToUpdate.setSeat(ticket.getSeat());
        ticketToUpdate.setFlightClass(ticket.getFlightClass());
        ticketToUpdate.setBoardingZone(ticket.getBoardingZone());

        return ticketRepository.save(ticketToUpdate);

    }

    public boolean ticketExistsById(String idToDelete){

        return ticketRepository.existsById(idToDelete);
    }


}

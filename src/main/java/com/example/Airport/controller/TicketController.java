package com.example.Airport.controller;

import com.example.Airport.model.Ticket;
import com.example.Airport.repository.TicketRepository;
import com.example.Airport.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:5173")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/getTickets")
    public ResponseEntity<List<Ticket>> getAllTickets(){

        List<Ticket> tickets = ticketService.getAllTickets();

        if(tickets.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable String id){

        Optional<Ticket> ticket = ticketService.getTicketById(id);

        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @PostMapping("/createTicket")
    public ResponseEntity<List<Ticket>> createTickets(@RequestBody List<Ticket> tickets) {
        List<Ticket> savedTickets = ticketRepository.saveAll(tickets);
        return ResponseEntity.ok(savedTickets);
    }

    @PutMapping("/updateTicket/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable String id, @RequestBody Ticket ticket){

        Ticket ticketToUpdate = ticketService.updateTicket(id,ticket);

        return ResponseEntity.ok(ticketToUpdate);

    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllTickets(){

        ticketService.deleteAllTickets();

        return ResponseEntity.ok("All tickets deleted!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicketById(@PathVariable String idToDelete){

       if(!ticketService.ticketExistsById(idToDelete)){
           ticketService.deleteTicketById(idToDelete);

           return ResponseEntity.ok("Ticket deleted!");
       }

       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
}   }

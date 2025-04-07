package com.example.Airport.controller;

import com.example.Airport.model.Plane;
import com.example.Airport.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Airport.repository.PlaneRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = "http://localhost:5173")
public class PlaneController {

    @Autowired
    PlaneService planeService;
    @Autowired
    PlaneRepository planeRepository;

    @GetMapping("/getPlanes")
    public ResponseEntity<List<Plane>> getAllPlanes() {

        List<Plane> planes = planeService.getAllPlanes();

        if(planes.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(planes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable String id){

        Optional<Plane> plane = planeService.getPLaneById(id);

        if(plane.isPresent()){

            return ResponseEntity.ok(plane.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping("/createPlane")
    public ResponseEntity<List<Plane>> createPlanes(@RequestBody List<Plane> planes) {
        List<Plane> savedPlanes = planeRepository.saveAll(planes);
        return ResponseEntity.ok(savedPlanes);
    }

    @PutMapping("/updatePlane/{id}")
    public ResponseEntity<Plane> updatePlane(@PathVariable String id, @RequestBody Plane plane){

        Plane updatedPlane = planeService.updatePlane(id,plane);

        return ResponseEntity.ok(updatedPlane);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAllPlanes(){

        planeService.deleteAllPlanes();

        return ResponseEntity.ok("All planes deleted");
    }

    @DeleteMapping("/deletePlane/{id}")
    public ResponseEntity<String> deletePlaneById(@PathVariable("id") String idToDelete){

       if(planeService.planeExistsById(idToDelete)){

           planeService.deleteById(idToDelete);

           return ResponseEntity.ok("Plane deleted!");
       }

       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}

package com.example.Airport.service;

import com.example.Airport.model.Plane;
import com.example.Airport.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    public List<Plane> getAllPlanes(){

        return planeRepository.findAll();
    }

    public Optional <Plane> getPLaneById(String Id){

        return planeRepository.findById(Id);
    }

    public void deleteById(String Id){

        planeRepository.deleteById(Id);
    }

    public Plane createPlane(Plane plane){

        return planeRepository.save(plane);
    }

    public Plane updatePlane(String id, Plane plane) {
        Plane planeToUpdate = planeRepository.findById(id).orElse(null);

        assert planeToUpdate != null;
        planeToUpdate.setModel(plane.getModel());
        planeToUpdate.setCapacity(plane.getCapacity());
        planeToUpdate.setManufacturer(plane.getManufacturer());
        planeToUpdate.setYearOfManufacture(plane.getYearOfManufacture());

        return planeRepository.save(planeToUpdate);
    }


    public void deleteAllPlanes(){

        planeRepository.deleteAll();
    }

    public boolean planeExistsById(String idToDelete){

        return planeRepository.existsById(idToDelete);
    }
}

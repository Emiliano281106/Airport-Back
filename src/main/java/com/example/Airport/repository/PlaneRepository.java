package com.example.Airport.repository;

import com.example.Airport.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, String> {
}

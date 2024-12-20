package com.example.vehicleservicetracker.repository;

import com.example.vehicleservicetracker.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}

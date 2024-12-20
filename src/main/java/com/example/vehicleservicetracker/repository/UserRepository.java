package com.example.vehicleservicetracker.repository;

import com.example.vehicleservicetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

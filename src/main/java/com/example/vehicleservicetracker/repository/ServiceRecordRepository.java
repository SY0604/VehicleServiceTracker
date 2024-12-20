package com.example.vehicleservicetracker.repository;

import com.example.vehicleservicetracker.model.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRecordRepository extends JpaRepository<ServiceRecord, Long> {
}

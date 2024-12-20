package com.example.vehicleservicetracker.controller;

import com.example.vehicleservicetracker.model.ServiceRecord;
import com.example.vehicleservicetracker.service.ServiceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceRecordController {
    @Autowired
    private ServiceRecordService serviceRecordService;

    @PostMapping("/log")
    public ServiceRecord logService(@RequestBody ServiceRecord serviceRecord) {
        return serviceRecordService.logService(serviceRecord);
    }

    @PutMapping("/schedule/{id}")
    public Optional<ServiceRecord> scheduleService(@PathVariable Long id, @RequestParam String date) {
        LocalDate serviceDate = LocalDate.parse(date);
        return serviceRecordService.scheduleService(id, serviceDate);
    }
}

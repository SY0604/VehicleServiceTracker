package com.example.vehicleservicetracker.service;

import com.example.vehicleservicetracker.model.ServiceRecord;
import com.example.vehicleservicetracker.repository.ServiceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ServiceRecordService {
    @Autowired
    private ServiceRecordRepository serviceRecordRepository;

    @Autowired
    private EmailService emailService;

    public ServiceRecord logService(ServiceRecord serviceRecord) {
        serviceRecord.setStatus("Scheduled");
        return serviceRecordRepository.save(serviceRecord);
    }

    public Optional<ServiceRecord> scheduleService(Long id, LocalDate serviceDate) {
        Optional<ServiceRecord> serviceRecordOpt = serviceRecordRepository.findById(id);
        if (serviceRecordOpt.isPresent()) {
            ServiceRecord serviceRecord = serviceRecordOpt.get();
            serviceRecord.setServiceDate(serviceDate);
            serviceRecord.setStatus("Scheduled");
            serviceRecordRepository.save(serviceRecord);

            // Send email notification
            String emailBody = "Your service appointment is scheduled for " + serviceDate + ".";
            emailService.sendEmail(serviceRecord.getVehicle().getOwner().getEmail(),
                    "Service Appointment Scheduled", emailBody);
        }
        return serviceRecordOpt;
    }
}

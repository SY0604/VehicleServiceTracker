package com.example.vehicleservicetracker.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private String licensePlate;

    @ManyToOne // Defines the relationship between Vehicle and User
    @JoinColumn(name = "owner_id") // Specifies the foreign key column in the database
    private User owner;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<ServiceRecord> serviceHistory;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public User getOwner() { // This method resolves the error
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<ServiceRecord> getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(List<ServiceRecord> serviceHistory) {
        this.serviceHistory = serviceHistory;
    }
}

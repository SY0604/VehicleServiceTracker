package com.example.vehicleservicetracker.service;

import com.example.vehicleservicetracker.model.User;
import com.example.vehicleservicetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}

package com.hem.fleet_management.service;

import com.hem.fleet_management.model.Driver;
import com.hem.fleet_management.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {
    @Autowired
    private DriverRepository repository;

    public Driver addDriver(Driver driver) {
        return repository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return repository.findAll();
    }
}
package com.hem.fleet_management.service;

import com.hem.fleet_management.model.*;
import com.hem.fleet_management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private DriverRepository driverRepository;

    public Trip createTrip(Long vehicleId, Long driverId, Trip tripDetails) {
        // 1. Find the Vehicle and Driver from DB
        Vehicle v = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        Driver d = driverRepository.findById(driverId).orElseThrow(() -> new RuntimeException("Driver not found"));

        // 2. Link them to the trip
        tripDetails.setVehicle(v);
        tripDetails.setDriver(d);
        
        // 3. Save
        return tripRepository.save(tripDetails);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
}
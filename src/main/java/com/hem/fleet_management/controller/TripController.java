package com.hem.fleet_management.controller;

import com.hem.fleet_management.model.Trip;
import com.hem.fleet_management.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TripController {
    @Autowired
    private TripService service;

    // We use @RequestParam to pass the IDs nicely in the URL
    // URL will look like: /api/admin/create-trip?vehicleId=1&driverId=2
    @PostMapping("/admin/create-trip")
    public Trip createTrip(@RequestParam Long vehicleId, 
                           @RequestParam Long driverId, 
                           @RequestBody Trip trip) {
        return service.createTrip(vehicleId, driverId, trip);
    }

    @GetMapping("/public/trips")
    public List<Trip> getAllTrips() {
        return service.getAllTrips();
    }
}
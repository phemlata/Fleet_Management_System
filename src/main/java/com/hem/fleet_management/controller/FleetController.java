package com.hem.fleet_management.controller;

import com.hem.fleet_management.model.Vehicle;
import com.hem.fleet_management.service.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FleetController {

    @Autowired
    private FleetService service;

    // Accessible by ADMIN and USER
    @GetMapping("/public/vehicles")
    public List<Vehicle> getVehicles() {
        return service.getAllVehicles();
    }

    // Accessible ONLY by ADMIN (RBAC in action)
    @PostMapping("/admin/add-vehicle")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return service.addVehicle(vehicle);
    }
}
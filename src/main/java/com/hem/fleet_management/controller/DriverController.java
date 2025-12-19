package com.hem.fleet_management.controller;

import com.hem.fleet_management.model.Driver;
import com.hem.fleet_management.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverController {
    @Autowired
    private DriverService service;

    @PostMapping("/admin/add-driver")
    public Driver addDriver(@RequestBody Driver driver) {
        return service.addDriver(driver);
    }

    @GetMapping("/public/drivers")
    public List<Driver> getDrivers() {
        return service.getAllDrivers();
    }
}
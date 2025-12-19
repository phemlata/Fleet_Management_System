package com.hem.fleet_management.controller;

import com.hem.fleet_management.service.FleetService;
import com.hem.fleet_management.service.DriverService;
import com.hem.fleet_management.service.TripService;
import com.hem.fleet_management.model.Vehicle;
import com.hem.fleet_management.model.Driver;
import com.hem.fleet_management.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired private FleetService fleetService;
    @Autowired private DriverService driverService;
    @Autowired private TripService tripService;

    // --- DASHBOARD ---
    @GetMapping("/")
    public String dashboard() { return "index"; }

    // --- VEHICLES ---
    @GetMapping("/vehicles")
    public String viewVehicles(Model model) {
        model.addAttribute("vehicles", fleetService.getAllVehicles());
        return "vehicles";
    }

    @GetMapping("/add-vehicle")
    public String showAddVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "add-vehicle";
    }

    @PostMapping("/save-vehicle")
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        fleetService.addVehicle(vehicle);
        return "redirect:/vehicles";
    }

    // --- DRIVERS ---
    @GetMapping("/drivers")
    public String viewDrivers(Model model) {
        model.addAttribute("drivers", driverService.getAllDrivers());
        return "drivers"; // You will create drivers.html next
    }

    @GetMapping("/add-driver")
    public String showAddDriverForm(Model model) {
        model.addAttribute("driver", new Driver());
        return "add-driver"; // You will create add-driver.html next
    }

    @PostMapping("/save-driver")
    public String saveDriver(@ModelAttribute("driver") Driver driver) {
        driverService.addDriver(driver);
        return "redirect:/drivers";
    }

    // --- TRIPS ---
    @GetMapping("/trips")
    public String viewTrips(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "trips"; // You will create trips.html next
    }

    @GetMapping("/create-trip")
    public String showCreateTripForm(Model model) {
        // We need to send Vehicles and Drivers to the page for the Dropdowns
        model.addAttribute("trip", new Trip());
        model.addAttribute("vehicles", fleetService.getAllVehicles());
        model.addAttribute("drivers", driverService.getAllDrivers());
        return "create-trip";
    }

    @PostMapping("/save-trip")
    public String saveTrip(@RequestParam Long vehicleId, 
                           @RequestParam Long driverId, 
                           @ModelAttribute("trip") Trip trip) {
        tripService.createTrip(vehicleId, driverId, trip);
        return "redirect:/trips";
    }
}
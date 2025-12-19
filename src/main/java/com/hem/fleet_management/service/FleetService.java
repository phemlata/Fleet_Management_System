package com.hem.fleet_management.service;

import com.hem.fleet_management.model.Vehicle;
import com.hem.fleet_management.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class FleetService {

    @Autowired
    private VehicleRepository repository;

    // RESUME POINT: Multithreading via ExecutorService
    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        // 1. Save to DB (Synchronous)
        Vehicle saved = repository.save(vehicle);

        // 2. Send Alert (Asynchronous/Multithreaded)
        // This ensures the API is fast and doesn't wait for the email/alert to send
        executor.submit(() -> {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " processing alert for: " + saved.getLicensePlate());
                Thread.sleep(2000); // Simulate email sending delay
                System.out.println("Alert Sent!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return saved;
    }
}
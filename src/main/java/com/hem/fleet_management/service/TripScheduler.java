package com.hem.fleet_management.service;

import com.hem.fleet_management.model.Trip;
import com.hem.fleet_management.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class TripScheduler {

    @Autowired
    private TripRepository tripRepository;

    // Runs every 10 seconds for demonstration (In real life: @Scheduled(cron = "0 0 0 * * ?") for daily)
    @Scheduled(fixedRate = 10000)
    public void checkCompletedTrips() {
        List<Trip> activeTrips = tripRepository.findAll();
        
        for (Trip trip : activeTrips) {
            // If trip is 'Ongoing' but the time has passed
            if ("Ongoing".equals(trip.getStatus()) && LocalDateTime.now().isAfter(trip.getEndTime())) {
                
                trip.setStatus("Completed");
                tripRepository.save(trip);
                
                // Interview Point: In a real system, you would also set the 
                // Vehicle and Driver status back to "Available" here.
                System.out.println("✅ SYSTEM AUTO-UPDATE: Trip " + trip.getId() + " marked as Completed.");
            }
        }
    }
}
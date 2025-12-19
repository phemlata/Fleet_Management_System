package com.hem.fleet_management.service;

import com.hem.fleet_management.model.Vehicle;
import com.hem.fleet_management.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FleetServiceTest {

    @Mock
    private VehicleRepository repository; // Fake Database

    @InjectMocks
    private FleetService service; // The Service we are testing

    @Test
    public void testGetAllVehicles() {
        // 1. Arrange (Prepare fake data)
        Vehicle v1 = new Vehicle();
        v1.setModel("Tata Truck");
        
        Vehicle v2 = new Vehicle();
        v2.setModel("Mahindra Pickup");

        when(repository.findAll()).thenReturn(Arrays.asList(v1, v2));

        // 2. Act (Call the method)
        List<Vehicle> vehicles = service.getAllVehicles();

        // 3. Assert (Check if result is correct)
        assertEquals(2, vehicles.size());
        assertEquals("Tata Truck", vehicles.get(0).getModel());
        
        System.out.println("✅ TEST PASSED: FleetService fetched 2 vehicles correctly.");
    }
}
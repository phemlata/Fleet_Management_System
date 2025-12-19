package com.hem.fleet_management.repository;
import com.hem.fleet_management.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {}
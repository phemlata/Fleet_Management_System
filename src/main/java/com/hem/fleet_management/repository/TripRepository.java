package com.hem.fleet_management.repository;
import com.hem.fleet_management.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {}
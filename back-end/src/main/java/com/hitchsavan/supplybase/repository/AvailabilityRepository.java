package com.hitchsavan.supplybase.repository;

import com.hitchsavan.supplybase.models.Availability;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
        
}

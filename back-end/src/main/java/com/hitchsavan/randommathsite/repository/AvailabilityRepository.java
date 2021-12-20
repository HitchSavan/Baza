package com.hitchsavan.randommathsite.repository;

import com.hitchsavan.randommathsite.models.Availability;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
        
}

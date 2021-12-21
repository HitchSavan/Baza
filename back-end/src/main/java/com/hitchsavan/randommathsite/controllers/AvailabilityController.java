package com.hitchsavan.randommathsite.controllers;

import java.util.List;

import com.hitchsavan.randommathsite.models.Availability;
import com.hitchsavan.randommathsite.repository.AvailabilityRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    
    private final AvailabilityRepository availabilityRepository;

    public AvailabilityController(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @GetMapping
    public List<Availability> getAvailabilities() {
        return (List<Availability>) availabilityRepository.findAll();
    }
    
    @PostMapping
    void addAvailability(@RequestBody Availability availability) {
        availabilityRepository.save(availability);
    }

    /*
    @PutMapping(path = "id")
    void updateAvailability(@PathVariable("id") AvailabilityId id,
                            @RequestParam(required = false) long amount) {
        Availability availability = availabilityRepository.findAllById(id)
            .orElseThrow(() -> new IllegalStateException(
                "I'm broken, I dunno"
            ));
    }
    */
}

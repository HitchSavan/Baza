package com.hitchsavan.randommathsite.controllers;

import java.util.List;

import com.hitchsavan.randommathsite.models.AvailabilityProduct;
import com.hitchsavan.randommathsite.repository.AvailabilityProductRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products_availability")
public class AvailabilityProductController {
    
    private final AvailabilityProductRepository availabilityProductRepository;

    public AvailabilityProductController(AvailabilityProductRepository availabilityProductRepository) {
        this.availabilityProductRepository = availabilityProductRepository;
    }

    @GetMapping
    public List<AvailabilityProduct> getAvailabilityProducts() {
        return (List<AvailabilityProduct>) availabilityProductRepository.findAll();
    }
    
    @PostMapping
    void addAvailabilityProduct(@RequestBody AvailabilityProduct availabilityProduct) {
        availabilityProductRepository.save(availabilityProduct);
    }
}
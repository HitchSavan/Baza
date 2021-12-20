package com.hitchsavan.randommathsite.repository;

import com.hitchsavan.randommathsite.models.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}

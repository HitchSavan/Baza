package com.hitchsavan.supplybase.repository;

import com.hitchsavan.supplybase.models.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    
}

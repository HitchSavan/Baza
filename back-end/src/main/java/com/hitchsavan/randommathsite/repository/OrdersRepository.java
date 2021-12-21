package com.hitchsavan.randommathsite.repository;

import com.hitchsavan.randommathsite.models.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    
}

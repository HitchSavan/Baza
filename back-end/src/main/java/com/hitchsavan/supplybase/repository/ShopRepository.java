package com.hitchsavan.supplybase.repository;

import java.util.Optional;

import com.hitchsavan.supplybase.models.Shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findByName(String name);
}

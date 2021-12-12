package com.hitchsavan.randommathsite.repository;

import java.util.Optional;

import com.hitchsavan.randommathsite.models.Shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findByName(String name);
}

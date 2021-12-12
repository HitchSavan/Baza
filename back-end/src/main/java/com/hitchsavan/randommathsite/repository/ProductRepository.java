package com.hitchsavan.randommathsite.repository;

import java.util.Optional;

import com.hitchsavan.randommathsite.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findByName(String name);
}

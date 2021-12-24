package com.hitchsavan.supplybase.repository;

import java.util.Optional;

import com.hitchsavan.supplybase.models.ERole;
import com.hitchsavan.supplybase.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

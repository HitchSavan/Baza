package com.hitchsavan.randommathsite.repository;

import java.util.Optional;

import com.hitchsavan.randommathsite.models.ERole;
import com.hitchsavan.randommathsite.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

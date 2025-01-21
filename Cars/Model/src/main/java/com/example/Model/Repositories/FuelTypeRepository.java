package com.example.Model.Repositories;

import com.example.Model.Entities.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {
    Optional<FuelType> findByName(String name);
}

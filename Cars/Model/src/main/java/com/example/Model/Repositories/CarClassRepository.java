package com.example.Model.Repositories;

import com.example.Model.Entities.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarClassRepository extends JpaRepository<CarClass, Long> {
    Optional<CarClass> findByName(String name);
}

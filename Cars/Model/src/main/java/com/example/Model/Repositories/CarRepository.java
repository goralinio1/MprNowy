package com.example.Model.Repositories;

import com.example.Model.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByCarModelId(Long carModelId);

    List<Car> findByCarClassId(Long carClassId);

    List<Car> findByFuelTypeId(Long fuelTypeId);

    List<Car> findByDrive(String drive);

    List<Car> findByTransmission(String transmission);
}

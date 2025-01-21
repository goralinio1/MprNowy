package com.example.Model.Repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogData implements ICatalogData {

    private final ProducerRepository producerRepository;
    private final CarModelRepository carModelRepository;
    private final CarClassRepository carClassRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final CarRepository carRepository;

    public CatalogData(ProducerRepository producerRepository,
                       CarModelRepository carModelRepository,
                       CarClassRepository carClassRepository,
                       FuelTypeRepository fuelTypeRepository,
                       CarRepository carRepository) {
        this.producerRepository = producerRepository;
        this.carModelRepository = carModelRepository;
        this.carClassRepository = carClassRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.carRepository = carRepository;
    }

    @Override
    public ProducerRepository getProducerRepository() {
        return producerRepository;
    }

    @Override
    public CarModelRepository getCarModelRepository() {
        return carModelRepository;
    }

    @Override
    public CarClassRepository getCarClassRepository() {
        return carClassRepository;
    }

    @Override
    public FuelTypeRepository getFuelTypeRepository() {
        return fuelTypeRepository;
    }

    @Override
    public CarRepository getCarRepository() {
        return carRepository;
    }
}
